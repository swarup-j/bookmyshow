package com.application.nextshow.controllers;


import com.application.nextshow.dtos.LoginDTO;
import com.application.nextshow.dtos.UserDTO;
import com.application.nextshow.entities.User;
import com.application.nextshow.entities.enums.RoleType;
import com.application.nextshow.services.EmailService;
import com.application.nextshow.services.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDateTime;
import java.util.UUID;


@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    private final EmailService emailService;

    private final  PasswordEncoder passwordEncoder;

    public AuthController(UserService userService, EmailService emailService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.emailService = emailService;
        this.passwordEncoder = passwordEncoder;
    }

    // Endpoint for user registration
    @PostMapping("/register")
    public String registerUser(@RequestBody UserDTO userDTO) {
        if (userService.existsByEmail(userDTO.getEmail())) {
            return "Email is already registered.";
        }

        User user = User.builder()
                .firstname(userDTO.getFirstname())
                .lastname(userDTO.getLastname())
                .address(userDTO.getAddress())
                .email(userDTO.getEmail())
                .phone(userDTO.getPhone())
                .birthDate(userDTO.getBirthDate())
                .password(passwordEncoder.encode(userDTO.getPassword()))
                .role(RoleType.USER)
                .created(LocalDateTime.now())
                .updated(LocalDateTime.now())
                .build();

        userService.saveUser(user);
        return "User registered successfully.";
    }


    // Endpoint for user login
    @PostMapping("/login")
    public String loginUser(@RequestBody LoginDTO loginDTO) {
        User user = userService.findByEmail(loginDTO.getEmail())
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        if (passwordEncoder.matches(loginDTO.getPassword(), user.getPassword())) {
            return "Login successful.";
        }
        return "invalid username or password";
    }

    // Endpoint to initiate forgot password
    @PostMapping("/forgot-password")
    public String forgotPassword(@RequestParam String email) {
        User user = userService.findByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        String resetToken = UUID.randomUUID().toString();
        user.setResetPasswordToken(resetToken);
        user.setResetPasswordGeneratedAt(LocalDateTime.now());
        userService.updateUser(user);

        String resetLink = "http://localhost:8080/auth/reset-password?token=" + resetToken;
        emailService.sendEmail(email, "Password Reset Request", "Click the link to reset your password: " + resetLink);

        return "Password reset email sent.";
    }

    // Endpoint to reset the password
    @PostMapping("/reset-password")
    public String resetPassword(@RequestParam String token, @RequestParam String newPassword) {
        User user = userService.findByResetToken(token)
                .orElseThrow(() -> new EntityNotFoundException("Invalid or expired token."));
        LocalDateTime tokenGenerationTime = user.getResetPasswordGeneratedAt();


        if ( tokenGenerationTime.plusMinutes(1).isBefore(LocalDateTime.now())) {
            throw new EntityNotFoundException("Reset token has expired.");
        }

        user.setPassword(passwordEncoder.encode(newPassword));
        user.setResetPasswordToken(null);
        user.setResetPasswordGeneratedAt(null);
        userService.updateUser(user);

        return "Password reset successfully.";
    }

    @PostMapping("/change-password")
    public String changePassword(@RequestParam String email, @RequestParam String currentPassword, @RequestParam String newPassword){
        User user = userService.findByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        if (passwordEncoder.matches(currentPassword, user.getPassword())) {
            user.setPassword(passwordEncoder.encode(newPassword));
            userService.updateUser(user);
            return "password reset successfully";

        }
        else return "invalid username or password";

    }
    // Endpoint for Google OAuth (placeholder for integration)
    @GetMapping("/oauth2/google")
    public String googleOAuthRedirect() {
        // Placeholder for Google OAuth integration.
        return "Redirecting to Google OAuth...";
    }
}
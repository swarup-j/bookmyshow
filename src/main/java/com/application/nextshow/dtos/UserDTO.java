package com.application.nextshow.dtos;

import com.application.nextshow.entities.enums.RoleType;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private String firstname;
    private String lastname;
    private String address;
    private String email;
    private Long phone;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate birthDate;
//    private String password;
//    private String resetPasswordToken;
//
//    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
//    private Date resetPasswordGeneratedAt;
    private RoleType role;

}


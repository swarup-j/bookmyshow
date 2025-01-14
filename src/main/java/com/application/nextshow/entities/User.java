package com.application.nextshow.entities;

import com.application.nextshow.entities.enums.RoleType;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.PrimitiveIterator;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable = false)
    private String firstname;
    private String lastname;
    private String address;
    private String email;
    @Column(nullable = false)
    private Long phone;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate birthDate;
    private String password;
    private String resetPasswordToken;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date resetPasswordGeneratedAt;

    private RoleType role;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime created;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updated;

}

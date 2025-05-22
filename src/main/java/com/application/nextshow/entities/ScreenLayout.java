package com.application.nextshow.entities;

import com.fasterxml.jackson.databind.JsonNode;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;


import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcType;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.UUID;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor

public class ScreenLayout {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;


    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb") // Specify JSONB column type
    private JsonNode layout;

    // Getters and setters (or use Lombok if preferred)


}

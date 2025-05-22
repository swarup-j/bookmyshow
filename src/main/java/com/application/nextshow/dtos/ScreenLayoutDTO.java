package com.application.nextshow.dtos;


import com.fasterxml.jackson.databind.JsonNode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO class for creating a new Product request.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScreenLayoutDTO {
    private String name;
    private JsonNode layout;
}

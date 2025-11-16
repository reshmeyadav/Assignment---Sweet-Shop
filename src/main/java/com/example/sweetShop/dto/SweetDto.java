package com.example.sweetShop.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SweetDto {
    private Long id;

    @NotBlank
    private String name;
    private String category;

    @NotNull @Min(0)
    private Double price;

    @NotNull @Min(0)
    private Integer quantity;
}


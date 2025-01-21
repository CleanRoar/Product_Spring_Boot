package org.example.product_spring_boot.Dto;

import lombok.Builder;
import lombok.Setter;

@Setter
public class ResponseDto {
    private String productName;
    private double productPrice;
    private Long stock;
}

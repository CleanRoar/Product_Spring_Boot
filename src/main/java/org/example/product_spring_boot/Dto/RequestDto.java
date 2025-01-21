package org.example.product_spring_boot.Dto;


import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RequestDto {
    private String productName;
    private double productPrice;
    private Long stock;
}

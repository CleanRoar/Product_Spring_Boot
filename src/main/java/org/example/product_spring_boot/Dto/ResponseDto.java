package org.example.product_spring_boot.Dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
public class ResponseDto {
    private String productName;
    private double productPrice;
    private Long stock;
}

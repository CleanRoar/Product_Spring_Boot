package org.example.product_spring_boot.Controller;


import lombok.RequiredArgsConstructor;
import org.example.product_spring_boot.Dto.RequestDto;
import org.example.product_spring_boot.Service.ProductService;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/product")
public class Controller {
    private final ProductService service;


    @PostMapping
    public void addProduct(@RequestBody RequestDto dto){
        service.addProduct(dto);
    }
}

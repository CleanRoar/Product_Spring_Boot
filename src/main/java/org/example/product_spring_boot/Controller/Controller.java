package org.example.product_spring_boot.Controller;


import lombok.RequiredArgsConstructor;
import org.example.product_spring_boot.Dto.RequestDto;
import org.example.product_spring_boot.Dto.ResponseDto;
import org.example.product_spring_boot.Service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/product")
public class Controller {
    private final ProductService service;


    @PostMapping
    public void addProduct(@RequestBody RequestDto dto){
       service.addProduct(dto);
    }


    @GetMapping
    public List<ResponseDto> getProducts(){
        return service.getProducts();
    }

    @GetMapping("{id}")
    public ResponseDto findById(@PathVariable Long id){
        return service.findById(id);
    }
}

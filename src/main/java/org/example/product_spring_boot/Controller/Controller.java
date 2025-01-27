package org.example.product_spring_boot.Controller;


import lombok.RequiredArgsConstructor;
import org.example.product_spring_boot.Dao.Entity.ProductEntity;
import org.example.product_spring_boot.Dao.Repository.ProductRepository;
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
    private final ProductRepository repository;


    @PostMapping
    public void addProduct(@RequestBody RequestDto dto){
       service.addProduct(dto);
    }
//
//
//    @GetMapping("pr")
//    public List<ResponseDto> getProducts(){
//        return service.getProducts();
//    }
//
//    @GetMapping("/pr/{id}")
//    public ResponseDto findById(@PathVariable Long id){
//        return service.findById(id);
//    }
//
//    @PutMapping("prPut/{id}")
//    public Long uptade (@RequestBody RequestDto dto , @PathVariable Long id){
//        return  service.uptadeProduct(dto,id);
//    }


      @GetMapping    //GET http://localhost:8080/products?minPrice=10&maxPrice=50
      public List<ProductEntity> qiymetAraligiGetir(@RequestParam double min,@RequestParam double max){
      return repository.araliqQiymetiTap(min,max);
      }

      @GetMapping("/axtaris") //GET http://localhost:8080/products/search?keyword=apple
      public List<ProductEntity> keywordGoreAxtaris(@RequestParam String axtaris){
          return repository.keywordIleAxtaris(axtaris);
      }

      @GetMapping("/count")
      public long butunMehsullar(){
        return repository.countButunMehsullar();
      }

      @GetMapping("max")
      public ProductEntity enYuksekQiymet (){
        return repository.findTopByOrderByProductPriceDesc().orElse(null);
      }

      @GetMapping("created")
      public List<ProductEntity> yaranmaSiralamasi(){
        return repository.  findTop3ByOrderByCreatedAtDesc();

      }

      @GetMapping("average")
      public Long edediOrta(){
        return repository.mehsulEdediOrta();
      }

      @GetMapping("join")
      List<Object[]> findAllProductsWithCategory(){
        return  repository.findAllProductsWithCategory();
      }


}
package org.example.product_spring_boot.Dao.Repository;

import org.example.product_spring_boot.Dao.Entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Long> {

   @Query("select u from ProductEntity u where u.productPrice between :minProductPrice and :maxProductPrice")
    List<ProductEntity> araliqQiymetiTap
           (@Param("minProductPrice")double minProductPrice
           ,@Param ("maxProductPrice")double maxProductPrice);

   @Query("select u from ProductEntity u where u.productName like %:axtaris%")
    List<ProductEntity> keywordIleAxtaris(@Param("axtaris")String axtaris);

   @Query("select count(u) from ProductEntity u")
    long countButunMehsullar();


    Optional<ProductEntity> findTopByOrderByProductPriceDesc();

    List<ProductEntity> findTop3ByOrderByCreatedAtDesc();

    @Query("select avg(u.productPrice) from ProductEntity u ")
    long mehsulEdediOrta();



    @Query("select p.productName ,p.productPrice , c.id, c.name from ProductEntity p join Catagory c on p.catogory_id=c.id")
    List<Object[]> findAllProductsWithCategory();









}

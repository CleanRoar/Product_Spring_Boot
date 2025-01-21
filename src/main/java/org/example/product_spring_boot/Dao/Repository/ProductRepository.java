package org.example.product_spring_boot.Dao.Repository;

import org.example.product_spring_boot.Dao.Entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Long> {
}

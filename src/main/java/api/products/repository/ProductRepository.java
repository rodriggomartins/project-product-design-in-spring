package api.products.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;


import api.products.models.ProductModel;

public interface ProductRepository extends JpaRepository<ProductModel, UUID> {

}

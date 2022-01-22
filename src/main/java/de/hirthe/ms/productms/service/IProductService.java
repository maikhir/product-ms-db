package de.hirthe.ms.productms.service;

import de.hirthe.ms.productms.model.Product;

import java.util.List;

public interface IProductService {
    Product saveProduct(Product product);

    void deleteProduct(Long productId);

    List<Product> findAllProduct();
}

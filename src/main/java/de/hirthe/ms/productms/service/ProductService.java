package de.hirthe.ms.productms.service;

import de.hirthe.ms.productms.model.Product;
import de.hirthe.ms.productms.repository.IProductRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProductService implements IProductService
{

    private final IProductRepository productRepository;

    public ProductService(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product saveProduct(Product product) {
        product.setCreate_time(LocalDateTime.now());
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long productId){
        productRepository.deleteById(productId);
    }

    @Override
    public List<Product> findAllProduct() {
        return productRepository.findAll();
    }
}

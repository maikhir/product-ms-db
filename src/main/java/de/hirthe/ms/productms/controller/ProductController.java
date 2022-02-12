package de.hirthe.ms.productms.controller;

import de.hirthe.ms.productms.model.Product;
import de.hirthe.ms.productms.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/product")
@RefreshScope
public class ProductController {

    @Autowired
    private IProductService productService;

    @Value("${test.name}")
    private String testName;

    @GetMapping("/name") //api/product/name
    @ResponseStatus(HttpStatus.OK)
    public String getName() {
        return testName;
    }

    @PostMapping // api/product
    @ResponseStatus(HttpStatus.CREATED)
    public Product saveProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @DeleteMapping("{productId}") //-> api/product/productId
    @ResponseStatus(HttpStatus.OK)
    public void deleteProduct(@PathVariable Long productId) {
        productService.deleteProduct(productId);
    }

    @GetMapping // api/product
    @ResponseStatus(HttpStatus.OK)
    public List<Product> getAllProducts() {
        return productService.findAllProduct();
    }
}

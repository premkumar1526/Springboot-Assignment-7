package com.example.microservices1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import com.example.microservices.Product;
import com.example.microservices.ProductData;

import java.util.List;
 
@RestController
@CrossOrigin
@RequestMapping("/api/customers")
public class CustomerServiceResource {
 
    private final RestTemplate restTemplate;
    private final String productServiceUrl;
 
    public CustomerServiceResource(RestTemplate restTemplate, @Value("${product.service.url}") String productServiceUrl) {
        this.restTemplate = restTemplate;
        this.productServiceUrl = productServiceUrl;
    }
 
    @GetMapping("/")
    public List<Product> getAllProducts() {
        // Communicate with product-service to get all products
        return restTemplate.getForObject(productServiceUrl + "/api/products/", ProductData.class).getProduct();
    }
 
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable long id) {
        // Communicate with product-service to get a product by ID
        return restTemplate.getForObject(productServiceUrl + "/api/products/" + id, Product.class);
    }
 
    @SuppressWarnings("unchecked")
	@GetMapping("/findByName/{name}")
    public List<Product> getProductsByName(@PathVariable String name) {
        // Communicate with product-service to get products by name
        return restTemplate.getForObject(productServiceUrl + "/api/products/findByName/" + name, List.class);
    }
 
    @PostMapping("/add")
    public Product addNewProduct(@RequestBody Product product) {
        // Communicate with product-service to add a new product
        return restTemplate.postForObject(productServiceUrl + "/api/products/add", product, Product.class);
    }
 
    @PutMapping("/update/{id}")
    public Product updateProduct(@PathVariable long id, @RequestBody Product updatedProduct) {
        // Communicate with product-service to update a product
        restTemplate.put(productServiceUrl + "/api/products/update/" + id, updatedProduct);
        return updatedProduct;
    }
 
    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable long id) {
        // Communicate with product-service to delete a product
        restTemplate.delete(productServiceUrl + "/api/products/delete/" + id);
    }
}

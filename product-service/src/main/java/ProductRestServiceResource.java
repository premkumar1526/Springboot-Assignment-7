package com.example.microservices;

import org.springframework.web.bind.annotation.*;
 
import java.util.List;
 
@RestController
@CrossOrigin
@RequestMapping("/api/products")
public class ProductRestServiceResource {
 
    private final ProductService productService;
	
	public ProductRestServiceResource(ProductService productService) {
        this.productService = productService;
    }
 
    @GetMapping("/")
    public List<Product> findAllProducts() {
        return productService.getAllProducts();
    }
 
    @GetMapping("/{id}")
    public Product findById(@PathVariable long id) {
        return productService.getProductById(id);
    }
 
    @GetMapping("/findByName/{name}")
    public List<Product> findByName(@PathVariable String name) {
        return productService.getProductsByName(name);
    }
 
    @PostMapping("/add")
    public Product addNewProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }
 
    @PutMapping("/update/{id}")
    public Product updateProduct(@PathVariable long id, @RequestBody Product updatedProduct) {
        return productService.updateProduct(id, updatedProduct);
    }
 
    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable long id) {
        productService.deleteProduct(id);
    }

	public ProductService getProductService() {
		return productService;
	}
}
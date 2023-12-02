package com.example.microservices;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
 
@Service
public class ProductService {
 
    private final List<Product> products = new ArrayList<>();
 
    public List<Product> getAllProducts() {
        return products;
    }
 
    public Product getProductById(long id) {
        Optional<Product> foundProduct = products.stream().filter(product -> product.getProductId() == id).findFirst();
        return foundProduct.orElse(null);
    }
 
    public List<Product> getProductsByName(String name) {
        List<Product> foundProducts = new ArrayList<>();
        for (Product product : products) {
            if (product.getProductName().equalsIgnoreCase(name)) {
                foundProducts.add(product);
            }
        }
        return foundProducts;
    }
 
    public Product addProduct(Product product) {
        long newProductId = products.isEmpty() ? 1 : products.get(products.size() - 1).getProductId() + 1;
        product.setProductId(newProductId);
        products.add(product);
        return product;
    }
 
    public Product updateProduct(long id, Product updatedProduct) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductId() == id) {
                updatedProduct.setProductId(id);
                products.set(i, updatedProduct);
                return updatedProduct;
            }
        }
        return null;
    }
 
    public void deleteProduct(long id) {
        products.removeIf(product -> product.getProductId() == id);
    }
}
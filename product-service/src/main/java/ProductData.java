package com.example.microservices;

import java.util.ArrayList;
import java.util.List;

public class ProductData {
private static List<Product> products;
static {
products=new ArrayList<>();
products.add(new Product(10, "Laptop", 35000, "Dell I3"));
products.add(new Product(11, "Laptop", 250000, "Mac Book Pro"));
products.add(new Product(12, "Laptop", 75000, "Lenovo I5"));
products.add(new Product(13, "Mobile", 135000, "Samsung S22 Ultra"));
products.add(new Product(14, "Mobile", 156000, "Iphone 14 Pro Max 256GB"));
products.add(new Product(15, "Mobile", 45000, "Oneplus 10 Pro"));
products.add(new Product(16, "Tablet", 120000, "Ipad 5th Gen"));
products.add(new Product(17, "Tablet", 59000, "Samsung A7 Tablet"));
products.add(new Product(18, "Keyboard", 12000, "Apple Magic Keyboard"));
products.add(new Product(19, "Keyboard", 3500, "Dell Wireless keyboard"));
}
public static List<Product> findAll(){
return products;
}
public static void addProduct(Product product) {
products.add(product);
}
public static Product findById(int id) {
return products.stream()
.filter(product->product.getProductId()==id)
.findAny()
.orElse(null);
}
public static List<Product> findByProductName(String productName){
return products.stream()
.filter(product->product.getProductName().equals(productName))
.toList();
}
public static void removeProduct(int productId) {
products.removeIf(product->product.getProductId()==productId);
}
public static Product updateProduct(Product newProduct) {
products.replaceAll(product->product.getProductId()==newProduct.getProductId()?newProduct:product);
 System.out.println(products);
 if(products.contains(newProduct))
 return newProduct;
 else
 return null;
}
public List<Product> getProduct() {
	return null;
}
}
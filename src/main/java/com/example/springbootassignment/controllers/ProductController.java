package com.example.springbootassignment.controllers;

import com.example.springbootassignment.beans.ResponseHandler;
import com.example.springbootassignment.models.Product;
import com.example.springbootassignment.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public ResponseEntity<?> getAllProducts() {
        return ResponseHandler.createResponse("Found Products", HttpStatus.OK, productService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProduct(@PathVariable int id) {
        Product product = productService.getProduct(id);
        return ResponseHandler.createResponse("Found Product", HttpStatus.OK, product);
    }

    @PostMapping("/")
    public ResponseEntity<?> createProduct(@RequestBody Product product) {
        Object createdProduct = productService.createProduct(product);
        return ResponseHandler.createResponse("Product Created", HttpStatus.CREATED, createdProduct);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable int id, @RequestBody Product product) {
        Product updatedProduct = productService.updateProduct(id, product);
        return ResponseHandler.createResponse("Product Updated", HttpStatus.OK, updatedProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);
        return ResponseHandler.deleteResponse("Product Deleted", HttpStatus.OK);
    }
}

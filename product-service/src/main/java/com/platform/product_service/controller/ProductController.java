package com.platform.product_service.controller;

import com.platform.product_service.entity.Product;
import com.platform.product_service.service.ProductService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.Parameter;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.List;

/**
 * REST Controller for managing Product-related operations.
 *
 * Exposes CRUD APIs for Product entity.
 * Base URL: /products
 */
@RestController
@RequestMapping("/products")
@Tag(name = "Product API", description = "Operations related to products")
public class ProductController {

    private final ProductService productService;

    /**
     * Constructor-based Dependency Injection (Recommended over @Autowired field injection)
     */
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /**
     * Fetch all products from database
     */
    @Operation(summary = "Get all products", description = "Retrieve all products available in the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved products"),
            @ApiResponse(responseCode = "204", description = "No products found")
    })
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();

        if (products.isEmpty()) {
            return ResponseEntity.noContent().build(); // 204
        }
        return ResponseEntity.ok(products); // 200
    }

    /**
     * Fetch a product by its ID
     */
    @Operation(summary = "Get product by ID", description = "Retrieve a specific product using its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product found"),
            @ApiResponse(responseCode = "404", description = "Product not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(
            @Parameter(description = "ID of the product to be retrieved", example = "1")
            @PathVariable Long id) {

        Product product = productService.getProduct(id);

        if (product == null) {
            return ResponseEntity.notFound().build(); // 404
        }
        return ResponseEntity.ok(product); // 200
    }

    /**
     * Create a new product
     */
    @Operation(summary = "Create product", description = "Add a new product to the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Product created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input data")
    })
    @PostMapping
    public ResponseEntity<Product> createProduct(
            @Valid @RequestBody Product product) {

        Product createdProduct = productService.createProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct); // 201
    }

    /**
     * Delete a product by ID
     */
    @Operation(summary = "Delete product", description = "Remove a product from the database using its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Product deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Product not found")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(
            @Parameter(description = "ID of the product to be deleted", example = "1")
            @PathVariable Long id) {

        productService.deleteProduct(id);
        return ResponseEntity.noContent().build(); // 204
    }
}
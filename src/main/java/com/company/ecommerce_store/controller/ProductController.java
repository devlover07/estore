package com.company.ecommerce_store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.ecommerce_store.exceptions.ProductNotExistException;
import com.company.ecommerce_store.models.Product;
import com.company.ecommerce_store.services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	private ProductService productService;
	
	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@GetMapping("/{id}")
	public Product getSingleProduct(@PathVariable("id") Long id) throws ArithmeticException, ProductNotExistException {
		// throw new RuntimeException("Something has gone wrong!");
//		int a = 1 / 0;
		return productService.getSingleProduct(id);
	}
	
	@GetMapping()
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}
	
	@PostMapping()
	public Product addNewProduct(@RequestBody Product product) {
		return productService.addNewProduct(product);
	}
	
	@PatchMapping("/{id}")
	public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product product) {
		return productService.updateProduct(id, product);
	}
	
	@PutMapping("/{id}")
	public Product replaceProduct(@PathVariable("id") Long id, @RequestBody Product product) {
		return productService.replaceProduct(id, product);
	}
	
	@DeleteMapping("/{id}")
	public void deleteProduct(@PathVariable("id") Long id) {
		productService.deleteProduct(id);
	}
	
//	@ExceptionHandler(ProductNotExistException.class)
//	public ProductNotExistDto handleException() {
//		ProductNotExistDto productNotExistDto = new ProductNotExistDto();
//		productNotExistDto.setTitle("Exception");
//		productNotExistDto.setMessage("Product not Exist");
//		return productNotExistDto;
//	}
	
}

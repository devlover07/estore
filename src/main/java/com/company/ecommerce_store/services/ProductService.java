package com.company.ecommerce_store.services;

import java.util.List;

import com.company.ecommerce_store.exceptions.ProductNotExistException;
import com.company.ecommerce_store.models.Product;

public interface ProductService {
	public Product getSingleProduct(Long id) throws ArithmeticException, ProductNotExistException;
	public List<Product> getAllProducts();
	public Product addNewProduct(Product product);
	public Product updateProduct(Long id, Product pruduct);
	public Product replaceProduct(Long id, Product product);
	public void deleteProduct(Long id);
}

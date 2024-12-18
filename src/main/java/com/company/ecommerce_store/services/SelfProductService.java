package com.company.ecommerce_store.services;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.company.ecommerce_store.exceptions.ProductNotExistException;
import com.company.ecommerce_store.models.Category;
import com.company.ecommerce_store.models.Product;
import com.company.ecommerce_store.repositories.CategoryRepository;
import com.company.ecommerce_store.repositories.ProductRepository;

@Service("selfProductService")
//@Primary
public class SelfProductService implements ProductService {
	
	ProductRepository productRepository;
	CategoryRepository categoryRepository;
	public SelfProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
		this.productRepository = productRepository;
		this.categoryRepository = categoryRepository;
	}

	@Override
	public Product getSingleProduct(Long id) throws ArithmeticException, ProductNotExistException {
		// TODO Auto-generated method stub
		Optional<Product> productOptional = productRepository.findById(id);
		
		if(productOptional.isEmpty()) {
			throw new ProductNotExistException("Product with id: "+id+" doesn't exist!");
		}
		
		return productOptional.get();
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product addNewProduct(Product product) {
		
//		--------------------  1st method  -------------------------------
		
//		Category category = product.getCategory();
//		
//		if(category.getId() == null) {
//			Category savedCategory = categoryRepository.save(category);
//			product.setCategory(savedCategory);
//		}
		
//		------------------  2nd Method  ---------------------------------
		
		 Optional<Category> categoryOptional  = categoryRepository.findByName(product.getCategory().getName());
		 
		 if(categoryOptional.isEmpty()) {
			 Category saveCategory = categoryRepository.save(product.getCategory());
			 product.setCategory(saveCategory);
		 } else {
			 product.setCategory(categoryOptional.get());
		 }
		
		
		return productRepository.save(product);
	}

	@Override
	public Product updateProduct(Long id, Product pruduct) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product replaceProduct(Long id, Product product) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteProduct(Long id) {
		// TODO Auto-generated method stub
		
	}

}

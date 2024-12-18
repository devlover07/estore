package com.company.ecommerce_store;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.company.ecommerce_store.repositories.ProductRepository;

import jakarta.transaction.Transactional;

@SpringBootTest
class EcommerceStoreApplicationTests {
	
	ProductRepository productRepository;
	
	@Autowired
	public EcommerceStoreApplicationTests(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Test
	void contextLoads() {
	}

	@Test
//	@Transactional
	void testQueries() {
		productRepository.findByTitleContaining("abhishek");
//		productRepository.deleteByTitle("abhishek");
	}
}

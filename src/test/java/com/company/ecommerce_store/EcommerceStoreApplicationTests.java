package com.company.ecommerce_store;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.company.ecommerce_store.models.Product;
import com.company.ecommerce_store.projections.ProductWithIdAndTitleAndDesc;
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
//		productRepository.findByTitleContaining("abhishek");
//		productRepository.deleteByTitle("abhishek");
		
//		Projections Test
		List<ProductWithIdAndTitleAndDesc> products = productRepository.projectionTrial();
		
//		System.out.println(products);
		for(ProductWithIdAndTitleAndDesc p: products) {
//			System.out.println(p.getClass());
			System.out.println(p.getTitle());
			System.out.println(p.getDescription());
		}
		
		
//		Native SQL queries Test
//		List<Product> products2 = productRepository.nativeQueryTrial();
//		
//		for(Product p: products2) {
//			System.out.println(p.getId());
//			System.out.println(p.getTitle());
//			System.out.println(p.getDescription());
//		}
		
//		--------------------------- Passing Parameter Test -------------------------
//		First With Hql query
//		List<ProductWithIdAndTitleAndDesc> products3 = productRepository.paramWithHqlQuery(152L);
//		
//		for(ProductWithIdAndTitleAndDesc p: products3) {
//			System.out.println(p.getId());
//			System.out.println(p.getTitle());
//			System.out.println(p.getDescription());
//		}
		
//		Passing parameter test with native query
		
		List<ProductWithIdAndTitleAndDesc> products4 = productRepository.paramWithNativeSqlQuery(2L);
		
		for(ProductWithIdAndTitleAndDesc p: products4) {
			System.out.println(p.getId());
			System.out.println(p.getTitle());
			System.out.println(p.getDescription());
		}
	}
}

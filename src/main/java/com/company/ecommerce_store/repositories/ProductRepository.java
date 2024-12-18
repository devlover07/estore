package com.company.ecommerce_store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.ecommerce_store.models.Category;
import com.company.ecommerce_store.models.Product;
import java.util.List;
import java.util.Optional;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	@Override
	Optional<Product> findById(Long id);
	Product save(Product product);
	
	List<Product> findByTitle(String title);
	void deleteByTitle(String title);
	List<Product> findByTitleContaining(String title);
	List<Product> findByCategory(Category category); //Hibernate will automatically execute join quety for us.
}

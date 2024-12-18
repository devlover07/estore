package com.company.ecommerce_store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.company.ecommerce_store.models.Category;
import com.company.ecommerce_store.models.Product;
import com.company.ecommerce_store.projections.ProductWithIdAndTitleAndDesc;

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
	List<Product> findByCategory(Category category); //Hibernate will automatically execute join query for us.
	
//	---------------------- HQl queries demo -------------------
//	HQL query
	@Query("select p from Product p where p.id = 154")
	List<Product> hqlQueryTrial();
	
	
//	Projections demo
	@Query("select p.id as id, p.title as title, p.description as description from Product p where p.id = 152")
	List<ProductWithIdAndTitleAndDesc> projectionTrial();
	
//	---------------------------  Native sql queries ----------------------------
	
	@Query(value = "select * from product",nativeQuery = true)
	List<Product> nativeQueryTrial();
	
//	Passing Parameter Trial -> works on Hql as well as with native sql queries
	
	@Query("select p.id as id, p.title as title, p.description as description from Product p where p.id = :id")
	List<ProductWithIdAndTitleAndDesc> paramWithHqlQuery(@Param("id") Long id);
	
//	Passing parameter trial with native sql queries
	
	@Query(value = "select p.id as id, p.title as title, p.description as description from product where p.id = :id", nativeQuery = true)
	List<ProductWithIdAndTitleAndDesc> paramWithNativeSqlQuery(@Param("id") Long id);
}

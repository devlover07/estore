package com.company.ecommerce_store.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import com.company.ecommerce_store.dtos.FakeStoreProductDto;
import com.company.ecommerce_store.exceptions.ProductNotExistException;
import com.company.ecommerce_store.models.Category;
import com.company.ecommerce_store.models.Product;

@Service("fakeStoreProductService")
public class FakeStoreProductServcie implements ProductService {

//	private Class FakeStoreProductDto;
	private RestTemplate restTemplate;
	
	@Autowired
	public FakeStoreProductServcie(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	private Product convertFakeStoreDtoToProduct(FakeStoreProductDto fakeStoreProductDto) {
		Product product = new Product();
//		product.setId(fakeStoreProductDto.getId());
		product.setTitle(fakeStoreProductDto.getTitle());
		product.setDescription(fakeStoreProductDto.getDescription());
		product.setCategory(new Category());
		product.getCategory().setName(fakeStoreProductDto.getCategory());
		product.setImageUrl(fakeStoreProductDto.getImageUrl());
		product.setPrice(fakeStoreProductDto.getPrice());
		return product;
	}

	@Override
	public Product getSingleProduct(Long id) throws ArithmeticException, ProductNotExistException {
//		 int a = 1 / 0;
//		RestTemplate restTemplate = new RestTemplate();
		FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject("https://fakestoreapi.com/products/"+id, FakeStoreProductDto.class);
		
		if(fakeStoreProductDto == null) {
			throw new ProductNotExistException("Product with "+id+" does not exist");
		}
		
		return convertFakeStoreDtoToProduct(fakeStoreProductDto);
	}

	@Override
	public List<Product> getAllProducts() {
		
//		List<FakeStoreProductDto> response = restTemplate.getForObject(
//				"https://fakestoreapi.com/products", 
//				List<FakeStoreProductDto>.class
//			);
		
		FakeStoreProductDto[] response = restTemplate.getForObject(
				"https://fakestoreapi.com/products", 
				FakeStoreProductDto[].class
			);
		
		List<Product> list = new ArrayList<>();
		
		for(FakeStoreProductDto dto: response) {
			list.add(convertFakeStoreDtoToProduct(dto));
		}
		
		return list;
	}

	@Override
	public Product addNewProduct(Product product) {
		
		FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
//		fakeStoreProductDto.setId(product.getId());
		fakeStoreProductDto.setCategory(product.getCategory().getName());
		fakeStoreProductDto.setDescription(product.getDescription());
		fakeStoreProductDto.setImageUrl(product.getImageUrl());
		fakeStoreProductDto.setPrice(product.getPrice());
		fakeStoreProductDto.setTitle(product.getTitle());
		
		fakeStoreProductDto = restTemplate.postForObject("https://fakestoreapi.com/products", fakeStoreProductDto, FakeStoreProductDto.class);
		return convertFakeStoreDtoToProduct(fakeStoreProductDto);
	}

	@Override
	public Product updateProduct(Long id, Product pruduct) {
//		restTemplate.patch
		return null;
	}

	@Override
	public Product replaceProduct(Long id, Product product) {
		RequestCallback requestCallback = restTemplate.httpEntityCallback(product);
		ResponseExtractor<FakeStoreProductDto> responseExtractor = new HttpMessageConverterExtractor<>(FakeStoreProductDto.class, restTemplate.getMessageConverters());
		FakeStoreProductDto response = restTemplate.execute("https://fakestoreapi.com/products/" + id, HttpMethod.PUT, requestCallback, null);
		return convertFakeStoreDtoToProduct(response);
	}

	@Override
	public void deleteProduct(Long id) {
		// TODO Auto-generated method stub
		
	}

}

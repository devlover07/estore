package com.company.ecommerce_store.models;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseModel {
	private String title;
	private Double price;
	@ManyToOne
	private Category category;
	private String description;
	private String imageUrl;
}

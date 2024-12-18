package com.company.ecommerce_store.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Category extends BaseModel {
	@OneToMany(mappedBy = "category", cascade = CascadeType.REMOVE)
	private List<Product> products;
	private String name;
}

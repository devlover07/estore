package com.company.ecommerce_store.inheritance.mappedsuperclass;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="ms_instructor")
public class Instructor extends User {
//	@Id
//	private Long id;
	private String favoriteStudent;
}

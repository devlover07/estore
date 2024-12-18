package com.company.ecommerce_store.controlleradvices;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.company.ecommerce_store.dtos.ArithmeticExceptionDto;
import com.company.ecommerce_store.dtos.ProductNotExistDto;
import com.company.ecommerce_store.exceptions.ProductNotExistException;
//import com.company.ecommerce_store.models.Product;

@ControllerAdvice
public class ExceptionHandlers {
	
//	@ExceptionHandler(ArrayIndexOutOfBoundException.class)
//	public ResponseEntity<void> handleArrayIndexOutOfBoundException() {
//		return new ResponseEntity<>(HttpStatus.OK);
//	}
	
	@ExceptionHandler(ArithmeticException.class)
	public ResponseEntity<ArithmeticExceptionDto> handleArithmeticException() {
		ArithmeticExceptionDto dto = new ArithmeticExceptionDto();
		dto.setMessage("Arithmetic Exception occured");
		return new ResponseEntity<>(dto, HttpStatus.FORBIDDEN);
	}
	
	@ExceptionHandler(ProductNotExistException.class)
	public ResponseEntity<ProductNotExistDto> name(ProductNotExistException exception) {
		ProductNotExistDto productNotExistDto = new ProductNotExistDto();
		productNotExistDto.setTitle("Exception");
		productNotExistDto.setMessage(exception.getMessage());
//		return productNotExistDto;
		return new ResponseEntity<ProductNotExistDto>(productNotExistDto, HttpStatus.NOT_FOUND);
	}
}

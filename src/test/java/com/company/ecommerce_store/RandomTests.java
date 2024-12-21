package com.company.ecommerce_store;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class RandomTests {
	
	
	@Test
	void onePlusOneEqualsTwo() {
		int i = 1;
		
		assert 2 == i+i;
		
		assertTrue(i*i == 4);
	}
	
	@Test
	void tesTwoTwozaFour() {
		int i = 2*2;
		
		assert i == 4;
		assert 4 == i;
		
		assertTrue(i == 4);
	}
}

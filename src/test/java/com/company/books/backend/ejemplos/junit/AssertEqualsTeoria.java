package com.company.books.backend.ejemplos.junit;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AssertEqualsTeoria {
	
	
	// Ciclo de vida
	
	@BeforeAll
	public static void beforeALl() {
		System.out.println("Lo primero en ejecutarse (una vez)");
	}
	
	@BeforeEach
	public void beforeEach() {
		System.out.println("Lo primero en ejecutarse (una vez antes de cada @test)");
	}
	
	@Test
	@DisplayName("mitest1")
	public void miTest() {
		assertEquals(1, 1);
		assertNotEquals(1, 0);
		assertEquals(1,9);
		assertEquals(1,2);

	}
	
	@Test
	@DisplayName("mitest2")
	@Disabled("mitest2 deshabilitado")
	public void miTest2() {
		String[] valores = {"a","b"};
		String[] valores2 = {"a","b", "c"};

		assertTrue(2 < 3);
		assertFalse( !"patata".equals("patatín"));
		assertArrayEquals(valores, valores2);
	}
	
	@AfterEach
	public void afterEach() {
		System.out.println("Lo último en ejecutarse (una vez después de cada @test)");
	}
	
	@AfterAll
	public static void afterAll() {
		System.out.println("Lo útltimo en ejecutarse (una vez)");
	}
}

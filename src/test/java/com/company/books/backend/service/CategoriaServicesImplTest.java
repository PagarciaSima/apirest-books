package com.company.books.backend.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import com.company.books.backend.model.Categoria;
import com.company.books.backend.model.dao.ICategoriaDao;
import com.company.books.backend.response.CategoriaResponseRest;

public class CategoriaServicesImplTest {
	
	// Se inyecta el mock dao en el service
	
	@Mock
	ICategoriaDao categoriaDao;
	
	@InjectMocks
	CategoriaServiceImpl service;
	
	java.util.List<Categoria> list = new ArrayList<Categoria>();
	
	@BeforeEach
	public void init(){
		MockitoAnnotations.openMocks(this);
		this.cargarCategorias();
	}
	
	@Test
	public void buscarCategoriasTest() {
		when(categoriaDao.findAll()).thenReturn(list);
		ResponseEntity<CategoriaResponseRest> response = service.buscarCategorias();
		assertEquals(4, response.getBody().getCategoriaResponse().getCategoria().size());
		verify(categoriaDao, times(1)).findAll();
	}
	
	public void cargarCategorias() {
		Categoria catUno = new Categoria(Long.valueOf(1), "Abarrotes", "Distintos abarrotes");
		Categoria catDos = new Categoria(Long.valueOf(1), "Lacteos", "Distintos abarrotes");
		Categoria catTres = new Categoria(Long.valueOf(1), "Bebidas", "Bebidas sin azucar");
		Categoria catCuatro = new Categoria(Long.valueOf(1), "Carnes blancas", "Carnes varias");
		list.add(catUno);
		list.add(catDos);
		list.add(catTres);
		list.add(catCuatro);
	}
	
	

}

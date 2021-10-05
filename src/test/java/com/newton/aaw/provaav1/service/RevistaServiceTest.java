package com.newton.aaw.provaav1.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.newton.aaw.provaav1.domain.entity.Revista;
import com.newton.aaw.provaav1.domain.repository.RevistaRepository;
import com.newton.aaw.provaav1.exception.NotFoundException;


@ExtendWith(MockitoExtension.class)
class RevistaServiceTest {

	@Mock
	private RevistaRepository revistaRepository;
	private RevistaService unit;
	
	@BeforeEach
	public void setup() {
		unit = new RevistaService(revistaRepository);
	}
	
	@Test
	void test_getById_withRevista_shouldReturnObj() {
		// given:
		var revista = new Revista();
		revista.setId("revista2");
		
		// mock definitions: 
		Mockito.when(revistaRepository.findById("revista2"))
			.thenReturn(Optional.of(revista));
		
		// test:
		var result = unit.get("revista2");
		
		// assert:
		Assertions.assertEquals(result, revista);
		
		// verify: 
		Mockito.verify(revistaRepository).findById("revista2");
	}
	
	@Test
	void test_getById_withNoRevista_shouldThrowException() {
		// given:
		var id = "revista01";
		
		// mock definitions
		Mockito.when(revistaRepository.findById(id))
		.thenReturn(Optional.empty());

		// test:
		try {
			unit.get(id);
			fail("Expected NotFoundException");
		} catch (NotFoundException ex) {
			// assert:
			Assertions.assertEquals(ex.getMessage(), "Revista with ID " + id + " not found");
		}
		
		// verify: 
		Mockito.verify(revistaRepository).findById(id);		
	}
}
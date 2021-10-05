package com.newton.aaw.provaav1.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.newton.aaw.provaav1.api.RevistaDto;
import com.newton.aaw.provaav1.domain.entity.Revista;
import com.newton.aaw.provaav1.service.RevistaService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor

public class RevistaController {

private final RevistaService revistaService;
	
	@GetMapping("/revista/{id}")
	public RevistaDto getById(@PathVariable String id) {
		var revista = revistaService.get(id);
		
		return new RevistaDto(revista);
	}
	
	
	@GetMapping("/revista")
	public List<RevistaDto> getAll() {
		var revistas = revistaService.getAll();
		
		var revistaDtos = new ArrayList<RevistaDto>();
		
		for (var revista: revistas) {
			revistaDtos.add(new RevistaDto(revista));
		}
		
		return revistaDtos;
	}
	
	@PutMapping("/revista/{id}")
	public RevistaDto create(@PathVariable String id, @RequestBody RevistaDto revistaDto) {
		var revista = new Revista(revistaDto);
		
		revista = revistaService.update(id, revista);
		
		return new RevistaDto(revista);
	}
	
	@DeleteMapping("/revista/{id}") 
	public ResponseEntity<Void> delete(@PathVariable String id) {
		revistaService.delete(id);
		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		
	}
	
}

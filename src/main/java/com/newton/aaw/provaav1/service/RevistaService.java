package com.newton.aaw.provaav1.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.newton.aaw.provaav1.domain.entity.Revista;
import com.newton.aaw.provaav1.domain.repository.RevistaRepository;
import com.newton.aaw.provaav1.exception.NotFoundException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RevistaService {

	private final RevistaRepository revistaRepository;
		
	public Revista update(String id, Revista r) {
		var existing = get(id);

		existing.setTitulo(r.getTitulo());
		existing.setEditor(r.getEditor());
		existing.setAno(r.getAno());
		existing.setMes(r.getMes());
		existing.setData(r.getData());
		existing.setStatus(r.getStatus());
		
		return existing; 
	}
	
	public Revista get(String id) {
		var revista = revistaRepository.findById(id);
		
		if (revista.isEmpty()) {
			throw new NotFoundException("Revista with ID " + id + " not found");
		}
		
		return revista.get();
	}
	
	public List<Revista> getAll() {
		return revistaRepository.findAll();
	}
	
	public void delete(String id) {
		get(id);
		
		revistaRepository.deleteById(id);
	}
}

package com.newton.aaw.provaav1.api;

import java.time.LocalDate;

import com.newton.aaw.provaav1.domain.entity.Revista;
import com.newton.aaw.provaav1.domain.enums.RevistaStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class RevistaDto {

	private String id;
	private String titulo;
	private String editor;
	private Integer ano;
	private Integer mes;
	private LocalDate data; 
	private RevistaStatus status;
	
	public RevistaDto(Revista r) {
		this.setId(r.getId());
		this.setTitulo(r.getTitulo());
		this.setEditor(r.getEditor());
		this.setAno(r.getAno());
		this.setMes(r.getMes());
		this.setData(r.getData());
		this.setStatus(r.getStatus());
	}
	
}
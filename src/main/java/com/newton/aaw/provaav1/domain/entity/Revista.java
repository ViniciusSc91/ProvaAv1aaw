package com.newton.aaw.provaav1.domain.entity;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;

import com.newton.aaw.provaav1.api.RevistaDto;
import com.newton.aaw.provaav1.domain.enums.RevistaStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

@Data
@With
@AllArgsConstructor
@NoArgsConstructor

public class Revista {

	@Id
	private String id;
	private String titulo;
	private String editor;
	private Integer ano;
	private Integer mes;
	private LocalDate data; 
	private RevistaStatus status;
	
	public Revista(RevistaDto r) {
		this.id = getId();
		this.titulo = getTitulo();
		this.editor = getEditor();
		this.ano = getAno();
		this.mes = getMes();
		this.data = getData();
		this.status = getStatus();
	}
}

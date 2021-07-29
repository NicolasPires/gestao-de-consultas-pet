package com.nksolucoes.gestaodeconsultaspet.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nksolucoes.gestaodeconsultaspet.domain.Animal;
import com.nksolucoes.gestaodeconsultaspet.domain.enums.EspecieAnimal;

public class AnimalDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome;
	private EspecieAnimal especie;
	private String raca;
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date dataNascimento;
	
	public AnimalDTO () {
		
	}

	public AnimalDTO(Animal obj) {
		id = obj.getId();
		nome = obj.getNome();
		especie = obj.getEspecie();
		raca = obj.getRaca();
		dataNascimento = obj.getDataNascimento();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public EspecieAnimal getEspecie() {
		return especie;
	}

	public void setEspecie(EspecieAnimal especie) {
		this.especie = especie;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	
}

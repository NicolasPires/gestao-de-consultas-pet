package com.nksolucoes.gestaodeconsultaspet.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nksolucoes.gestaodeconsultaspet.domain.enums.EspecieAnimal;

@Entity
public class Animal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private Integer especie;
	private String raca;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date dataNascimento;

	@ManyToOne
	@JoinColumn(name = "tutor_id")
	private Tutor tutor;

	@JsonIgnore
	@OneToMany(mappedBy = "animal")
	List<Consulta> consultas = new ArrayList<>();

	public Animal() {
	}

	public Animal(Integer id, String nome, EspecieAnimal especie, String raca, Date dataNascimento, Tutor tutor) {
		super();
		this.id = id;
		this.nome = nome;
		this.especie = especie.getEspecie();
		this.raca = raca;
		this.dataNascimento = dataNascimento;
		this.tutor = tutor;
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
		return EspecieAnimal.toEnum(especie);
	}

	public void setEspecie(EspecieAnimal especie) {
		this.especie = especie.getEspecie();
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
	
	public Tutor getTutor() {
		return tutor;
	}

	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}

	public List<Consulta> getConsultas() {
		return consultas;
	}

	public void setConsultas(List<Consulta> consultas) {
		this.consultas = consultas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Animal other = (Animal) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


}

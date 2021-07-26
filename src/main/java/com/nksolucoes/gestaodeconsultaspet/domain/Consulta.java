package com.nksolucoes.gestaodeconsultaspet.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nksolucoes.gestaodeconsultaspet.domain.enums.StatusConsulta;

@Entity
public class Consulta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date dataConsulta;
	private Integer status;

	@ManyToOne
	@JoinColumn(name = "veterinario_id")
	private Veterinario veterinario;

	@ManyToOne
	@JoinColumn(name = "animal_id")
	private Animal animal;

	public Consulta() {
	}

	public Consulta(Integer id, Date dataConsulta, StatusConsulta status, Veterinario veterinario, Animal animal) {
		super();
		this.id = id;
		this.dataConsulta = dataConsulta;
		this.status = status.getStatus();
		this.veterinario = veterinario;
		this.animal = animal;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataConsulta() {
		return dataConsulta;
	}

	public void setDataConsulta(Date dataConsulta) {
		this.dataConsulta = dataConsulta;
	}

	public StatusConsulta getStatus() {
		return StatusConsulta.toEnum(status);
	}

	public void setStatus(StatusConsulta status) {
		this.status = status.getStatus();
	}

	public Veterinario getVeterinario() {
		return veterinario;
	}

	public void setVeterinario(Veterinario veterinario) {
		this.veterinario = veterinario;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
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
		Consulta other = (Consulta) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}

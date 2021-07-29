package com.nksolucoes.gestaodeconsultaspet.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nksolucoes.gestaodeconsultaspet.domain.Consulta;
import com.nksolucoes.gestaodeconsultaspet.domain.enums.StatusConsulta;

public class ConsultaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date dataConsulta;
	private StatusConsulta status;

	public ConsultaDTO() {

	}

	public ConsultaDTO(Consulta obj) {
		id = obj.getId();
		dataConsulta = obj.getDataConsulta();
		status = obj.getStatus();		
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
		return status;
	}

	public void setStatus(StatusConsulta status) {
		this.status = status;
	}

	
}

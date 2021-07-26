package com.nksolucoes.gestaodeconsultaspet.domain.enums;

public enum StatusConsulta {

	AGENDADA(1, "Agendada"), NAO_CONFIRMADA(2, "Não-Confirmada"), CONFIRMADA(3, "Confirmada"),
	REALIZADA(4, "Realizada");

	private Integer status;
	private String descricao;

	private StatusConsulta(Integer status, String descricao) {
		this.status = status;
		this.descricao = descricao;
	}

	public Integer getStatus() {
		return status;
	}

	public String getDescricao() {
		return descricao;
	}

	public static StatusConsulta toEnum(Integer status) {
		if (status == null) {
			return null;
		}

		for (StatusConsulta x : StatusConsulta.values()) {
			if (status.equals( x.getStatus() )) {
				return x;
			}
		}

		throw new IllegalArgumentException("Status da consulta inválido: " + status);

	}

}

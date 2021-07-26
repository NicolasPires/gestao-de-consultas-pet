package com.nksolucoes.gestaodeconsultaspet.domain.enums;

public enum EspecieAnimal {

	CAO(1, "Cao"), GATO(2, "Gato"), AVE(3, "Ave");

	private Integer especie;
	private String descricao;

	private EspecieAnimal(Integer especie, String descricao) {
		this.especie = especie;
		this.descricao = descricao;
	}

	public Integer getEspecie() {
		return especie;
	}

	public String getDescricao() {
		return descricao;
	}

	public static EspecieAnimal toEnum(Integer especie) {
		if (especie == null) {
			return null;
		}

		for (EspecieAnimal x : EspecieAnimal.values()) {
			if (especie.equals( x.getEspecie() )) {
				return x;
			}
		}

		throw new IllegalArgumentException("Especie de animal inexistente: " + especie);

	}

}

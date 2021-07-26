package com.nksolucoes.gestaodeconsultaspet.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nksolucoes.gestaodeconsultaspet.domain.Consulta;
import com.nksolucoes.gestaodeconsultaspet.repositorires.ConsultaRepository;
import com.nksolucoes.gestaodeconsultaspet.services.exceptions.ObjectNotFoundException;

@Service
public class ConsultaService {

	@Autowired
	private ConsultaRepository repo;

	public Consulta buscar(Integer id) {
		Optional<Consulta> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo " + Consulta.class.getName()));
	}

}

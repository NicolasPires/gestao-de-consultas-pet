package com.nksolucoes.gestaodeconsultaspet.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nksolucoes.gestaodeconsultaspet.domain.Veterinario;
import com.nksolucoes.gestaodeconsultaspet.repositorires.VeterinarioRepository;
import com.nksolucoes.gestaodeconsultaspet.services.exceptions.ObjectNotFoundException;

@Service
public class VeterinarioService {

	@Autowired
	private VeterinarioRepository repo;

	public Veterinario buscar(Integer id) {
		Optional<Veterinario> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo " + Veterinario.class.getName()));
	}

}

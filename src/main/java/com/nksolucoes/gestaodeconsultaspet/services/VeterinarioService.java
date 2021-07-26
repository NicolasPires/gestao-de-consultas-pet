package com.nksolucoes.gestaodeconsultaspet.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.nksolucoes.gestaodeconsultaspet.domain.Veterinario;
import com.nksolucoes.gestaodeconsultaspet.repositorires.VeterinarioRepository;
import com.nksolucoes.gestaodeconsultaspet.services.exceptions.DataIntegrityException;
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
	
	public Veterinario insert(Veterinario obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Veterinario update(Veterinario obj) {
		buscar(obj.getId());
		return repo.save(obj);
	}

	public void delete(Integer id) {
		buscar(id);
		try {
			repo.deleteById(id);
		} 
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possivel realizar a exclusão.");
		}
	}
	

}

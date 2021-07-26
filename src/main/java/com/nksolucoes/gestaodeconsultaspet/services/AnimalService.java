package com.nksolucoes.gestaodeconsultaspet.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.nksolucoes.gestaodeconsultaspet.domain.Animal;
import com.nksolucoes.gestaodeconsultaspet.repositorires.AnimalRepository;
import com.nksolucoes.gestaodeconsultaspet.services.exceptions.DataIntegrityException;
import com.nksolucoes.gestaodeconsultaspet.services.exceptions.ObjectNotFoundException;

@Service
public class AnimalService {

	@Autowired
	private AnimalRepository repo;

	public Animal buscar(Integer id) {
		Optional<Animal> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo " + Animal.class.getName()));
	}
	
	public Animal insert(Animal obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Animal update(Animal obj) {
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

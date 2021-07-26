package com.nksolucoes.gestaodeconsultaspet.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.nksolucoes.gestaodeconsultaspet.domain.Tutor;
import com.nksolucoes.gestaodeconsultaspet.repositorires.TutorRepository;
import com.nksolucoes.gestaodeconsultaspet.services.exceptions.DataIntegrityException;
import com.nksolucoes.gestaodeconsultaspet.services.exceptions.ObjectNotFoundException;

@Service
public class TutorService {

	@Autowired
	private TutorRepository repo;

	public Tutor buscar(Integer id) {
		Optional<Tutor> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo " + Tutor.class.getName()));
	}
	
	public Tutor insert(Tutor obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Tutor update(Tutor obj) {
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

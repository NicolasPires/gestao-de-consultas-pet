package com.nksolucoes.gestaodeconsultaspet.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.nksolucoes.gestaodeconsultaspet.domain.Consulta;
import com.nksolucoes.gestaodeconsultaspet.repositorires.ConsultaRepository;
import com.nksolucoes.gestaodeconsultaspet.services.exceptions.DataIntegrityException;
import com.nksolucoes.gestaodeconsultaspet.services.exceptions.ObjectNotFoundException;

@Service
public class ConsultaService {

	@Autowired
	private ConsultaRepository repo;

	public Consulta find(Integer id) {
		Optional<Consulta> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo " + Consulta.class.getName()));
	}
	
	public Consulta insert(Consulta obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Consulta update(Consulta obj) {
		find(obj.getId());
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} 
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possivel realizar a exclusão.");
		}
	}
	
	public List<Consulta> findAll() {
		return repo.findAll();
	}

}

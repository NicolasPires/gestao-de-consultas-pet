package com.nksolucoes.gestaodeconsultaspet.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nksolucoes.gestaodeconsultaspet.domain.Tutor;
import com.nksolucoes.gestaodeconsultaspet.services.TutorService;

@RestController
@RequestMapping(value = "/tutores")
public class TutorResource {

	@Autowired
	private TutorService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Tutor obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
	};
}

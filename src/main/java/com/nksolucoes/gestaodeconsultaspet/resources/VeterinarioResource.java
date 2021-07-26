package com.nksolucoes.gestaodeconsultaspet.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nksolucoes.gestaodeconsultaspet.domain.Veterinario;
import com.nksolucoes.gestaodeconsultaspet.services.VeterinarioService;

@RestController
@RequestMapping(value = "/veterinarios")
public class VeterinarioResource {

	@Autowired
	private VeterinarioService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Veterinario obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
	};
}
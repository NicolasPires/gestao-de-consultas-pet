package com.nksolucoes.gestaodeconsultaspet.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.nksolucoes.gestaodeconsultaspet.domain.Veterinario;
import com.nksolucoes.gestaodeconsultaspet.dto.VeterinarioDTO;
import com.nksolucoes.gestaodeconsultaspet.services.VeterinarioService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/veterinarios")
public class VeterinarioResource {

	@Autowired
	private VeterinarioService service;

	@ApiOperation("Busca veterinario.")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Veterinario obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	};
	
	@ApiOperation("Insere veterinario.")
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Veterinario obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();

	}
	
	@ApiOperation("Atualiza veterinario.")
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Veterinario obj, @PathVariable Integer id) {
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@ApiOperation("Deleta veterinario.")
	@ApiResponses(value = {
			@ApiResponse(code = 400, message = "Não é possível excluir veterinarios que possuem consultas"),
			@ApiResponse(code = 404, message = "Código inexistente") })
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<VeterinarioDTO>> findAll() {
		List<Veterinario> list = service.findAll();
		List<VeterinarioDTO> listDTO = list.stream().map(obj -> new VeterinarioDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	};
}

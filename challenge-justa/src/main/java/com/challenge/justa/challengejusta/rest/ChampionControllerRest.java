package com.challenge.justa.challengejusta.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.justa.challengejusta.dto.ChampionDTO;
import com.challenge.justa.challengejusta.services.ChampionService;

@RestController
@RequestMapping(value = "/champions")
public class ChampionControllerRest {

	@Autowired
	private ChampionService championService;

	@GetMapping("/{id}")
	public ResponseEntity<ChampionDTO> search(@PathVariable Long id) {
		ChampionDTO dto = championService.search(id);
		return ResponseEntity.ok().body(dto);
	}

	@PostMapping("")
	public ResponseEntity<ChampionDTO> insert(@RequestBody ChampionDTO dto) {
		dto = championService.insert(dto);
		return ResponseEntity.ok().body(dto);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ChampionDTO> update(@RequestBody ChampionDTO dto, @PathVariable Long id) {
		dto = championService.update(dto, id);
		return ResponseEntity.ok().body(dto);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		championService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
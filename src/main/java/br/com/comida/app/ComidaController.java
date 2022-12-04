package br.com.comida.app;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comidas")
public class ComidaController {
	
	private ComidaService comidaService;
	
	public ComidaController(ComidaService comidaService) {
		this.comidaService = comidaService;
	}

	@PostMapping
	public ResponseEntity<Comida> salvar(@RequestBody Comida comida) {
		return ResponseEntity.ok(this.comidaService.salva(comida));
	}

	@GetMapping
	public ResponseEntity<List<Comida>> buscarTodos() {
		return ResponseEntity.ok(this.comidaService.buscarTodos());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluirPeloId(@PathVariable(name = "id") Long id) {
		this.comidaService.excluirPeloId(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Comida> buscarPeloId(@PathVariable(name = "id") Long id) {
		return ResponseEntity.ok(this.comidaService.buscarPeloId(id));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Comida> atualizar(@PathVariable(name = "id") Long id, @RequestBody Comida comida) {
		return ResponseEntity.ok(this.comidaService.atualizar(id, comida));
	}

}

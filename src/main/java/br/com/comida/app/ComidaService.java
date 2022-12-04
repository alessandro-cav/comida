package br.com.comida.app;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ComidaService {

	private final ComidaRepository repository;

	public ComidaService(ComidaRepository repository) {
		this.repository = repository;
	}

	public Comida salva(Comida comida) {
		return this.repository.save(comida);
	}

	public List<Comida> buscarTodos() {
		return this.repository.findAll();
	}

	public void excluirPeloId(Long id) {
		Comida comida = this.repository.findById(id).get();
		this.repository.delete(comida);
	}

	public Comida buscarPeloId(Long id) {
		return this.repository.findById(id).get();
	}

	public Comida atualizar(Long id, Comida comida2) {
		Comida comida = this.repository.findById(id).get();
		comida.setNome(comida2.getNome());
		comida.setDescricao(comida2.getDescricao());
		comida.setPreco(comida2.getPreco());
		comida.setImagens(comida2.getImagens());
		return this.repository.save(comida);
	}

}

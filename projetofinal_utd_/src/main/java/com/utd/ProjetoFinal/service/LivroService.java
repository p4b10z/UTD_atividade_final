package com.utd.ProjetoFinal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utd.ProjetoFinal.model.Livro;
import com.utd.ProjetoFinal.repository.LivroRepository;

@Service
public class LivroService {
	@Autowired
	LivroRepository repo;

	public void adicionar(Livro livro) {
		repo.save(livro);
	}

	public List<Livro> listarTodos() {
		List<Livro> livros = repo.findAll();
		for (Livro l : livros) {
			System.out.println(l.getNome());
		}
		return repo.findAll();
	}

	public Livro modificar(Long id) {
		return repo.findById(id).get();
	}

	public void deletar(Long id) {
		repo.deleteById(id);
	}
}

package com.utd.ProjetoFinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.utd.ProjetoFinal.model.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
}
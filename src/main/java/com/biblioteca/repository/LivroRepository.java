package com.biblioteca.repository;

import com.biblioteca.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositório JPA para a entidade Livro.
 * Herda os métodos CRUD automaticamente do JpaRepository.
 */
@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
    // Métodos CRUD já disponíveis: save, findById, findAll, deleteById, etc.
}

package com.biblioteca.repository;

import com.biblioteca.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositório JPA para a entidade Autor.
 * Herda os métodos CRUD automaticamente do JpaRepository.
 */
@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {
    // Métodos CRUD já disponíveis: save, findById, findAll, deleteById, etc.
}

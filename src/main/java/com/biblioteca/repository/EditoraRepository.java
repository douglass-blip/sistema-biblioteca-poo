package com.biblioteca.repository;

import com.biblioteca.model.Editora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositório JPA para a entidade Editora.
 * Herda os métodos CRUD automaticamente do JpaRepository.
 */
@Repository
public interface EditoraRepository extends JpaRepository<Editora, Long> {
    // Métodos CRUD já disponíveis: save, findById, findAll, deleteById, etc.
}

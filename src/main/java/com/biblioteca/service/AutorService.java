package com.biblioteca.service;

import com.biblioteca.model.Autor;
import com.biblioteca.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Camada de serviço para a entidade Autor.
 * Contém a lógica de negócio e se comunica com o repositório.
 */
@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    // Retorna todos os autores
    public List<Autor> listarTodos() {
        return autorRepository.findAll();
    }

    // Busca autor por ID
    public Optional<Autor> buscarPorId(Long id) {
        return autorRepository.findById(id);
    }

    // Salva um novo autor
    public Autor salvar(Autor autor) {
        return autorRepository.save(autor);
    }

    // Atualiza um autor existente
    public Autor atualizar(Long id, Autor autorAtualizado) {
        Autor autor = autorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Autor não encontrado com id: " + id));

        autor.setNome(autorAtualizado.getNome());
        autor.setNacionalidade(autorAtualizado.getNacionalidade());
        autor.setEmail(autorAtualizado.getEmail());

        return autorRepository.save(autor);
    }

    // Deleta um autor pelo ID
    public void deletar(Long id) {
        autorRepository.deleteById(id);
    }
}

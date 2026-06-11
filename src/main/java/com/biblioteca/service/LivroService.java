package com.biblioteca.service;

import com.biblioteca.model.Autor;
import com.biblioteca.model.Editora;
import com.biblioteca.model.Livro;
import com.biblioteca.repository.AutorRepository;
import com.biblioteca.repository.EditoraRepository;
import com.biblioteca.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Camada de serviço para a entidade Livro.
 * Contém a lógica de negócio e se comunica com o repositório.
 */
@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private EditoraRepository editoraRepository;

    // Retorna todos os livros
    public List<Livro> listarTodos() {
        return livroRepository.findAll();
    }

    // Busca livro por ID
    public Optional<Livro> buscarPorId(Long id) {
        return livroRepository.findById(id);
    }

    // Salva um novo livro (recebe IDs de autor e editora)
    public Livro salvar(Livro livro, Long autorId, Long editoraId) {
        Autor autor = autorRepository.findById(autorId)
                .orElseThrow(() -> new RuntimeException("Autor não encontrado com id: " + autorId));

        Editora editora = editoraRepository.findById(editoraId)
                .orElseThrow(() -> new RuntimeException("Editora não encontrada com id: " + editoraId));

        livro.setAutor(autor);
        livro.setEditora(editora);

        return livroRepository.save(livro);
    }

    // Atualiza um livro existente
    public Livro atualizar(Long id, Livro livroAtualizado, Long autorId, Long editoraId) {
        Livro livro = livroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado com id: " + id));

        Autor autor = autorRepository.findById(autorId)
                .orElseThrow(() -> new RuntimeException("Autor não encontrado com id: " + autorId));

        Editora editora = editoraRepository.findById(editoraId)
                .orElseThrow(() -> new RuntimeException("Editora não encontrada com id: " + editoraId));

        livro.setTitulo(livroAtualizado.getTitulo());
        livro.setIsbn(livroAtualizado.getIsbn());
        livro.setAnoPub(livroAtualizado.getAnoPub());
        livro.setAutor(autor);
        livro.setEditora(editora);

        return livroRepository.save(livro);
    }

    // Deleta um livro pelo ID
    public void deletar(Long id) {
        livroRepository.deleteById(id);
    }
}

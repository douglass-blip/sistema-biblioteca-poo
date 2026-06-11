package com.biblioteca.service;

import com.biblioteca.model.Editora;
import com.biblioteca.repository.EditoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Camada de serviço para a entidade Editora.
 * Contém a lógica de negócio e se comunica com o repositório.
 */
@Service
public class EditoraService {

    @Autowired
    private EditoraRepository editoraRepository;

    // Retorna todas as editoras
    public List<Editora> listarTodas() {
        return editoraRepository.findAll();
    }

    // Busca editora por ID
    public Optional<Editora> buscarPorId(Long id) {
        return editoraRepository.findById(id);
    }

    // Salva uma nova editora
    public Editora salvar(Editora editora) {
        return editoraRepository.save(editora);
    }

    // Atualiza uma editora existente
    public Editora atualizar(Long id, Editora editoraAtualizada) {
        Editora editora = editoraRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Editora não encontrada com id: " + id));

        editora.setNome(editoraAtualizada.getNome());
        editora.setCnpj(editoraAtualizada.getCnpj());
        editora.setCidade(editoraAtualizada.getCidade());

        return editoraRepository.save(editora);
    }

    // Deleta uma editora pelo ID
    public void deletar(Long id) {
        editoraRepository.deleteById(id);
    }
}

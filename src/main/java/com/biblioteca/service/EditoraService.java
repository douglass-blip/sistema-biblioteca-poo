package com.biblioteca.service;

import com.biblioteca.model.Editora;
import com.biblioteca.repository.EditoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EditoraService {

    @Autowired
    private EditoraRepository editoraRepository;

    
    public List<Editora> listarTodas() {
        return editoraRepository.findAll();
    }

  
    public Optional<Editora> buscarPorId(Long id) {
        return editoraRepository.findById(id);
    }

    
    public Editora salvar(Editora editora) {
        return editoraRepository.save(editora);
    }

    
    public Editora atualizar(Long id, Editora editoraAtualizada) {
        Editora editora = editoraRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Editora não encontrada com id: " + id));

        editora.setNome(editoraAtualizada.getNome());
        editora.setCnpj(editoraAtualizada.getCnpj());
        editora.setCidade(editoraAtualizada.getCidade());

        return editoraRepository.save(editora);
    }

    
    public void deletar(Long id) {
        editoraRepository.deleteById(id);
    }
}

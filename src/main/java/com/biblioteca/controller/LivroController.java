package com.biblioteca.controller;

import com.biblioteca.model.Livro;
import com.biblioteca.service.LivroService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/livros")
@Tag(name = "Livros", description = "Endpoints para gerenciamento de livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    
    @GetMapping
    @Operation(summary = "Lista todos os livros")
    public ResponseEntity<List<Livro>> listarTodos() {
        return ResponseEntity.ok(livroService.listarTodos());
    }

  
    @GetMapping("/{id}")
    @Operation(summary = "Busca um livro pelo ID")
    public ResponseEntity<Livro> buscarPorId(@PathVariable Long id) {
        return livroService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    
    @PostMapping
    @Operation(summary = "Cria um novo livro (informe autorId e editoraId como parâmetros)")
    public ResponseEntity<Livro> criar(
            @RequestBody Livro livro,
            @RequestParam Long autorId,
            @RequestParam Long editoraId) {
        try {
            Livro novoLivro = livroService.salvar(livro, autorId, editoraId);
            return ResponseEntity.status(HttpStatus.CREATED).body(novoLivro);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

  
    @PutMapping("/{id}")
    @Operation(summary = "Atualiza um livro existente (informe autorId e editoraId como parâmetros)")
    public ResponseEntity<Livro> atualizar(
            @PathVariable Long id,
            @RequestBody Livro livro,
            @RequestParam Long autorId,
            @RequestParam Long editoraId) {
        try {
            Livro atualizado = livroService.atualizar(id, livro, autorId, editoraId);
            return ResponseEntity.ok(atualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

   
    @DeleteMapping("/{id}")
    @Operation(summary = "Deleta um livro pelo ID")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        livroService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}

package com.biblioteca.controller;

import com.biblioteca.model.Autor;
import com.biblioteca.service.AutorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller REST para a entidade Autor.
 * Expõe os endpoints da API em /api/autores.
 */
@RestController
@RequestMapping("/api/autores")
@Tag(name = "Autores", description = "Endpoints para gerenciamento de autores")
public class AutorController {

    @Autowired
    private AutorService autorService;

    // GET /api/autores - Lista todos os autores
    @GetMapping
    @Operation(summary = "Lista todos os autores")
    public ResponseEntity<List<Autor>> listarTodos() {
        return ResponseEntity.ok(autorService.listarTodos());
    }

    // GET /api/autores/{id} - Busca autor por ID
    @GetMapping("/{id}")
    @Operation(summary = "Busca um autor pelo ID")
    public ResponseEntity<Autor> buscarPorId(@PathVariable Long id) {
        return autorService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST /api/autores - Cria um novo autor
    @PostMapping
    @Operation(summary = "Cria um novo autor")
    public ResponseEntity<Autor> criar(@RequestBody Autor autor) {
        Autor novoAutor = autorService.salvar(autor);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoAutor);
    }

    // PUT /api/autores/{id} - Atualiza um autor existente
    @PutMapping("/{id}")
    @Operation(summary = "Atualiza um autor existente")
    public ResponseEntity<Autor> atualizar(@PathVariable Long id, @RequestBody Autor autor) {
        try {
            Autor atualizado = autorService.atualizar(id, autor);
            return ResponseEntity.ok(atualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE /api/autores/{id} - Deleta um autor
    @DeleteMapping("/{id}")
    @Operation(summary = "Deleta um autor pelo ID")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        autorService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}

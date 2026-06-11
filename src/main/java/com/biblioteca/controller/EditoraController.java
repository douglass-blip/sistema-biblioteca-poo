package com.biblioteca.controller;

import com.biblioteca.model.Editora;
import com.biblioteca.service.EditoraService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller REST para a entidade Editora.
 * Expõe os endpoints da API em /api/editoras.
 */
@RestController
@RequestMapping("/api/editoras")
@Tag(name = "Editoras", description = "Endpoints para gerenciamento de editoras")
public class EditoraController {

    @Autowired
    private EditoraService editoraService;

    // GET /api/editoras - Lista todas as editoras
    @GetMapping
    @Operation(summary = "Lista todas as editoras")
    public ResponseEntity<List<Editora>> listarTodas() {
        return ResponseEntity.ok(editoraService.listarTodas());
    }

    // GET /api/editoras/{id} - Busca editora por ID
    @GetMapping("/{id}")
    @Operation(summary = "Busca uma editora pelo ID")
    public ResponseEntity<Editora> buscarPorId(@PathVariable Long id) {
        return editoraService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST /api/editoras - Cria uma nova editora
    @PostMapping
    @Operation(summary = "Cria uma nova editora")
    public ResponseEntity<Editora> criar(@RequestBody Editora editora) {
        Editora novaEditora = editoraService.salvar(editora);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaEditora);
    }

    // PUT /api/editoras/{id} - Atualiza uma editora existente
    @PutMapping("/{id}")
    @Operation(summary = "Atualiza uma editora existente")
    public ResponseEntity<Editora> atualizar(@PathVariable Long id, @RequestBody Editora editora) {
        try {
            Editora atualizada = editoraService.atualizar(id, editora);
            return ResponseEntity.ok(atualizada);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE /api/editoras/{id} - Deleta uma editora
    @DeleteMapping("/{id}")
    @Operation(summary = "Deleta uma editora pelo ID")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        editoraService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}

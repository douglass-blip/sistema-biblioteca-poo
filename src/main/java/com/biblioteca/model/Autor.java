package com.biblioteca.model;

import jakarta.persistence.*;
import java.util.List;

/**
 * Entidade que representa um Autor no sistema de biblioteca.
 * Um autor pode ter vários livros associados.
 */
@Entity
@Table(name = "autores")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String nacionalidade;

    @Column(nullable = false)
    private String email;

    // Um autor pode ter vários livros
    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL)
    private List<Livro> livros;

    // Construtor padrão (obrigatório para JPA)
    public Autor() {}

    // Construtor com parâmetros
    public Autor(String nome, String nacionalidade, String email) {
        this.nome = nome;
        this.nacionalidade = nacionalidade;
        this.email = email;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getNacionalidade() { return nacionalidade; }
    public void setNacionalidade(String nacionalidade) { this.nacionalidade = nacionalidade; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public List<Livro> getLivros() { return livros; }
    public void setLivros(List<Livro> livros) { this.livros = livros; }
}

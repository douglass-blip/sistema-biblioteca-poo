package com.biblioteca.model;

import jakarta.persistence.*;
import java.util.List;

/**
 * Entidade que representa uma Editora no sistema de biblioteca.
 * Uma editora pode publicar vários livros.
 */
@Entity
@Table(name = "editoras")
public class Editora {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String cnpj;

    @Column(nullable = false)
    private String cidade;

    // Uma editora pode ter vários livros
    @OneToMany(mappedBy = "editora", cascade = CascadeType.ALL)
    private List<Livro> livros;

    // Construtor padrão (obrigatório para JPA)
    public Editora() {}

    // Construtor com parâmetros
    public Editora(String nome, String cnpj, String cidade) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.cidade = cidade;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCnpj() { return cnpj; }
    public void setCnpj(String cnpj) { this.cnpj = cnpj; }

    public String getCidade() { return cidade; }
    public void setCidade(String cidade) { this.cidade = cidade; }

    public List<Livro> getLivros() { return livros; }
    public void setLivros(List<Livro> livros) { this.livros = livros; }
}

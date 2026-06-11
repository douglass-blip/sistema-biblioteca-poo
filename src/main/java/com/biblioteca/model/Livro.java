package com.biblioteca.model;

import jakarta.persistence.*;


@Entity
@Table(name = "livros")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false, unique = true)
    private String isbn;

    @Column(nullable = false)
    private Integer anoPub;

    
    @ManyToOne
    @JoinColumn(name = "autor_id", nullable = false)
    private Autor autor;

   
    @ManyToOne
    @JoinColumn(name = "editora_id", nullable = false)
    private Editora editora;

    
    public Livro() {}

   
    public Livro(String titulo, String isbn, Integer anoPub, Autor autor, Editora editora) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.anoPub = anoPub;
        this.autor = autor;
        this.editora = editora;
    }

   
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }

    public Integer getAnoPub() { return anoPub; }
    public void setAnoPub(Integer anoPub) { this.anoPub = anoPub; }

    public Autor getAutor() { return autor; }
    public void setAutor(Autor autor) { this.autor = autor; }

    public Editora getEditora() { return editora; }
    public void setEditora(Editora editora) { this.editora = editora; }
}

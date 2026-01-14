package com.alura.literatura.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "libros")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String idioma;
    private Integer numeroDescargas;

    @ManyToMany
    @JoinTable(
            name = "libro_autor",
            joinColumns = @JoinColumn(name = "libro_id"),
            inverseJoinColumns = @JoinColumn(name = "autor_id")
    )
    private Set<Autor> autores = new HashSet<>();

    public Libro() {
    }

    public Libro(String titulo, String idioma, Integer numeroDescargas) {
        this.titulo = titulo;
        this.idioma = idioma;
        this.numeroDescargas = numeroDescargas;
    }

    public Libro(String titulo, List<String> idiomas) {
        this.titulo = titulo;
        this.idioma = idiomas.get(0); // toma el primer idioma
    }

    public void agregarAutor(Autor autor) {
        this.autores.add(autor);
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getIdioma() {
        return idioma;
    }

    public Integer getNumeroDescargas() {
        return numeroDescargas;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public void setNumeroDescargas(Integer numeroDescargas) {
        this.numeroDescargas = numeroDescargas;
    }

}

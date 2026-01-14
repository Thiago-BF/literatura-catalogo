package com.alura.literatura.repository;

import com.alura.literatura.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LibroRepository extends JpaRepository<Libro, Long> {

    Optional<Libro> findByTituloIgnoreCase(String titulo);

    // 📚 Listar libros por idioma
    List<Libro> findByIdiomaIgnoreCase(String idioma);

    // 🔥 Ordenar libros por número de descargas (de mayor a menor)
    List<Libro> findAllByOrderByNumeroDescargasDesc();
}

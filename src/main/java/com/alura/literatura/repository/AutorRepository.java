package com.alura.literatura.repository;

import com.alura.literatura.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AutorRepository extends JpaRepository<Autor, Long> {

    Optional<Autor> findByNombreIgnoreCase(String nombre);

    List<Autor> findByAnioNacimientoLessThanEqualAndAnioFallecimientoGreaterThanEqual(
            Integer nacimiento, Integer fallecimiento);

    List<Autor> findByAnioNacimientoLessThanEqualAndAnioFallecimientoIsNull(
            Integer nacimiento);
}

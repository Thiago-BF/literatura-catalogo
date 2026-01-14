package com.alura.literatura.service;

import com.alura.literatura.dto.DatosAutor;
import com.alura.literatura.dto.DatosLibro;
import com.alura.literatura.dto.RespuestaGutendex;
import com.alura.literatura.model.Autor;
import com.alura.literatura.model.Libro;
import com.alura.literatura.repository.AutorRepository;
import com.alura.literatura.repository.LibroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CatalogoService {

    private final GutendexService gutendexService;
    private final LibroRepository libroRepository;
    private final AutorRepository autorRepository;

    public CatalogoService(GutendexService gutendexService,
                           LibroRepository libroRepository,
                           AutorRepository autorRepository) {
        this.gutendexService = gutendexService;
        this.libroRepository = libroRepository;
        this.autorRepository = autorRepository;
    }

    // 🔹 Buscar libro en la API y guardarlo
    public void buscarYGuardarLibro(String titulo) {
        RespuestaGutendex respuesta = gutendexService.buscarLibroPorTitulo(titulo);

        if (respuesta == null || respuesta.results().isEmpty()) {
            System.out.println("❌ Libro no encontrado.");
            return;
        }

        DatosLibro datosLibro = respuesta.results().get(0);

        Optional<Libro> libroExistente =
                libroRepository.findByTituloIgnoreCase(datosLibro.title());

        if (libroExistente.isPresent()) {
            System.out.println("⚠️ El libro ya está registrado.");
            return;
        }

        String idioma = datosLibro.languages().isEmpty()
                ? "desconocido"
                : datosLibro.languages().get(0);

        Libro libro = new Libro(
                datosLibro.title(),
                idioma,
                datosLibro.download_count()
        );


        libroRepository.save(libro);

        for (DatosAutor datosAutor : datosLibro.authors()) {
            Autor autor = autorRepository
                    .findByNombreIgnoreCase(datosAutor.name())
                    .orElseGet(() -> autorRepository.save(
                            new Autor(
                                    datosAutor.name(),
                                    datosAutor.birth_year(),
                                    datosAutor.death_year()
                            )
                    ));

            libro.agregarAutor(autor);
        }

        libroRepository.save(libro);
        System.out.println("✅ Libro guardado correctamente.");
    }

    // 🔹 Listar todos los libros
    public void listarLibros() {
        List<Libro> libros = libroRepository.findAll();

        if (libros.isEmpty()) {
            System.out.println("📭 No hay libros registrados.");
            return;
        }

        System.out.println("📚 Libros registrados:");
        libros.forEach(libro ->
                System.out.println("- " + libro.getTitulo()
                        + " | Idioma: " + libro.getIdioma()
                        + " | Descargas: " + libro.getNumeroDescargas())
        );
    }

    // 🔹 Listar libros por idioma
    public void listarLibrosPorIdioma(String idioma) {
        List<Libro> libros = libroRepository.findByIdiomaIgnoreCase(idioma);

        if (libros.isEmpty()) {
            System.out.println("❌ No hay libros en el idioma: " + idioma);
            return;
        }

        System.out.println("📘 Libros en idioma " + idioma + ":");
        libros.forEach(libro ->
                System.out.println("- " + libro.getTitulo())
        );
    }

    // 🔹 Listar todos los autores
    public void listarAutores() {
        List<Autor> autores = autorRepository.findAll();

        if (autores.isEmpty()) {
            System.out.println("📭 No hay autores registrados.");
            return;
        }

        System.out.println("🖊️ Autores registrados:");
        autores.forEach(a ->
                System.out.println("- " + a.getNombre()
                        + " (Nacimiento: " + a.getAnioNacimiento()
                        + ", Fallecimiento: " + a.getAnioFallecimiento() + ")")
        );
    }

    // 🔹 Autores vivos en un año específico
    public void listarAutoresVivosEnAnio(int anio) {

        List<Autor> vivosConFecha =
                autorRepository.findByAnioNacimientoLessThanEqualAndAnioFallecimientoGreaterThanEqual(anio, anio);

        List<Autor> vivosSinFecha =
                autorRepository.findByAnioNacimientoLessThanEqualAndAnioFallecimientoIsNull(anio);

        if (vivosConFecha.isEmpty() && vivosSinFecha.isEmpty()) {
            System.out.println("❌ No se encontraron autores vivos en ese año.");
            return;
        }

        System.out.println("🖊️ Autores vivos en el año " + anio + ":");

        vivosConFecha.forEach(a ->
                System.out.println("- " + a.getNombre())
        );

        vivosSinFecha.forEach(a ->
                System.out.println("- " + a.getNombre())
        );
    }

    // 🔥 Listar libros más descargados
    public void listarLibrosMasDescargados() {
        List<Libro> libros = libroRepository.findAllByOrderByNumeroDescargasDesc();

        if (libros.isEmpty()) {
            System.out.println("📭 No hay libros registrados.");
            return;
        }

        System.out.println("🔥 Libros más descargados:");
        libros.forEach(libro ->
                System.out.println("- " + libro.getTitulo()
                        + " (" + libro.getNumeroDescargas() + " descargas)")
        );
    }
}


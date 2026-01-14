package com.alura.literatura;

import com.alura.literatura.service.CatalogoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Scanner;

@SpringBootApplication
public class LiteraturaApplication {

    public static void main(String[] args) {
        SpringApplication.run(LiteraturaApplication.class, args);
    }

    @Bean
    public CommandLineRunner ejecutar(CatalogoService catalogoService) {
        return args -> {

            Scanner scanner = new Scanner(System.in);
            int opcion = -1;

            while (opcion != 0) {
                System.out.println("""
                        
                        📚 CATÁLOGO DE LIBROS
                        1 - Buscar libro por título
                        2 - Listar libros guardados
                        3 - Listar autores
                        4 - Listar autores vivos en un año
                        5 - Listar libros por idioma
                        0 - Salir
                        """);

                System.out.print("Seleccione una opción: ");
                opcion = scanner.nextInt();
                scanner.nextLine(); // limpiar buffer

                switch (opcion) {
                    case 1 -> {
                        System.out.print("Ingrese el título del libro: ");
                        String titulo = scanner.nextLine();
                        catalogoService.buscarYGuardarLibro(titulo);
                    }
                    case 2 -> catalogoService.listarLibros();
                    case 3 -> catalogoService.listarAutores();
                    case 4 -> {
                        System.out.print("Ingrese el año: ");
                        int anio = scanner.nextInt();
                        scanner.nextLine();
                        catalogoService.listarAutoresVivosEnAnio(anio);
                    }
                    case 5 -> {
                        System.out.print("Ingrese el idioma (ej: en, es, fr): ");
                        String idioma = scanner.nextLine();
                        catalogoService.listarLibrosPorIdioma(idioma);
                    }
                    case 0 -> System.out.println("👋 Saliendo del sistema...");
                    default -> System.out.println("❌ Opción inválida");
                }
            }
        };
    }
}

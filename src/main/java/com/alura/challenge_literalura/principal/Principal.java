package com.alura.challenge_literalura.principal;

import com.alura.challenge_literalura.model.*;
import com.alura.challenge_literalura.repository.AutorRepository;
import com.alura.challenge_literalura.repository.LibroRepository;
import com.alura.challenge_literalura.service.ConsumoApi;
import com.alura.challenge_literalura.service.ConvertidorDeRecords;
import com.alura.challenge_literalura.service.ConvierteDatos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.*;



@Component
public class Principal {

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private LibroRepository libroRepository;

    private static final Map<String, String> languageMap = new HashMap<>();

    static {
        languageMap.put("español", "es");
        languageMap.put("inglés", "en");
        // Agrega más idiomas según sea necesario
    }

    private ConsumoApi consumoApi = new ConsumoApi();
    private ConvierteDatos convierteDatos = new ConvierteDatos();
    private ConvertidorDeRecords convertidorDeRecords = new ConvertidorDeRecords();
    private final Scanner scanner = new Scanner(System.in);
    private final String URL_BASE = "https://gutendex.com/books/?search=";
    private List<Libro> libros;

    public Principal(){}

    public Principal(LibroRepository libroRepository,AutorRepository autorRepository){
        this.libroRepository = libroRepository;
        this.autorRepository = autorRepository;
    }


    public void mostrarMenu() {
        boolean bandera = true;
        while (bandera) {
            var menu = """
            *************************************************
            \n1- Buscar libro
            2 - Listar libros buscados
            3 - Listar autores
            4 - Buscar autor(es) vivos en un año determinado
            5 - Buscar libros por idioma
            
            6 - Salir\n
            *************************************************
            """;
            System.out.println(menu);
            System.out.println("Ingresa la opción que desea: ");
            var opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    guardarLibro();
                    break;
                case 2:
                    listarLibros();
                    break;
                case 3:
                    listarAutores();
                    break;
                case 4:
                    buscarAutoresVivosEnAno();
                    break;
                case 5:
                    buscarLibrosPorIdioma();
                    break;
                case 6:
                    bandera = false;
                    System.out.println("Cerrando la aplicación...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }

    }

    private DatosRecord buscaLibroYConvierteDatosRecord() {
        System.out.println("Ingrese el nombre del libro que desea buscar: ");
        String nombreLibro = scanner.nextLine();
        var json = consumoApi.obtenerDatos(URL_BASE + nombreLibro.replace(" ","+"));
        DatosRecord datos = convierteDatos.obtenerDatos(json, DatosRecord.class);

        // Verificar si hay resultados y retornar solo el primero si existe
        if (datos != null && !datos.results().isEmpty()) {
            return new DatosRecord(Collections.singletonList(datos.results().get(0)));
        } else {
            System.out.println("No se encontró ningún libro con ese nombre.");
            return null;
        }
    }

    private void guardarLibro() {
        DatosRecord datos = buscaLibroYConvierteDatosRecord();

        if (datos != null) {
            Libro libro = convertidorDeRecords.convertirLibroRecordALibro(datos.results().get(0));

            // Verificar si el libro ya está registrado antes de guardarlo
            Libro existingLibro = libroRepository.findByTitle(libro.getTitle());
            if (existingLibro != null) {
                System.out.println("Libro ya registrado.");
            } else {
                if (libro.getTitle() != null && libro.getAuthors() != null && !libro.getAuthors().isEmpty()) {
                    libroRepository.save(libro);
                    System.out.println("Libro guardado exitosamente.");
                } else {
                    System.out.println("Datos incompletos: No se puede insertar el libro");
                }
            }
        }
    }

    private void listarLibros() {
        List<Libro> libros = libroRepository.findAll();
        libros.forEach(libro -> System.out.println(libro.getTitle()));
    }

    private void listarAutores() {
        List<Autor> autores = autorRepository.findAll();
        autores.forEach(autor -> System.out.println(autor.getName()));
    }

    private void buscarAutoresVivosEnAno() {
        System.out.println("Ingrese el año:");
        int ano = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        List<Autor> autores = autorRepository.findAutoresVivosEnAno(ano);
        autores.forEach(autor -> System.out.println(autor.getName()));
    }

    private void buscarLibrosPorIdioma() {
        System.out.println("Ingrese el idioma:");
        String idioma = scanner.nextLine().toLowerCase();

        String languageCode = languageMap.get(idioma);
        if (languageCode != null) {
            List<Libro> libros = libroRepository.findByLanguage(languageCode);
            libros.forEach(libro -> System.out.println(libro.getTitle()));
        } else {
            System.out.println("Idioma no encontrado.");
        }
    }

}

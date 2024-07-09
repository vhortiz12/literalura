# Challenge Literalura

¡Bienvenido al proyecto **Challenge Literalura**!

## Descripción

Challenge Literalura es una aplicación diseñada para gestionar libros y autores a través de datos obtenidos de una API externa. Utiliza tecnologías modernas como Java, Spring, y PostgreSQL para ofrecer una solución robusta y eficiente para la gestión de literatura.

## Características

- **Búsqueda y almacenamiento de libros**: Permite buscar libros en una API externa y almacenarlos en una base de datos PostgreSQL.
- **Gestión de autores**: Administra los autores de los libros, incluyendo la capacidad de listar autores registrados y buscar autores vivos en un año específico.
- **Prevención de duplicados**: Verifica si un libro ya está registrado antes de insertarlo, evitando duplicados.
- **Listado de lenguajes**: Muestra los lenguajes disponibles para cada libro.

## Tecnologías

- **Java**: Lenguaje de programación principal.
- **Spring Framework**: Para la gestión de dependencias y la creación de la aplicación web.
- **PostgreSQL**: Base de datos utilizada para almacenar los libros y autores.
- **Maven**: Herramienta de construcción y gestión de dependencias.
- **Records de Java**: Para manejar datos de la API de manera eficiente y moderna.
- **Stream y Lambdas**: Para operaciones funcionales y manipulación de datos.

## Estructura del Proyecto

- **src**: Contiene el código fuente del proyecto.
  - `main/java`: Código fuente principal de la aplicación.
  - `main/resources`: Archivos de configuración y otros recursos.
  - `test/java`: Pruebas unitarias y de integración.
- **pom.xml**: Archivo de configuración de Maven.
- **mvnw** y **mvnw.cmd**: Scripts para ejecutar Maven Wrapper.

## Cómo Empezar

1. **Clona el repositorio**:
    ```sh
    git clone https://github.com/tu-usuario/challenge-literalura.git
    ```
2. **Navega al directorio del proyecto**:
    ```sh
    cd challenge-literalura
    ```
3. **Compila y ejecuta la aplicación**:
    ```sh
    ./mvnw spring-boot:run
    ```

## Contribuciones

¡Las contribuciones son bienvenidas! Si encuentras un problema o tienes una mejora, por favor abre un issue o un pull request en el repositorio de GitHub.

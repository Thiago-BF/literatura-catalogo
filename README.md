Literatura Catálogo - Challenge LiterAlura
📝 Descripción del Proyecto
Literatura Catálogo es una aplicación de consola robusta diseñada para la gestión y exploración de datos literarios. El sistema permite interactuar con la API externa de Gutendex para buscar libros, persistir la información en una base de datos relacional y realizar consultas estadísticas avanzadas sobre autores y obras.

Este proyecto fue desarrollado como parte del Challenge LiterAlura de Alura Latam, enfocándose en el consumo de APIs REST, el modelado de datos con JPA/Hibernate y la manipulación de flujos de datos con Java Streams.

🚀 Funcionalidades Principales
Búsqueda de Libros por Título: Consulta directa a la API Gutendex y persistencia automática en la BD.

Listado de Libros Registrados: Visualización de todas las obras almacenadas localmente.

Gestión de Autores: Listado de autores registrados con su respectiva información biográfica.

Filtro por Época: Búsqueda de autores que estuvieron vivos en un año determinado.

Filtro por Idioma: Consulta de libros según su sigla de idioma (es, en, fr, pt).

Estadísticas de Datos: Generación de métricas (máximos, mínimos y promedios) basadas en las descargas de los libros.

Top 10: Visualización de los libros más populares descargados.

🛠️ Tecnologías Utilizadas
Lenguaje: Java 17

Framework: Spring Boot 3.x

Gestor de Dependencias: Maven

Persistencia: Spring Data JPA

Base de Datos: PostgreSQL

API Externa: Gutendex API

Mapeo JSON: Jackson (ObjectMapper)

⚙️ Configuración del Entorno
Antes de comenzar, asegúrate de tener instalado:

JDK 17 o superior.

Maven (opcional si usas el wrapper ./mvnw).

PostgreSQL en ejecución.

Variables de Entorno
Debes configurar las siguientes variables en tu entorno o editar el archivo src/main/resources/application.properties:

Properties
DB_HOST=localhost
DB_NAME=literatura_db
DB_USER=tu_usuario
DB_PASSWORD=tu_contraseña
📥 Instalación y Ejecución
Clonar el repositorio:

Bash
git clone https://github.com/Thiago-BF/literatura-catalogo.git
cd literatura-catalogo
Configurar la Base de Datos:
Crea una base de datos en PostgreSQL llamada literatura_db.

Compilar el proyecto:

Bash
mvn clean install
Ejecutar la aplicación:

Bash
mvn spring-boot:run
📂 Estructura del Proyecto
Plaintext
src/main/java/com/thiagobf/literatura
├── principal          # Clase con la lógica del menú interactivo
├── model              # Entidades JPA y DTOs (Records)
├── repository         # Interfaces para acceso a datos (Spring Data)
├── service            # Lógica de consumo de API y conversión de datos
└── LiteraturaApplication.java # Clase principal de Spring Boot
📊 Ejemplo de Uso
Al iniciar la aplicación, se desplegará un menú interactivo en la consola:

Plaintext
***************************************************
            LITERALURA - CATÁLOGO
***************************************************
1 - Buscar libro por título
2 - Listar libros registrados
3 - Listar autores registrados
4 - Listar autores vivos en un determinado año
5 - Listar libros por idioma
0 - Salir
***************************************************
Elija una opción:
✒️ Autor
Thiago Beber Feil
Programmer.

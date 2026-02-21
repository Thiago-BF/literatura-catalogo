📚 LiterAlura - Catálogo de Libros
Proyecto backend desarrollado con Spring Boot para la gestión y consulta de un catálogo literario.
El sistema consume datos de la API externa Gutendex para buscar información sobre libros y autores, permitiendo su persistencia y consulta local.

📌 Funcionalidades
Búsqueda de libros por título: Consulta la API de Gutendex y registra el libro en la base de datos.

Listado de libros registrados: Visualiza todos los libros almacenados localmente.

Listado de autores registrados: Muestra la información de los autores de los libros guardados.

Filtro de autores por año: Lista autores que estaban vivos en un año determinado.

Filtro por idioma: Permite listar libros según el lenguaje (español, inglés, francés, etc.).

🚀 Tecnologías utilizadas
Java 17+

Spring Boot

Spring Data JPA

MySQL (o PostgreSQL según tu configuración)

Jackson/Gson (para el parseo de JSON)

Maven

⚙️ Configuración del proyecto
Antes de ejecutar la aplicación, asegúrate de configurar las variables de entorno para la conexión a la base de datos en tu archivo application.properties:

Properties
spring.datasource.url=jdbc:mysql://localhost:3306/literalura_db
spring.datasource.username=tu_usuario
spring.datasource.password=tu_password
🗄️ Base de datos
La aplicación utiliza persistencia de datos para evitar consultas repetitivas a la API.

Crea una base de datos llamada: literalura_db

Hibernate se encargará de crear las tablas automáticamente al iniciar la aplicación (ddl-auto=update).

▶️ Cómo ejecutar el proyecto
Desde la raíz del proyecto:

En Windows:

Bash
mvnw spring-boot:run
O usando Maven instalado:

Bash
mvn spring-boot:run
La aplicación es una aplicación de consola, por lo que al iniciar verás un menú interactivo en la terminal para navegar por las opciones.

📂 Estructura del proyecto
com.thiago.forohub.main → Clase principal con el menú interactivo.

com.thiago.forohub.model → Entidades (Libro, Autor) y clases de mapeo (Records para DTOs).

com.thiago.forohub.repository → Interfaces para la persistencia de datos.

com.thiago.forohub.service → Lógica para el consumo de la API y conversión de datos.

👨‍💻 Autor
Thiago Beber Feil Programmer.

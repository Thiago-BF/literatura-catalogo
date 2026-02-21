# 📚 Literatura Catálogo

Proyecto desarrollado con Spring Boot como aplicación de consola para la gestión y exploración de datos literarios.

Permite:

- Buscar libros por título consumiendo la API Gutendex
- Persistir libros y autores en PostgreSQL
- Listar libros registrados
- Listar autores registrados
- Filtrar autores vivos en un año determinado
- Filtrar libros por idioma
- Generar estadísticas de descargas
- Mostrar el Top 10 de libros más descargados

---

## 🚀 Tecnologías utilizadas

- Java 17
- Spring Boot 3.x
- Spring Data JPA
- PostgreSQL
- Maven
- Jackson (ObjectMapper)
- Gutendex API

---

## ⚙️ Configuración del proyecto

Antes de ejecutar la aplicación, configurar las siguientes variables de entorno:

DB_HOST=localhost  
DB_NAME=literatura_db  
DB_USER=tu_usuario  
DB_PASSWORD=tu_password  

También pueden configurarse en:

src/main/resources/application.properties

---

## 🗄️ Base de datos

La aplicación utiliza PostgreSQL.

Crear una base de datos llamada:

literatura_db

Las tablas se crean automáticamente al iniciar la aplicación mediante JPA / Hibernate.

---

## ▶️ Cómo ejecutar el proyecto

Clonar el repositorio:

git clone https://github.com/Thiago-BF/literatura-catalogo.git  
cd literatura-catalogo  

Ejecutar con Maven Wrapper:

mvnw spring-boot:run  

O usando Maven instalado:

mvn spring-boot:run  

La aplicación se ejecutará en consola mostrando el menú interactivo.

---

## 🖥️ Menú interactivo

Al iniciar la aplicación:

***************************************************
            LITERALURA - CATÁLOGO
***************************************************
1 - Buscar libro por título
2 - Listar libros registrados
3 - Listar autores registrados
4 - Listar autores vivos en un determinado año
5 - Listar libros por idioma
6 - Estadísticas de descargas
7 - Top 10 libros más descargados
0 - Salir
***************************************************
Elija una opción:

---

## 📂 Estructura del proyecto

src/main/java/com/thiagobf/literatura

├── principal          → Lógica del menú interactivo  
├── model              → Entidades JPA y DTOs  
├── repository         → Interfaces Spring Data  
├── service            → Consumo de API y procesamiento  
└── LiteraturaApplication.java  

---

## 🌐 API utilizada

Gutendex API  
https://gutendex.com

---

## 👨‍💻 Autor

Thiago Beber Feil
Programmer.

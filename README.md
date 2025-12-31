# ProductReviewAPI - ReadME

Mini backend desarrollado con **Spring Boot** que implementa un sistema de **gestión de productos y reseñas**, protegido con **Spring Security + JWT**, incluyendo control de roles y estadísticas agregadas.
Este proyecto fue desarrollado como práctica académica para reforzar conceptos de:
- Arquitectura REST
- Seguridad con JWT
- Persistencia con JPA / Hibernate
- Pruebas de endpoints con Postman

## 🚀 Tecnologías utilizadas:
- Java 17
- Spring Boot
- Spring Security
- JWT (JSON Web Token)
- Spring Data JPA
- PostgreSQL
- ModelMapper
- Maven
- Postman

## 📁 Estructura del proyecto:
- ProductReviewAPI/
    - src/
      - main/
        - java/com/upc/productreviewapi/
           - controllers
           - services
           - controllers
           - repositories
           - entities
           - dtos
           - security
        - resources/
           - application.properties
           - import.sql
    - postman/
      - ProductReviewAPI.postman_collection.json
      - ProductReviewAPI.postman_environment.json
    - pom.xml
    - README.md

## 🔐 Seguridad y roles:
El sistema utiliza **JWT** para autenticación y autorización.

### Roles configurados:
- ROLE_ADMIN
- ROLE_USER
- ROLE_CONSULTOR

El acceso a los endpoints está protegido con "@PreAuthorize" según el rol.

### Endpoint:
🔑 Autenticación:
POST /api/dulanto/authenticate

Body (JSON)
json:
{
  "username": "admin",
  "password": "12345"
}

📦 Endpoints principales

🛒 Productos:
- Crear producto 
POST /api/dulanto/trujillo/producto

- Listar productos
GET /api/dulanto/trujillo/producto

⭐ Reseñas:
- Crear reseña
POST /api/dulanto/trujillo/resena

- Listar reseñas
GET /api/dulanto/trujillo/getresenas

📊 Analítica:
- Estadísticas de reseñas por producto
GET /api/dulanto/trujillo/jpls/estadistica
Retorna promedio de calificaciones y cantidad de reseñas agrupadas por marca.

🧪 Pruebas con Postman
En la carpeta postman/ se incluyen:
- Collection con todos los endpoints
- Environment con variables como: (baseUrl, token)

## Pasos:
1. Importar la collection
2. Importar el environment
3. Ejecutar el endpoint de autenticación
4. El token se reutiliza para los demás requests

🗄️ Base de datos:
- Base de datos: PostgreSQL
- Datos iniciales cargados mediante import.sql
- Usuarios y roles precargados para pruebas

## 👨‍💻 Autor:
- Robbie James Dulanto Trujillo
- Estudiante de Ingeniería de Sistemas de Información – UPC
- Proyecto académico

📌 Estado del proyecto:
-  Funcional
-  Seguridad implementada
-  Endpoints probados
-  Listo para evaluación

# Evaluación 2 - AuraMove
---
# Índice
-  [1) Descripción del proyecto](#Descripción-del-Proyecto)
-  [2) Funcionalidades Implementadas](#Funcionalidades-Implementadas)
-  [3) Arquitectura del proyecto](#Arquitectura-del-Proyecto)
-  [4) Relaciones JPA Implementadas](#Relaciones-JPA-Implementadas)
-  [5) DTOs Implementados](#DTOs-Implementados)
-  [6) Validaciones](#Validaciones)
-  [7) Manejo Global de Excepciones](#Manejo-Global-de-Excepciones)
-  [8) API Externa](#API-Externa)
-  [9) Base de Datos](#Base-de-Datos)
-  [10) Pasos para Ejecutar el Proyecto](#Pasos-para-Ejecutar-el-Proyecto)
-  [11) API Endpoints & Uso en Postman](#api-postman)
-  [12) Detalle de Endpoints](#Detalle-de-Endpoints)
-  [13) Integrantes](#Integrantes)
---

# Descripción del Proyecto

**AuraMove API** es una Aplicación backend desarrollada con **Spring Boot** y **MySQL**, enfocada en la gestión de usuarios, rutinas, entrenamientos y ejercicios mediante una API REST orientada al mundo fitness y entrenamiento personalizado.

El proyecto busca representar una web de gimnasio donde distintos usuarios puedan buscar ejercicios y rutinas según el tipo de entrenamiento que desean comenzar. La aplicación permite desglosar la información necesaria para iniciar una rutina de entrenamiento, mostrando ejercicios relacionados, niveles de dificultad, duración de sesiones y distintos tipos de rutinas adaptadas a cada usuario.

Además, el sistema permite administrar:

* Usuarios
* Rutinas
* Entrenamientos
* Ejercicios
* Sucursales

El proyecto también incluye integración con una API externa utilizando **Open Meteo API**, la cual permite obtener información climática desde un servicio REST externo.

Para el desarrollo del proyecto se utilizaron las siguientes tecnologías:

* Java 17
* Spring Boot
* Spring Data JPA
* Hibernate
* MySQL
* Maven
* Lombok
* Postman

---

# Funcionalidades Implementadas

## CRUD Completo

El sistema incluye operaciones CRUD para las principales entidades del proyecto:

* Usuarios
* Rutinas
* Entrenamientos
* Ejercicios
* Sucursales

Estas operaciones permiten crear, listar, actualizar y eliminar información desde la API REST mediante distintos endpoints probados en Postman.

---

## Arquitectura del Proyecto

El proyecto fue desarrollado utilizando arquitectura CSR (**Controller - Service - Repository**), separando las responsabilidades de cada capa para mantener un código más ordenado y fácil de mantener.

La aplicación se encuentra organizada en distintas carpetas encargadas de manejar los controladores, servicios, repositorios, modelos, DTOs, excepciones y configuraciones generales del sistema. Esta estructura permite separar la lógica del negocio, el acceso a datos y la exposición de endpoints REST de forma más clara y profesional.

---

## Relaciones JPA Implementadas

El proyecto implementa relaciones entre entidades utilizando JPA/Hibernate, permitiendo conectar la información entre usuarios, rutinas, entrenamientos y ejercicios.

Se utilizaron relaciones como:

* OneToMany
* ManyToOne
* ManyToMany

Esto permite que, por ejemplo, un usuario pueda tener varias rutinas, o que un entrenamiento pueda tener múltiples ejercicios asociados.

---

## DTOs Implementados

El proyecto implementa distintos DTOs para simplificar y organizar la información enviada en algunas respuestas de la API, evitando exponer datos innecesarios de las entidades principales.

Actualmente se implementaron los siguientes DTOs:

* `EjercicioDTO`
* `EntrenamientoDTO`
* `RutinaDTO`
* `SucursalDTO`
* `UserEmailDTO`
* `WeatherDTO`

Estos DTOs permiten entregar información más ordenada y específica según la funcionalidad utilizada dentro de la aplicación.

---

## Validaciones

El proyecto incluye validaciones utilizando anotaciones de Spring Validation y Jakarta Validation, tales como:

* `@Valid`
* `@NotBlank`
* `@NotNull`
* `@Min`
* `@Max`

Estas validaciones ayudan a controlar que la información ingresada por el usuario cumpla con los requisitos mínimos antes de almacenarse en la base de datos.

---

## Manejo Global de Excepciones

Se implementó un manejo global de excepciones mediante:

```txt
GlobalExceptionHandler
```

Esto permite controlar errores de forma más ordenada dentro de la aplicación y entregar respuestas más claras al momento de realizar pruebas en Postman.

---

## API Externa

El proyecto integra la API externa:

```txt
Open Meteo API
```

la cual se utiliza para obtener información climática desde un servicio REST externo. Esta integración fue realizada para aplicar el consumo de APIs externas dentro del proyecto utilizando herramientas de Spring Boot.

---

# Base de Datos

La aplicación utiliza una base de datos MySQL llamada:

```sql
auramove
```

La base de datos almacena toda la información relacionada con los usuarios, rutinas, ejercicios, entrenamientos y sucursales del sistema.

Las tablas fueron generadas automáticamente utilizando JPA/Hibernate a partir de las entidades creadas en el proyecto, permitiendo que las relaciones entre modelos se reflejen directamente en MySQL.

Tablas principales del sistema:

* usuarios
* rutinas
* entrenamientos
* ejercicios
* sucursales

Además, debido a las relaciones ManyToMany implementadas entre entrenamientos y ejercicios, se genera automáticamente una tabla intermedia encargada de relacionar ambas entidades.

El archivo `src/main/resources/application.properties` contiene la conexión:
```properties
server.port=${PORT:8080}
spring.datasource.url=${DB_URL:${MYSQL_URL}}
spring.datasource.username=${DB_USERNAME:${MYSQLUSER}}
spring.datasource.password=${DB_PASSWORD:${MYSQLPASSWORD}}
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

Laragon y HeidiSQL fueron configurados utilizando el puerto:

```txt
3307
```

## Recomendación de seguridad (credenciales)
No se suben las credenciales reales al repositorio. Este proyecto está preparado para leer datos secretos desde variables de entorno: 
- `DB_URL`
- `DB_USERNAME`
- `DB_PASSWORD`
- `JWT_SECTRET`
 
Esto permite la correcta conexión con MySQL durante el desarrollo del proyecto.
Para desarrollo local se pueden exportar en terminal (PowerShell):
```
$env:DB_URL="jdbc:mysql://localhost:3307/bibliotecaduoc?createDatabaseIfNotExist=true&useSSL=false&serverTimezone=UTC"
$env:DB_USERNAME="root"
$env:DB_PASSWORD="tu_password"
$env:JWT_SECRET="una-clave-larga-y-segura-de-al-menos-32-caracteres"
.\mvnw.cmd spring-boot:run

```
Para Docker Compose, usa un archivo `.env` (no versionado). Hay una plantilla en `.env.example`
(Nota: En esta configuracion **No hay valores por defecto** para credenciales/secretos. Si falta una variable de entorno, la app/compose fallará al iniciar (intencional)

---

# Pasos para Ejecutar el Proyecto

## 1. Requisitos Previos

Antes de ejecutar el proyecto es necesario tener instalado:

* Java 17
* Visual Studio Code o IntelliJ IDEA
* Laragon
* HeidiSQL
* Postman
* Maven

---

## 2. Clonar el repositorio

```bash
git clone https://github.com/Cr1stoph/AuraMove.git
```

---

## 3. Ejecutar Laragon y MySQL

Iniciar Laragon y posteriormente abrir HeidiSQL para conectarse al servidor MySQL.

Crear la base de datos ejecutando:

```sql
CREATE DATABASE auramove;
```

---

## 4. Verificar application.properties

Verificar que la información del archivo:

```txt
application.properties
```

coincida correctamente con la configuración realizada en Laragon y HeidiSQL, especialmente el puerto 3037 utilizado por MySQL ya que si se hace con un puerto distinto no funcionara correctamente.

---

## 5. Ejecutar el Proyecto

Abrir el proyecto en Visual Studio Code o IntelliJ IDEA y ejecutar:

```txt
AuramoveApplication.java
```

Al iniciar la aplicación, Hibernate/JPA generará automáticamente las tablas correspondientes en la base de datos.

---

## 6. Pruebas en Postman

Las pruebas de la API fueron realizadas utilizando Postman, permitiendo probar operaciones como:

* GET
* POST
* PUT
* DELETE
## <a id="api-postman"></a> 11) API Endpoints & Uso en Postman

La URL base de la API es: `http://localhost:8080/api/v1`

### Resumen de Endpoints (Los demás usan la misma estructura)

| Método | Endpoint | Descripción |
| :--- | :--- | :--- |
| **GET** | `/usuario` | Obtiene todos los usuarios |
| **POST** | `/usuario` | Crea un nuevo usuario |
| **PUT** | `/usuario/:id` | Actualiza un usuario por ID |
| **DEL** | `/usuario/:id` | Elimina un usuario por ID |

---

### Detalle de Endpoints
Asegurando estar en el apartado "Body" de tipo JSON en postman para su buen funcionamiento.

#### 1. Crear Usuario Request Body (JSON)
En postman con esta URL: http://localhost:8080/api/v1/usuarios
```json
{
    "nombre": "Javier",
    "apellido": "Valencia",
    "email": "javier222@gmail.com",
    "contraseña" : "1234",
    "edad" : "22" 
}
```
Devuelve todos los usuarios registrados con su respectiva información de entrenamiento, la sucursal a la que asisten.
También podemos ver los datos meteorológicos en tiempo real de la ubicacion que se quiera buscar.

### 2. Obtener temperatura y velocidad del viento en Santiago
En postman con esta URL: http://localhost:8080/api/v1/clima
devolviendo algo como:
```json
{
    "current_weather": {
        "temperature": 7.3,
        "windspeed": 1.3
    }
}
```

Además de validar respuestas, manejo de errores y consumo de API externa (Open Meteo).

### 3. Obtener temperatura de lugares especificos
Postman URL: http://localhost:8080/api/v1/clima?lat=-41.47&lon=-72.94&
En este caso es Puerto Montt, la respuesta será algo así:
```json
{
    "current_weather": {
        "temperature": 4.6,
        "windspeed": 1.6
    }
}
```

---

# Integrantes

* Cristopher Roa
* Javier Valencia

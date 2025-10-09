# Modulo de Estadisticas - Sección Backend

## Descripción

Nuestro módulo de estadisticas contiene la lógica básica para tomar asistencias entre estudiantes y grupos en general. Este módulo contiene una estructura de encarpetado y las capas necesarias para el funcionamiento de la API.

## Dependencias
```text
  spring-boot-starter-data-jpa
  spring-boot-starter-web
  spring-boot-devtools
  h2
  mysql-connector-j
  spring-boot-starter-test
  mapstruct
  mapstruct-processor
```
## Pasos para montar la base de datos

1. Crear BD en XAMPP / SSMS (SQL Server Management Studio) con el nombre `bd_estadisticas`.
2. Configurar credenciales de conexión en el archivo `/src/main/resources/application.properties`.
3. Verificar la correcta creación de las tablas al ejecutar.

## Ejecución del proyecto

1. Clonar el repositorio (`git clone https://github.com/diaz8219/estadisticas-backend.git`).
2. Abrir repositorio en una IDE (IntelliJ, Eclipse, Visual Studio Code, etc.).
3. Ejecutar la clase principal `EstadisticasBackendApplication.java`.

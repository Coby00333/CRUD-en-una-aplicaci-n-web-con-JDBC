# CRUD-en-una-aplicaci-n-web-con-JDBC
En esta actividad, vamos a desarrollar una aplicación Java que interactúe con una base de datos MySQL para realizar operaciones CRUD.
Nombre: Carly Díaz Gutiérrez
Unidad: 6
Tema:Implementación de operaciones CRUD en una aplicación web con JDBC.


fechas: 29/12/2024


________________



```markdown
# Proyecto de Acceso a Datos con JDBC


## Descripción


Este proyecto implementa operaciones CRUD (Crear, Leer, Actualizar y Eliminar) en una base de datos MySQL utilizando JDBC en una aplicación Java. El objetivo es interactuar con una base de datos llamada `Tienda`, donde se gestionan productos a través de una tabla `Productos`.


## Estructura del Proyecto


El proyecto se compone de las siguientes clases:


- **Main**: Clase principal que inicia la aplicación y permite interactuar con las operaciones CRUD.
- **UsuarioDAO**: Clase responsable de realizar las operaciones CRUD en la tabla `Productos`.
- **DatabaseConnection**: Clase que establece la conexión con la base de datos MySQL.


## Requisitos


- Java 8 o superior.
- XAMPP (para ejecutar el servidor MySQL).
- MySQL Workbench (opcional, para gestionar la base de datos).
- IntelliJ IDEA Community Edition 2024.2.4


## Instalación y Configuración


1. **Activar XAMPP**: Inicia el panel de control de XAMPP y activa el módulo de MySQL.


2. **Crear la Base de Datos**:
   - Abre MySQL Workbench y conecta al servidor local.
   - Ejecuta el siguiente script SQL para crear la base de datos y la tabla:


   ```sql
   CREATE DATABASE Tienda;


   USE Tienda;


   CREATE TABLE Productos (
     id INT AUTO_INCREMENT PRIMARY KEY,
     nombre VARCHAR(255) NOT NULL,
     precio FLOAT
   );
   ```


3. **Configurar el Proyecto Java**:
   - Crea un nuevo proyecto Java en tu IDE (Eclipse o IntelliJ IDEA).
   - Asegúrate de incluir el driver JDBC para MySQL en tu proyecto. Puedes descargar el JAR y añadirlo al classpath, o usar Maven para gestionarlo como dependencia.


4. **Configurar la Conexión a la Base de Datos**:
   - Modifica la clase `DatabaseConnection` para incluir tu usuario y contraseña de MySQL.


   ```java
   private static final String USER = "root"; 
   private static final String PASSWORD = ""; 
   ```


## Ejecución


1. **Compila el Proyecto**: Asegúrate de que no haya errores en el código.


2. **Ejecuta la Clase Main**: Inicia la aplicación ejecutando la clase `Main`. Desde allí, puedes probar las operaciones CRUD:


   - Agregar productos.
   - Listar productos existentes.
   - Actualizar el precio de un producto.
   - Eliminar un producto.

## Manejo de Errores


Asegúrate de manejar adecuadamente las excepciones en tus métodos, especialmente `SQLException`, para evitar que la aplicación se detenga debido a un error en la base de datos.


## Contribuciones


Las contribuciones son bienvenidas. Si deseas mejorar el proyecto, siéntete libre de abrir un "issue" o un "pull request".


## Licencia


Este proyecto está bajo la Licencia MIT. Consulta el archivo `LICENSE` para más detalles.


#Importar el Driver JDBC en IntelliJ IDEA
##Agregar el JAR al Classpath:

###Abre tu proyecto en IntelliJ IDEA.
Haz clic derecho sobre el nombre de tu proyecto en el panel de Project (a la izquierda) y selecciona Open Module Settings (o presiona F4).
En la ventana que aparece, selecciona la pestaña Libraries.
Haz clic en el icono de + para agregar una nueva biblioteca.
Selecciona Java y navega a la carpeta jar de tu proyecto donde tienes el archivo JDBC JAR.
Selecciona el archivo JAR y haz clic en OK.
Confirmar la Adición:

Asegúrate de que el JAR aparezca en la lista de bibliotecas de tu proyecto.
Haz clic en Apply y luego en OK para cerrar la ventana de configuración.
Verificar la Configuración
Para asegurarte de que todo esté correcto:

Abre una clase donde estés utilizando JDBC (por ejemplo, DatabaseConnection).
Intenta importar las clases necesarias, como java.sql.Connection y java.sql.DriverManager.
Si IntelliJ no muestra errores de importación, significa que el JAR se ha añadido correctamente.
```








________________

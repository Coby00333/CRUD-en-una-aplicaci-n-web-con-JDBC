import java.sql.Connection; // Importa la clase Connection para manejar conexiones a la base de datos
import java.sql.DriverManager; // Importa DriverManager, que gestiona los controladores de base de datos
import java.sql.SQLException; // Importa SQLException, que maneja errores relacionados con SQL
import java.util.Properties; // Importa Properties, que permite gestionar pares de clave-valor para configuraciones

public class DatabaseConnection { // Define la clase DatabaseConnection
    // Define la URL de conexión a la base de datos MySQL, con parámetros para desactivar SSL y establecer la zona horaria
    private static final String URL = "jdbc:mysql://localhost:3306/tienda?useSSL=false&serverTimezone=UTC";

    // Método estático que devuelve una conexión a la base de datos
    public static Connection getConnection() {
        Connection connection = null; // Inicializa la conexión como nula
        try {
            Properties properties = new Properties(); // Crea un objeto Properties para almacenar configuraciones de conexión
            properties.setProperty("user", "root"); // Establece el nombre de usuario para la conexión
            properties.setProperty("password", ""); // no he usado contraseña

            // Intenta obtener la conexión usando la URL y las propiedades definidas
            connection = DriverManager.getConnection(URL, properties);
            System.out.println("Conexión exitosa a la base de datos."); // Mensaje de éxito
        } catch (SQLException e) { // Captura excepciones de SQL
            // Imprime un mensaje de error si la conexión falla
            System.out.println("Error de conexión: " + e.getMessage());
            e.printStackTrace(); // Imprime el stack trace para más detalles sobre el error
        }
        return connection; // Devuelve la conexión (puede ser nula si hubo un error)
    }
}

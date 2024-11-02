import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    // Método para insertar tres productos en la tabla Productos
    public void insertarProductos() {
        // Consulta SQL para insertar un producto en la tabla
        String sql = "INSERT INTO Productos (nombre, precio) VALUES (?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            // Insertar el primer producto con nombre y precio específicos
            pstmt.setString(1, "Producto1");  // Nombre del producto
            pstmt.setFloat(2, 10.5f);         // Precio del producto
            pstmt.executeUpdate();            // Ejecutar la inserción

            // Insertar el segundo producto
            pstmt.setString(1, "Producto2");
            pstmt.setFloat(2, 20.0f);
            pstmt.executeUpdate();

            // Insertar el tercer producto
            pstmt.setString(1, "Producto3");
            pstmt.setFloat(2, 30.25f);
            pstmt.executeUpdate();

            System.out.println("Productos insertados con éxito.");
        } catch (SQLException e) {
            System.out.println("Error al insertar productos: " + e.getMessage());
            e.printStackTrace(); // Imprimir detalles de la excepción en caso de error
        }
    }

    // Método para leer y mostrar todos los productos de la tabla Productos
    public List<String> leerProductos() {
        List<String> productos = new ArrayList<>(); // Lista para almacenar productos
        String sql = "SELECT * FROM Productos";     // Consulta SQL para seleccionar todos los productos

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            // Recorrer el ResultSet y añadir cada producto a la lista
            while (rs.next()) {
                int id = rs.getInt("id");              // Obtener el ID del producto
                String nombre = rs.getString("nombre");// Obtener el nombre del producto
                float precio = rs.getFloat("precio");  // Obtener el precio del producto
                productos.add("ID: " + id + ", Nombre: " + nombre + ", Precio: " + precio); // Añadir a la lista
            }
        } catch (SQLException e) {
            System.out.println("Error al leer productos: " + e.getMessage());
            e.printStackTrace(); // Imprimir detalles de la excepción en caso de error
        }
        return productos; // Retornar la lista de productos
    }

    // Método para actualizar el precio de un producto por ID
    public void actualizarPrecio(int id, float nuevoPrecio) {
        // Consulta SQL para actualizar el precio de un producto
        String sql = "UPDATE Productos SET precio = ? WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setFloat(1, nuevoPrecio);  // Establecer el nuevo precio
            pstmt.setInt(2, id);             // Establecer el ID del producto a actualizar
            int rowsAffected = pstmt.executeUpdate(); // Ejecutar la actualización

            // Comprobar si algún producto fue actualizado
            if (rowsAffected > 0) {
                System.out.println("Precio actualizado para el producto con ID: " + id);
            } else {
                System.out.println("No se encontró un producto con el ID especificado.");
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar el precio: " + e.getMessage());
            e.printStackTrace(); // Imprimir detalles de la excepción en caso de error
        }
    }

    // Método para eliminar un producto de la tabla Productos por ID
    public void eliminarProducto(int id) {
        // Consulta SQL para eliminar un producto de la tabla
        String sql = "DELETE FROM Productos WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setInt(1, id); // Establecer el ID del producto a eliminar
            int rowsAffected = pstmt.executeUpdate(); // Ejecutar la eliminación

            // Comprobar si algún producto fue eliminado
            if (rowsAffected > 0) {
                System.out.println("Producto eliminado con ID: " + id);
            } else {
                System.out.println("No se encontró un producto con el ID especificado.");
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar el producto: " + e.getMessage());
            e.printStackTrace(); // Imprimir detalles de la excepción en caso de error
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Crear una instancia de UsuarioDAO
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        // Insertar productos
        System.out.println("Insertando productos...");
        usuarioDAO.insertarProductos();

        // Leer y mostrar todos los productos
        System.out.println("\nLeyendo productos:");
        for (String producto : usuarioDAO.leerProductos()) {
            System.out.println(producto);
        }

        // Actualizar el precio de un producto con ID específico
        int idActualizar = 1; // ID del producto que queremos actualizar
        float nuevoPrecio = 15.99f;
        System.out.println("\nActualizando precio del producto con ID " + idActualizar);
        usuarioDAO.actualizarPrecio(idActualizar, nuevoPrecio);

        // Leer y mostrar los productos nuevamente para ver el cambio
        System.out.println("\nProductos después de la actualización:");
        for (String producto : usuarioDAO.leerProductos()) {
            System.out.println(producto);
        }

        // Eliminar un producto por ID
        int idEliminar = 2; // ID del producto que queremos eliminar
        System.out.println("\nEliminando producto con ID " + idEliminar);
        usuarioDAO.eliminarProducto(idEliminar);

        // Leer y mostrar los productos después de la eliminación
        System.out.println("\nProductos después de la eliminación:");
        for (String producto : usuarioDAO.leerProductos()) {
            System.out.println(producto);
        }
    }
}

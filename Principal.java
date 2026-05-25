public class Principal {
    public static void main(String[] args) {
        ProductoService servicio = new ProductoService();

        System.out.println("--- PRUEBAS OPERACIONES CRUD ---");

        /*1.Test crear */
        System.out.println("\n1. Probando Crear:");
        Producto p1 = new Producto(1, "Arroz", "Libra de arroz", 3500, 20);
        servicio.crearProducto(p1);
        System.out.println("ÉXITO - Producto creado: " + servicio.obtenerPorId(1).getNombre());

        try {
            servicio.crearProducto(new Producto(1, "Clon", "Error", 1000, 1));
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR CONTROLADO] No se duplicó ID: " + e.getMessage());
        }

        /*2. Test leer */ 
        System.out.println("\n2. Probando Leer:");
        System.out.println("ÉXITO - El nombre de este articulo es: " + servicio.obtenerPorId(1).getNombre() + " y es: " + servicio.obtenerPorId(1).getDescripcion());
        

        /*3.Test actualizar */
        System.out.println("\n3. Probando Actualizar:");
        servicio.actualizarProducto(1, "Arroz Diana", "Libra", 3800, 15);
        System.out.println("ÉXITO - Fue modificado a: " + servicio.obtenerPorId(1).getNombre());
        try {
            servicio.actualizarProducto(999, "Error", "", 0, 0);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR CONTROLADO] " + e.getMessage());
        }

         /*2. Test leer cambio*/ 
        System.out.println("\n2. Probando Leer:");
        System.out.println("ÉXITO - El nombre de este articulo es: " + servicio.obtenerPorId(1).getNombre() + " y es: " + servicio.obtenerPorId(1).getDescripcion());
        

        /*4.Test Eliminar */
        System.out.println("\n4. Probando Eliminar:");
        boolean eliminado = servicio.eliminarProducto(999);
        System.out.println("ÉXITO - ¿Fue eliminado?: " + eliminado);

          /*2. Busca el elemento eliminado*/ 
        System.out.println("\n2. Probando Leer:");
        System.out.println("ÉXITO - El nombre de este articulo es: " + servicio.obtenerPorId(1).getNombre() + " y es: " + servicio.obtenerPorId(1).getDescripcion());
    }
}
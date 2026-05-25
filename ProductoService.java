import java.util.ArrayList;
import java.util.List;

public class ProductoService {
    private List<Producto> productos = new ArrayList<>();

    // 1.Crear; error si ya existe
    public Producto crearProducto(Producto producto) {
        for (Producto p : productos) {
            if (p.getId() == producto.getId()) {
                throw new IllegalArgumentException("Error: Ya existe un producto con el ID " + producto.getId());
            }
        }
        productos.add(producto);
        return producto;
    }

    // 2.Leer; todos o uno en especifico, error si no lo encuentra
    public List<Producto> listarTodos() {
        return productos;
    }

    public Producto obtenerPorId(int id) {
        for (Producto p : productos) {
            if (p.getId() == id) {
                return p;
            }
        }
        throw new IllegalArgumentException("Error: Producto con ID " + id + " no encontrado.");
    }

    // 3.Actualizar; error si no existe  
    public Producto actualizarProducto(int id, String nuevoNombre, String nuevaDesc, double nuevoPrecio, int nuevaCant) {
        Producto p = obtenerPorId(id);//Error
        p.setNombre(nuevoNombre);
        p.setDescripcion(nuevaDesc);
        p.setPrecio(nuevoPrecio);
        p.setCantidad(nuevaCant);
        return p;
    }

    // 4.Eliminar;  error si no existe
    public boolean eliminarProducto(int id) {
        Producto p = obtenerPorId(id); //Error
        return productos.remove(p);
    }
}
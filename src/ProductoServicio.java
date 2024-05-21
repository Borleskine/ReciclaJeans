import java.util.ArrayList;

public class ProductoServicio {
    private ArrayList<Producto> listaProductos;

    public ProductoServicio() {
        this.listaProductos = new ArrayList<>();
    }

    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public void agregarProducto(Producto producto) {
        listaProductos.add(producto);
    }

    public void listarProductos() {
        for (Producto producto : listaProductos) {
            System.out.println(producto);
        }
    }

    public Producto buscarProductoPorCodigo(String codigo) {
        for (Producto producto : listaProductos) {
            if (producto.getCodigo().equals(codigo)) {
                return producto;
            }
        }
        return null;
    }

    public void editarProducto(Producto producto, String atributo, String nuevoValor) {
        switch (atributo.toLowerCase()) {
            case "articulo":
                producto.setArticulo(nuevoValor);
                break;
            case "precio":
                producto.setPrecio(nuevoValor);
                break;
            case "descripcion":
                producto.setDescripcion(nuevoValor);
                break;
            case "codigo":
                producto.setCodigo(nuevoValor);
                break;
            case "talla":
                producto.setTalla(nuevoValor);
                break;
            case "marca":
                producto.setMarca(nuevoValor);
                break;
            case "color":
                producto.setColor(nuevoValor);
                break;
            default:
                System.out.println("Atributo no válido.");
                break;
        }
    }
}

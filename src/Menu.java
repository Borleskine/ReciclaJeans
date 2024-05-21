import java.util.Scanner;

public class Menu {
    private ProductoServicio productoServicio = new ProductoServicio();
    private ArchivoServicio archivoServicio = new ArchivoServicio();
    private Scanner scanner = new Scanner(System.in);

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("1 Listar Producto");
            System.out.println("2 Editar Datos");
            System.out.println("3 Importar Datos");
            System.out.println("4 Salir");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir el salto de línea
            switch (opcion) {
                case 1:
                    listarProductos();
                    break;
                case 2:
                    editarDatos();
                    break;
                case 3:
                    importarDatos();
                    break;
                case 4:
                    System.out.println("Abandonando el sistema de clientes...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 4);
    }

    private void listarProductos() {
        productoServicio.listarProductos();
    }

    private void editarDatos() {
        System.out.print("Ingrese código del producto: ");
        String codigo = scanner.nextLine();
        Producto producto = productoServicio.buscarProductoPorCodigo(codigo);
        if (producto != null) {
            System.out.println("1.-El nombre del articulo actual es: " + producto.getArticulo());
            System.out.println("2.-El código del producto: " + producto.getCodigo());
            System.out.println("3.-El color del producto: " + producto.getColor());
            System.out.println("4.-La descripción del producto: " + producto.getDescripcion());
            System.out.println("5.-La marca del producto: " + producto.getMarca());
            System.out.println("6.-El precio del producto: " + producto.getPrecio());
            System.out.println("7.-La talla del producto: " + producto.getTalla());
            System.out.print("Ingrese la opción a editar de los datos del producto: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir el salto de línea
            System.out.print("Ingrese el nuevo valor: ");
            String nuevoValor = scanner.nextLine();
            switch (opcion) {
                case 1:
                    productoServicio.editarProducto(producto, "articulo", nuevoValor);
                    break;
                case 2:
                    productoServicio.editarProducto(producto, "codigo", nuevoValor);
                    break;
                case 3:
                    productoServicio.editarProducto(producto, "color", nuevoValor);
                    break;
                case 4:
                    productoServicio.editarProducto(producto, "descripcion", nuevoValor);
                    break;
                case 5:
                    productoServicio.editarProducto(producto, "marca", nuevoValor);
                    break;
                case 6:
                    productoServicio.editarProducto(producto, "precio", nuevoValor);
                    break;
                case 7:
                    productoServicio.editarProducto(producto, "talla", nuevoValor);
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    private void importarDatos() {
        System.out.print("Ingresa la ruta en donde se encuentra el archivo ProductosImportados.csv: ");
        String ruta = scanner.nextLine();
        archivoServicio.cargarDatos(ruta, productoServicio);
    }

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.mostrarMenu();
    }
}

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ArchivoServicio {
    public void cargarDatos(String ruta, ProductoServicio productoServicio) {
        String linea;
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                Producto producto = new Producto(datos[0], datos[1], datos[2], datos[3], datos[4], datos[5], datos[6]);
                productoServicio.agregarProducto(producto);
            }
            System.out.println("Datos cargados correctamente en la lista.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

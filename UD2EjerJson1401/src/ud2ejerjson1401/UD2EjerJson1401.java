package ud2ejerjson1401;

//UD2EjerJson1401
import java.io.IOException;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonValue;
import utils.JsonUtils;
import static utils.JsonUtils.getArrayFromFile;

//Dado un archivo con datos de contenedores de frutas con el formato
//siguiente (el profesor entregará el archivo completo).
//Realizar aplicación que realice los siguientes procesos:
//P1) Cargar Archivo JsonArray a Memoria
//P2) Recorrer los JsonObject del JsonArray y mostrar los datos por
//consola de aquellos cuyo país de origen sea "FR".
//Formatearemos el resultado con System.out.printf.
public class UD2EjerJson1401 {

    public static void main(String[] args) throws IOException {

        // Crear String con el contenido del Json 
        String fichero = "./datos/contenedores-frutas-50.json";

        // Obtener un JsonObject a partir del String
        JsonArray jsonContenedoresDeFrutas = JsonUtils.getArrayFromFile(fichero);

        // ***********************************
        // Imprimir contenido de jsonArray
        // ***********************************
        System.out.println("Contenedores del país FR");
        System.out.println("------------------------");
        JsonObject contenedor;
        for (JsonValue elemento : jsonContenedoresDeFrutas) {
            contenedor = (JsonObject) elemento;
            if ("FR".equals(contenedor.getString("pais"))) {
                System.out.printf("IdContenedor: %4d Producto: %-15s País: %-4s Ciudad: %-10s\n",
                        contenedor.getInt("idContenedor"),
                        contenedor.getString("producto"),
                        contenedor.getString("pais"),
                        contenedor.getString("ciudad"));
            }
        }
        System.out.println("------------------------");
    }
}

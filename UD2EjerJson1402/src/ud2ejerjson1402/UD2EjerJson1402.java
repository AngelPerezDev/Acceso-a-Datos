package ud2ejerjson1402;

//UD2EjerJson1402
import java.io.IOException;
import java.util.Iterator;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonValue;
import utils.JsonUtils;

//Dado un archivo con datos de sistemas operativos con el formato
//siguiente (el profesor entregará el archivo completo).
//Realizar aplicación que realice los siguientes procesos:
//P1) Cargar Archivo JsonArray a Memoria
//P2) Recorrer el Array de Objetos con FOR
//P3) Recorrer el Array de Objetos con FOREACH
//P4) Recorrer el Array de Objetos con ITERATOR
//P5) Muestra directamente el valor de "Nombre" del registro 3
public class UD2EjerJson1402 {

    public static void main(String[] args) throws IOException {
        // Crear String con el contenido del Json 
        String fichero = "./datos/sistoperativos.json";

        // Obtener un JsonObject a partir del String
        JsonArray sistemaOperativo = JsonUtils.getArrayFromFile(fichero);

        // ***********************************
        // Recorrer el Array de Objetos con FOR
        // ***********************************
        System.out.println("Recorrer el Array de Objetos con FOR");
        System.out.println("------------------------------------------------");
        for (JsonValue elemento : sistemaOperativo) {
            JsonObject so = elemento.asJsonObject();
            System.out.println(so.toString());
            System.out.printf("Id: %-4d\n", so.getInt("Id"));
            System.out.printf("Nombre: %-10s\n\n", so.getString("Nombre"));
        }
        // ***********************************
        // Recorrer el Array de Objetos con FOREACH
        // ***********************************
        System.out.println("Recorrer el Array de Objetos con FOREACH");
        System.out.println("------------------------------------------------");
        sistemaOperativo.forEach((so) -> {
            System.out.println(so.toString());
            System.out.printf("Id: %-4d\n", so.asJsonObject().getInt("Id"));
            System.out.printf("Nombre: %-10s\n\n", so.asJsonObject().getString("Nombre"));
        });
        // ***********************************
        // Recorrer el Array de Objetos con ITERATOR
        // ***********************************
        System.out.println("Recorrer el Array de Objetos con ITERATOR");
        System.out.println("------------------------------------------------");
        Iterator<JsonValue> so = sistemaOperativo.iterator();
        while (so.hasNext()) {
            JsonObject soObject = so.next().asJsonObject();
            System.out.println(soObject.toString());
            System.out.printf("Id: %-4d\n", soObject.getInt("Id"));
            System.out.printf("Nombre: %-10s\n\n", soObject.getString("Nombre"));
        }
    }
}

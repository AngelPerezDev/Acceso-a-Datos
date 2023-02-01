package ud2ejerjson1403;

//UD2EjerJson1403
import java.io.IOException;
import javax.json.JsonObject;
import utils.JsonUtils;

//A través de la URL "https://jsonplaceholder.typicode.com/posts/42"
//obtenemos los datos del mensaje 42 del usuario 5 que contiene un título
//(title) y el propio mensaje (body). 
//Realizar aplicación que realice los siguientes procesos:
//P1) Cargar el contenido en un JsonObject a Memoria
//P2) Recorrer el Array de Objetos con FOREACH y mostrar la clave, tipo y
//valor de cada par de valores.
public class UD2EjerJson1403 {

    public static void main(String[] args) throws IOException {
        // Crear String con la url 
        String url = "https://jsonplaceholder.typicode.com/posts/42";

        // Obtener un JsonObject a partir del String
        JsonObject mensaje42 = JsonUtils.getObjectFromURL(url);

        // Recorrer el JsonObject    
        System.out.println("Recorrer el Objeto con FOREACH");
        System.out.println("------------------------------------------------");
        mensaje42.forEach((key, value) -> {
            System.out.println("Clave: " + key);
            System.out.println("Tipo: " + value.getValueType());
            System.out.println("Valor: " + value);
            System.out.println();
        });
    }
}

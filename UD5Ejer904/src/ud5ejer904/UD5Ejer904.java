package ud5ejer904;

import clases.Photo;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Scanner;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class UD5Ejer904 {

    public static void ResultadoUno(Response response) {
        // Mostrar la respuesta para opción 1  
        String body = response.readEntity(String.class);
        JsonReader jsonReader;
        jsonReader = Json.createReader(new StringReader(body));
        JsonObject json = jsonReader.readObject();

        System.out.println("Status: " + response.getStatus());
        System.out.println("Response: " + body);
        System.out.println("El json: " + json.toString());

        System.out.println("+--------+----+----------------------------------------------------------------------------+-----------+");
        System.out.println("| userID | ID | title                                                                      | completed |");
        System.out.println("+--------+----+----------------------------------------------------------------------------+-----------+");
        System.out.printf("| %6d | %2d | %-74s | %9s |\n",
                json.getInt("userId"),
                json.getInt("id"),
                json.getString("title"),
                json.getBoolean("completed"));
        System.out.println("+--------+----+----------------------------------------------------------------------------+-----------+");
        jsonReader.close();
    }

    public static void ResultadoDos(Response response) {
        // Mostrar la respuesta para opción 2 
        ArrayList<Photo> body = response.readEntity(new GenericType<ArrayList<Photo>>() {
        });
        System.out.println("Status: " + response.getStatus());

        System.out.println("+-------+------------------------------------------------------------------------+------------------------------------------+");
        System.out.println("| ID    | title                                                                  | url                                      |");
        System.out.println("+-------+------------------------------------------------------------------------+------------------------------------------+");
        for (Photo foto : body) {
            System.out.printf("| %5d | %-70s | %-40s |\n",
                    foto.getId(),
                    foto.getTitle(),
                    foto.getUrl());
        }
        System.out.println("+-------+------------------------------------------------------------------------+------------------------------------------+");
    }

    public static Response Peticion(String path) {
        // Objetos para realizar la petición
        Client client = ClientBuilder.newClient();
        Response response = client
                .target("https://jsonplaceholder.typicode.com")
                .path(path)
                .request()
                .header("Content-Type", "application/json")
                .accept(MediaType.APPLICATION_JSON)
                .get();
        return response;
    }

    public static String Menu() {
        // Mostrar menu
        int opcion;
        String path = null;
        do {
            System.out.println("----------------------------------------");
            System.out.println("1. Obtener Registro de TODOS");
            System.out.println("2. Obtener listado de PHOTOS");
            System.out.println("--------------------");
            System.out.println("0. Salir");
            System.out.println("--------------------");
            System.out.print("Escribe una de las opciones: ");
            Scanner read = new Scanner(System.in);
            opcion = read.nextInt();
            System.out.println("----------------------------------------");

            switch (opcion) {
                case 1 -> {
                    System.out.print("Escriba el ID del registro: ");
                    path = "/todos/" + read.next();
                    opcion = 0;
                }
                case 2 -> {
                    System.out.print("Escriba el ID del Album: ");
                    path = "/albums/" + read.next() + "/photos";
                    opcion = 0;
                }
                case 0 -> {
                    System.out.println("Terminado");
                    path = null;
                }
                default ->
                    System.out.println("Opción no aceptada");
            }
        } while (opcion != 0);

        return path;
    }

    public static void main(String[] args) {
        String path;
        do {
            path = Menu();
            if (path != null) {
                Response response = Peticion(path);
                if (path.contains("todos")) {
                    ResultadoUno(response);
                }
                if (path.contains("photos")) {
                    ResultadoDos(response);
                }
            }
        } while (path != null);
    }

}

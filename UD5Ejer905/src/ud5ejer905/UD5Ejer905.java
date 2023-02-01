package ud5ejer905;

import clases.Fiestas;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Scanner;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class UD5Ejer905 {
    
    public static void MostrarResultados(Response response) {
        ArrayList<Fiestas> body = response.readEntity(new GenericType<ArrayList<Fiestas>>() {
        });
        System.out.println("Status: " + response.getStatus());

        System.out.println("+-------+----------------------+------------------------------------------+");
        System.out.println("| ID    | fecha                | texto                                    |");
        System.out.println("+-------+----------------------+------------------------------------------+");
        for (Fiestas f : body) {
            System.out.printf("| %-5d | %-20s | %-40s |\n",
                    f.getId(),
                    f.getFecha(),
                    f.getTexto());
        }
        System.out.println("+-------+----------------------+------------------------------------------+");
    }

    public static Invocation.Builder Peticion(String path, String request, String headerName, String headerValue) {
        Client client = ClientBuilder.newClient();
        WebTarget webTargetBase;
        WebTarget webTargetSolicitud;
        Invocation.Builder invbuilder;

        webTargetBase = client.target("http://localhost/bdapirest");
        webTargetSolicitud = webTargetBase.path(path);
        invbuilder = webTargetSolicitud.request(request);
        invbuilder.header(headerName, headerValue);
        invbuilder.accept(MediaType.APPLICATION_JSON);

        return invbuilder;
    }

    public static void Menu() {
        // Mostrar menu
        int opcion;
        String path;
        do {
            System.out.println("----------------------------------------");
            System.out.println("1.- Obtener los datos de todos los registros");
            System.out.println("2.- Obtener los datos de un registro concreto");
            System.out.println("3.- Insertar un nuevo registro");
            System.out.println("4.- Actualizar un nuevo registro");
            System.out.println("5.- Eliminar un nuevo registro");
            System.out.println("--------------------");
            System.out.println("0. Salir");
            System.out.println("--------------------");
            System.out.print("Escribe una de las opciones: ");
            Scanner read = new Scanner(System.in);
            opcion = read.nextInt();
            System.out.println("----------------------------------------");

            switch (opcion) {
                case 1 -> {
                    Invocation.Builder invbuilder = Peticion("/fiestas", null, null, null);
                    Response response = invbuilder.get();
                    MostrarResultados(response);
                }
                case 2 -> {
                    System.out.print("Escriba el nº de registro: ");
                    Invocation.Builder invbuilder = Peticion("/fiestas/" + read.next(), null, null, null);
                    Response response = invbuilder.get();
                    MostrarResultados(response);
                }
                case 3 -> {
                    Invocation.Builder invbuilder = Peticion("/fiestas", null, null, null);
                    Response response = invbuilder.get();
                    ArrayList<Fiestas> body = response.readEntity(new GenericType<ArrayList<Fiestas>>() {
                    });
                    int ultimoId = body.get(body.size() - 1).getId();

                    System.out.print("Indique fecha de nuevo registro (formato yyyy-mm-dd): ");
                    String fecha = read.next();
                    System.out.print("Indique texto de nuevo registro: ");
                    String texto = read.next();
                    invbuilder.post(Entity.json(new Fiestas(ultimoId + 1, fecha, texto)));
                }
                case 4 -> {
                    System.out.print("Indique nº de registro a actualizar: ");
                    int numero = read.nextInt();

                    Invocation.Builder invbuilder = Peticion("/fiestas/" + numero, null, null, null);
                    Response responseMuestraDatos = invbuilder.get();
                    System.out.print("Mostrando datos de registro a modificar: ");
                    MostrarResultados(responseMuestraDatos);

                    System.out.print("Indique nueva fecha: ");
                    String fecha = read.next();
                    System.out.print("Indique nuevo texto: ");
                    String texto = read.next();
                    System.out.print("¿CONFIRMAR MODIFICACIÓN? (Y/N): ");
                    if ("Y".equals(read.next())) {
                        invbuilder.put(Entity.json(new Fiestas(numero, fecha, texto)));
                    }
                }
                case 5 -> {
                    System.out.print("Indique nº de registro a eliminar: ");
                    int numero = read.nextInt();

                    Invocation.Builder invbuilder = Peticion("/fiestas/" + numero, null, null, null);
                    Response responseMuestraDatos = invbuilder.get();
                    System.out.print("Mostrando datos de registro a eliminar: ");

                    MostrarResultados(responseMuestraDatos);
                    System.out.print("¿CONFIRMAR ELIMINACIÓN? (Y/N): ");
                    if ("Y".equals(read.next())) {
                        invbuilder.delete();
                    }
                }
                case 0 -> {
                    System.out.println("Saliendo...");
                }
                default ->
                    System.out.println("Opción no aceptada");
            }
        } while (opcion != 0);
    }

    public static void main(String[] args) {
        Menu();
    }

}

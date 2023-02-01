package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Collections;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonWriter;
import javax.json.JsonWriterFactory;
import javax.json.stream.JsonGenerator;

public class JsonUtils {

    // *******************
    // LEER OBJETOS JSON
    // *******************
    public static JsonObject getObjectFromString(String jsonObjectStr) {

        JsonReader jsonReader = Json.createReader(new StringReader(jsonObjectStr));
        JsonObject object = jsonReader.readObject();
        jsonReader.close();

        return object;
    }

    public static JsonObject getObjectFromFile(String strFile)
            throws FileNotFoundException, IOException {
        File fichero = new File(strFile);  // Declarar fichero

        JsonObject jsonObj;
        try (
                Reader objReader = new FileReader(fichero); //Crear el flujo de entrada  
                JsonReader jsonReader = Json.createReader(objReader);) {
            // Leemos el fichero completo en formato Object
            jsonObj = jsonReader.readObject();
        }

        return jsonObj;
    }

    public static JsonObject getObjectFromURL(String strConnection)
            throws MalformedURLException, IOException {

        // Conexión sin proxy
        URL url = new URL(strConnection);
        URLConnection uc = url.openConnection();
        HttpURLConnection conn = (HttpURLConnection) uc;

        // La conexión se va a realizar para poder enviar y recibir 
        // información en formato JSON 
        conn.setDoInput(true);
        conn.setDoOutput(true);
        conn.setRequestProperty("Content-type", "application/json");

        // Se va a realizar una petición con el método GET
        conn.setRequestMethod("GET");

        // Ejecutar la conexión y obtener la respuesta
        
        JsonObject jsonObj;
        try (
                Reader objReader = new InputStreamReader(conn.getInputStream());
                JsonReader jsonReader = Json.createReader(objReader);) {
            // Leemos el fichero completo en formato Object
            jsonObj = jsonReader.readObject();
        }

        return jsonObj;
    }

    // *******************
    // LEER ARRAYS JSON
    // *******************
    public static JsonArray getArrayFromString(String jsonArrayStr) {

        JsonReader jsonReader = Json.createReader(new StringReader(jsonArrayStr));
        JsonArray array = jsonReader.readArray();
        jsonReader.close();

        return array;
    }

    public static JsonArray getArrayFromFile(String strFile)
            throws FileNotFoundException, IOException {
        File fichero = new File(strFile);  // Declarar fichero
        

        JsonArray array;
        try (
                Reader objReader = new FileReader(fichero); //Crear el flujo de entrada  
                JsonReader jsonReader = Json.createReader(objReader);) {
            // Leemos el fichero completo en formato Object
            array = jsonReader.readArray();
        }

        return array;
    }

    public static JsonArray getArrayFromURL(String strConnection)
            throws MalformedURLException, IOException {

        // Conexión sin proxy
        URL url = new URL(strConnection);
        URLConnection uc = url.openConnection();
        HttpURLConnection conn = (HttpURLConnection) uc;

        // La conexión se va a realizar para poder enviar y recibir 
        // información en formato JSON 
        conn.setDoInput(true);
        conn.setDoOutput(true);
        conn.setRequestProperty("Content-type", "application/json");

        // Se va a realizar una petición con el método GET
        conn.setRequestMethod("GET");

        // Ejecutar la conexión y obtener la respuesta
        JsonArray array;
        try (
                Reader objReader = new InputStreamReader(conn.getInputStream());
                JsonReader jsonReader = Json.createReader(objReader);) {
            // Leemos el fichero completo en formato Object
            array = jsonReader.readArray();
        }

        return array;
    }

    // *******************
    // ESCRIBIR OBJETOS JSON
    // *******************
    public static void setObjectToFile(String fichero, JsonObject obj) throws FileNotFoundException {
        // ******************************************
        // Escribir el archivo JSON
        // ******************************************
        JsonWriterFactory jsonFactory = Json.createWriterFactory(
                Collections.singletonMap(JsonGenerator.PRETTY_PRINTING, true)
        );
        JsonWriter jsonW
                = jsonFactory.createWriter(
                        new FileOutputStream(fichero)
                );
        jsonW.writeObject(obj);
        jsonW.close();
    }

    public static void setArrayToFile(String fichero, JsonArray arrayJ) throws FileNotFoundException {
        // ******************************************
        // Escribir el archivo JSON
        // ******************************************
        JsonWriterFactory jsonFactory = Json.createWriterFactory(
                Collections.singletonMap(JsonGenerator.PRETTY_PRINTING, true)
        );
        JsonWriter jsonW
                = jsonFactory.createWriter(
                        new FileOutputStream(fichero)
                );
        jsonW.writeArray(arrayJ);
        jsonW.close();
    }

}

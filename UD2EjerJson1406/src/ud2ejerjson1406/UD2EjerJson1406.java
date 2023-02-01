package ud2ejerjson1406;

import clases.Domicilio;
import clases.Persona;
import com.csvreader.CsvReader;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class UD2EjerJson1406 {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        ArrayList<Persona> personas = new ArrayList();

        CsvReader censo = new CsvReader("./datos/censo.csv", '|', StandardCharsets.UTF_8);
        censo.setDelimiter('|');
        censo.setRecordDelimiter('\n');

        censo.readHeaders();

        while (censo.readRecord()) {
            String dni = censo.get("dni");
            String nombre = censo.get("nombre");
            String calle = censo.get("calle");
            int numero = Integer.parseInt(censo.get("numero"));
            int cpostal = Integer.parseInt(censo.get("cpostal"));
            String poblacion = censo.get("poblacion");
            Domicilio d = new Domicilio(calle, numero, cpostal, poblacion);
            Persona p = new Persona(dni, nombre, d);
            personas.add(p);
        }

        censo.close();

        personas.forEach((persona) -> System.out.println(persona));

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        
        Writer w = new FileWriter("datos/personas.json");
        
        gson.toJson(personas, w);
        
        w.close();
    }
}

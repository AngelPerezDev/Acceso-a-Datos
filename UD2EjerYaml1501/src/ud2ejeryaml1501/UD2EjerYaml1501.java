package ud2ejeryaml1501;

import clases.Domicilio;
import clases.Persona;
import com.csvreader.CsvReader;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class UD2EjerYaml1501 {

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

        ObjectMapper om = new ObjectMapper(new YAMLFactory());
        File archivo = new File("datos/personas.yaml");
        om.writeValue(archivo, personas);
    }
}

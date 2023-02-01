package app;

import clases.Profesor;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;

public class UD7Ejer201 {

    public static void main(String[] args) {
        // Desactivar logs de MongoDB.
        Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.SEVERE);

        System.out.println("Conectando a MongoDB.");

        // Conexión a MongoDB.
        MongoClientURI uri = new MongoClientURI("mongodb://localhost:27017");
        try ( MongoClient mongoClient = new MongoClient(uri)) {
            // Obtener la base de datos con la que trabajar.
            MongoDatabase db = mongoClient.getDatabase("instituto");
            MongoCollection<Document> collection = db.getCollection("profesores");

            /*
            * Elimina el contenido de la colección, en este caso,
            * para no tener documentos duplicados.
             */
            collection.drop();

            // Insertar los documentos
            System.out.println("Insertando documentos...");

            // Creamos una lista de documentos
            ArrayList<Document> docs = new ArrayList<>();

            docs.add(new Profesor("Pedro", "Álvarez", "mañana").toDoc());
            docs.add(new Profesor("Manuel", "Sánchez", "tarde").toDoc());
            docs.add(new Profesor("Laura", "González", "tarde").toDoc());
            docs.add(new Profesor("Francisco", "Pérez", "mañana").toDoc());
            docs.add(new Profesor("Noelia", "Giménez", "mañana/tarde").toDoc());
            docs.add(new Profesor("Miguel", "Soler", "mañana").toDoc());
            docs.add(new Profesor("Carmen", "Ordóñez", "tarde").toDoc());

            collection.insertMany(docs);

            // Mostramos los datos con for
            System.out.println("Mostrar los datos obtenidos (BSON).");
            for (Document cursor : collection.find(Document.parse("{}")).projection(Document.parse("{_id:0}"))) {
                System.out.println(cursor.toJson());
            }

        } catch (MongoException ex) {
            System.out.println("Error de conexión a MongoBD: " + ex.getMessage());
        }

    }
}

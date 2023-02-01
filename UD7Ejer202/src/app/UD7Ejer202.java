package app;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;

public class UD7Ejer202 {

    public static void main(String[] args) {
        // Desactivar logs de MongoDB.
        Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.SEVERE);

        // Conexión a MongoDB.
        MongoClientURI uri = new MongoClientURI("mongodb://localhost:27017");
        try (MongoClient mongoClient = new MongoClient(uri)) {
            // Obtener la base de datos con la que trabajar.
            MongoDatabase db = mongoClient.getDatabase("instituto");
            MongoCollection<Document> collection = db.getCollection("profesores");

            // Actualizando los documentos
            System.out.println("Actualizando documentos...");

            collection.updateMany(
                    Filters.or(
                            Filters.eq("nombre", "Manuel"),
                            Filters.eq("nombre", "Laura")),
                    Document.parse("{'$set': {'turno':'mañana/tarde'}}")
            );

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

package utils;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.gte;
import static com.mongodb.client.model.Filters.lte;
import com.mongodb.client.model.Sorts;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;

public class MongoController {

    private static MongoClient mongoClient;
    private static MongoDatabase database;
    private static MongoCollection<Document> collection;

    public static void Conectar() {

        Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.SEVERE);

        MongoClientURI uri = new MongoClientURI("mongodb://localhost:27017");
        mongoClient = new MongoClient(uri);
        database = mongoClient.getDatabase("instituto");
        collection = database.getCollection("asignaturas");

    }

    public static void Desconectar() {

        System.out.println("----------------------------------------\n"
                + "Terminado\n"
                + "----------------------------------------\n"
                + "Desconectando de MongoDB.");
        mongoClient.close();
    }

    public static void MostrarAsignaturas() {

        MongoCursor<Document> cursor = collection.find().iterator();

        System.out.println("Mostrar ASIGNATURAS");
        System.out.println("====================================");
        System.out.println("+----------------------------------------------------+");
        System.out.println("| Asignatura                                         |");
        System.out.println("+----------------------------------------------------+");

        while (cursor.hasNext()) {
            Document dbObj = cursor.next();
            if (dbObj.containsKey("asignatura")) {
                String asignatura = (String) dbObj.get("asignatura");
                System.out.printf("| %-50s |\n", asignatura);
            }
        }

        System.out.println("+----------------------------------------------------+");

    }

    public static void MostrarCargaHoraria() {

        MongoCursor<Document> cursor = collection.find().sort(Sorts.descending("horas")).iterator();

        System.out.println("Mostrar CARGA HORARIA");
        System.out.println("====================================");
        System.out.println("+----------------------------------------------------+-------+");
        System.out.println("| Asignatura                                         | horas |");
        System.out.println("+----------------------------------------------------+-------+");

        while (cursor.hasNext()) {
            Document dbObj = cursor.next();
            if (dbObj.containsKey("asignatura")) {
                String asignatura = (String) dbObj.get("asignatura");
                Integer horas = (Integer) dbObj.get("horas");
                System.out.printf("| %-50s | %5s |\n", asignatura, horas);
            }
        }

        System.out.println("+----------------------------------------------------+-------+");
    }

    public static void MostrarDuracionMediaModulos() {

        MongoCursor<Document> cursor = (MongoCursor<Document>) collection.find(and(
                                        gte("horas", 60),
                                        lte("horas", 100))).sort(Sorts.ascending("horas")).iterator();

        System.out.println("Mostrar MÓDULOS DE DURACIÓN MEDIA");
        System.out.println("====================================");
        System.out.println("+----------------------------------------------------+-------+");
        System.out.println("| Asignatura                                         | horas |");
        System.out.println("+----------------------------------------------------+-------+");

        while (cursor.hasNext()) {
            Document dbObj = cursor.next();
            if (dbObj.containsKey("asignatura")) {
                String asignatura = (String) dbObj.get("asignatura");
                Integer horas = (Integer) dbObj.get("horas");
                System.out.printf("| %-50s | %5s |\n", asignatura, horas);
            }
        }

        System.out.println("+----------------------------------------------------+-------+");
    }

}

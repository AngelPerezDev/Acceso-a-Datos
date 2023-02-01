package app;

import clases.Vehiculos;
import clases.Personas;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.ClassModel;
import org.bson.codecs.pojo.PojoCodecProvider;

public class Mongo16POJOPerDoc {

    public static void main(String[] args) {
        // Desactivar logs de MongoDB.
        Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.SEVERE);

        // Conexión a MongoDB.
        MongoClientURI uri = new MongoClientURI("mongodb://localhost:27017");
        try ( MongoClient mongoClient = new MongoClient(uri)) {

            // Mapeo de Clases con Colecciones
            ClassModel<Personas> personasModel = ClassModel.builder(Personas.class).enableDiscriminator(true).build();
            ClassModel<Vehiculos> vehiculosModel = ClassModel.builder(Vehiculos.class).enableDiscriminator(true).build();
            PojoCodecProvider pojoCodecProvider = PojoCodecProvider.builder().register(personasModel, vehiculosModel).build();
            CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));

            // Conexión a MongoDB utilizando el ClassModel y PojoCodecProvider
            MongoDatabase database = mongoClient.getDatabase("relaciones").withCodecRegistry(codecRegistry);
            MongoCollection<Personas> collectionPersonas = database.getCollection("personasVehiculos", Personas.class);

            // Obtención de datos mapeados
            ArrayList<Personas> listaPersonas = new ArrayList<>();
            collectionPersonas.find().into(listaPersonas);

            // Mostrar datos mapeados
            for (Personas per : listaPersonas) {

                System.out.println("============================================================================");
                System.out.println("Nombre...: " + per.getNombre());
                System.out.println("Apellidos: " + per.getApellidos());
                System.out.println("Teléfono.: " + per.getTelefono());
                System.out.println("+------------+----------------------+-----------+-----------+--------------+");
                System.out.println("| MATRICULA  | BASTIDOR             | MARCA     | MODELO    | PUERTAS      |");
                System.out.println("+------------+----------------------+-----------+-----------+--------------+");

                for (Vehiculos veh : per.getVehiculos()) {
                    System.out.printf("| %-10s | %-20s | %-9s | %-9s | %12d |\n",
                            veh.getMatricula(), veh.getBastidor(), veh.getMarca(), veh.getModelo(), veh.getPuertas());
                }
                System.out.println("+------------+----------------------+-----------+-----------+--------------+\n");
            }

        } catch (MongoException ex) {
            System.out.println("Error de conexión a MongoBD: " + ex.getMessage());
        }

    }
}

package ud7ejer203;

import java.util.Scanner;
import utils.MongoController;

public class UD7Ejer203 {

    public static void main(String[] args) {

        MongoController.Conectar();
        int opcion;
        do {
            Scanner sn = new Scanner(System.in);
            System.out.print("---------------------------------------\n"
                    + "1. Mostrar asignaturas (nombre)\n"
                    + "2. Mostrar carga horaria\n"
                    + "3. Mostrar asignaturas duración intermedia\n"
                    + "--------------------\n"
                    + "0. Salir\n"
                    + "--------------------\n"
                    + "Escribe una de las opciones: ");
            opcion = sn.nextInt();
            System.out.println("----------------------------------------");

            switch (opcion) {
                case 1:
                    MongoController.MostrarAsignaturas();
                    break;
                case 2:
                    MongoController.MostrarCargaHoraria();
                    break;
                case 3:
                    MongoController.MostrarDuracionMediaModulos();
                    break;
            }
        } while (opcion != 0);
        MongoController.Desconectar();
    }
}


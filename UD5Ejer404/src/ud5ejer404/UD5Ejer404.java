package ud5ejer404;

import com.dam.persona.ListaPersonas;

public class UD5Ejer404 {

    public static void main(String[] args) {
        ListaPersonas lista = new ListaPersonas();
        lista.cargaSql();
        for (int i = 0; i < lista.getLista().size(); i++) {
            System.out.println(lista.getLista().get(i).toString());
        }
    }

}

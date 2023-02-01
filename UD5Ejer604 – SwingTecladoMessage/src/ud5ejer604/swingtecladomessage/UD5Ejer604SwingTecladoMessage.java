package ud5ejer604.swingtecladomessage;

import javax.swing.JOptionPane;

public class UD5Ejer604SwingTecladoMessage {

    public static void main(String[] args) {
        String nombre = JOptionPane.showInputDialog("Introduce tu nombre");
        JOptionPane.showMessageDialog(null, "Cuidado " + nombre,
                "AVISO", JOptionPane.WARNING_MESSAGE);
        System.out.println(nombre);
    }

}

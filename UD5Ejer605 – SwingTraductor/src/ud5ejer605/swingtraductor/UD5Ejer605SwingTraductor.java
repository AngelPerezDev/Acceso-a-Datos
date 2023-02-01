package ud5ejer605.swingtraductor;

import javax.swing.JFrame;

public class UD5Ejer605SwingTraductor {

    private static JFrame ventana;

    public static void main(String[] args) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ventana = new WinJFrame();
                ventana.setLocationRelativeTo(null); // Para centrarla
                ventana.setTitle("TRADUCTOR DE ESPAÑOL A INGLÉS");
                ventana.setVisible(true);
            }
        });
    }

}

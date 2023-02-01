package ud5ejer601.swingsuma;

import javax.swing.JFrame;


public class UD5Ejer601SwingSuma {

    private static JFrame ventana;

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ventana = new WinFrame();
                ventana.setLocationRelativeTo(null); // Para centrarla
                ventana.setTitle("Suma de dos números");
                ventana.setVisible(true);
            }
        });
    }

}

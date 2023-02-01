package clases;

public class Fiestas {
    
    private int id;
    private String fecha;
    private String texto;

    public Fiestas() {
    }

    public Fiestas(int id, String fecha, String texto) {
        this.id = id;
        this.fecha = fecha;
        this.texto = texto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    @Override
    public String toString() {
        return "Fiestas{" + "id=" + id + ", fecha=" + fecha + ", texto=" + texto + '}';
    }
    
    
}

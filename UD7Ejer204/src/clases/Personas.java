package clases;

import java.io.Serializable;
import java.util.ArrayList;

public class Personas implements Serializable {
    String nombre;
    String apellidos;
    Long telefono;
    ArrayList<Vehiculos> vehiculos;

    public Personas() {
    }

    public Personas(String nombre, String apellidos, Long telefono, ArrayList<Vehiculos> vehiculos) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.vehiculos = vehiculos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    public ArrayList<Vehiculos> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(ArrayList<Vehiculos> vehiculos) {
        this.vehiculos = vehiculos;
    }

    @Override
    public String toString() {
        return "Personas{" + "nombre=" + nombre + ", apellidos=" + apellidos + ", telefono=" + telefono + ", vehiculos=" + vehiculos + '}';
    }

    
  


    
    
}

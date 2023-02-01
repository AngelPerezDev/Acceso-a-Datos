
package clases;

import java.io.Serializable;


public class Vehiculos implements Serializable {
    String matricula;
    String bastidor;
    String marca;
    String modelo;
    Integer puertas;

    public Vehiculos() {
    }

    public Vehiculos(String matricula, String bastidor, String marca, String modelo, Integer puertas) {
        this.matricula = matricula;
        this.bastidor = bastidor;
        this.marca = marca;
        this.modelo = modelo;
        this.puertas = puertas;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getBastidor() {
        return bastidor;
    }

    public void setBastidor(String bastidor) {
        this.bastidor = bastidor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getPuertas() {
        return puertas;
    }

    public void setPuertas(Integer puertas) {
        this.puertas = puertas;
    }

    @Override
    public String toString() {
        return "Vehiculos{" + "matricula=" + matricula + ", bastidor=" + bastidor + ", marca=" + marca + ", modelo=" + modelo + ", puertas=" + puertas + '}';
    }
    
    

    
    
    
}

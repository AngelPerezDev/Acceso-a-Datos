package com.dam.persona;

import java.io.Serializable;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class ListaPersonas implements Serializable {

    ArrayList<Persona> lista = new ArrayList<Persona>();

    public ListaPersonas() {
    }

    public ArrayList<Persona> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Persona> lista) {
        this.lista = lista;
    }

    public void cargaSql() {
        try {
            lista.clear();
// Cargar el driver de mysql
            Class.forName("com.mysql.cj.jdbc.Driver");
// Cadena de conexión a MySQL
            String conURL = "jdbc:mysql://localhost:3306/bdpersonas";
            conURL += "?user=root&password=1234";
            conURL += "&useSSL=false&autoReconnect=true&serverTimezone=UTC";
// Obtener la conexión
            Connection con = (Connection) DriverManager.getConnection(conURL);
            Statement stmt = (Statement) con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * "
                    + "FROM personas, domicilios "
                    + "WHERE personas.dni=domicilios.idpersona");
            while (rs.next()) {
                Domicilio dom = new Domicilio(rs.getString("direccion"),
                        rs.getString("cpostal"), rs.getString("poblacion"),
                        rs.getString("provincia"));
                lista.add(new Persona(rs.getInt("dni"),
                        rs.getString("nombre"), rs.getString("apellidos"),
                        rs.getString("telefono"), dom));
            }
// Cerrar la conexión
            con.close();
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.toString());
        } catch (ClassNotFoundException cE) {
            System.out.println("Exception: " + cE.toString());
        }
    }

    @Override
    public String toString() {
        return "ListaPersonas{" + "lista=" + lista + '}';
    }

}

package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.LibroModelo;

public class LibroControlador {

    private LibroModelo libro;
    ConexionBDD conectar = new ConexionBDD();
    Connection conectado = (Connection) conectar.conectar();
    PreparedStatement ejecutar;
    ResultSet res;

    public void insertarLibro(LibroModelo libro) {
        try {
            String sentenciaSQL = "call sp_InsertarLibro('" + libro.getIdLibro() + "', '" + libro.getIdAutor() + "');";
            ejecutar = conectado.prepareCall(sentenciaSQL);
            int resu = ejecutar.executeUpdate();
            if (resu > 0) {
                JOptionPane.showMessageDialog(null,"Libro Creado con éxito");
                ejecutar.close();
            } else {
                JOptionPane.showMessageDialog(null,"El Libro no ha sido creado, revise que los datos ingresados sean correctos");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Comuniquese con el Administrador para solicitar ayuda");
        }
    }

    public ArrayList<Object[]> buscarLibro(String idLibro) {
        ArrayList<Object[]> listaLibros = new ArrayList<>();
        try {
            String sql = "call sp_BuscarLibro('%" + idLibro + "%');";
            ejecutar = (PreparedStatement) conectado.prepareCall(sql);
            res = ejecutar.executeQuery();
            int cont = 1;
            while (res.next()) {
                Object[] obLibro = new Object[3];
                obLibro[0] = cont;
                obLibro[1] = res.getObject("idLibro");
                obLibro[2] = res.getObject("idAutor");
                listaLibros.add(obLibro);
                cont++;
            }
            ejecutar.close();
            return listaLibros;
        } catch (SQLException e) {
            System.out.println("ERROR SQL" + e);
        }
        return null;
    }

    public void actualizarLibro(LibroModelo libro) {
        try {
            String sentenciaSQL = "call sp_ActualizarLibro('" + libro.getIdLibro() + "', '" + libro.getIdAutor() + "');";
            ejecutar = (PreparedStatement) conectado.prepareCall(sentenciaSQL);
            int resultado = ejecutar.executeUpdate();
            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Libro Actualizado con Éxito");
                ejecutar.close();
            } else {
                JOptionPane.showMessageDialog(null, "Revise los datos ingresados");
            }
        } catch (SQLException e) {
            System.out.println("ERROR SQL");
        }
    }

    public void eliminarLibro(String idLibro) {
        try {
            String sql = "call sp_EliminarLibro('" + idLibro + "');";
            ejecutar = (PreparedStatement) conectado.prepareCall(sql);
            int resultado = ejecutar.executeUpdate();
            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Libro Eliminado con éxito");
                ejecutar.close();
            } else {
                JOptionPane.showMessageDialog(null, "Revise los datos ingresados");
            }
        } catch (SQLException e) {
            System.out.println("ERROR SQL" + e);
        }
    }
}

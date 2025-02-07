package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.AutorModelo;

public class AutorControlador {

    private AutorModelo a;
    ConexionBDD conectar = new ConexionBDD();
    Connection conectado = (Connection) conectar.conectar();
    PreparedStatement ejecutar;
    ResultSet resultado;

    public void insertarAutor(AutorModelo a) {
        try {
            String sentenciaSQL = "CALL sp_insertar_Autores(?, ?)";
            ejecutar = conectado.prepareCall(sentenciaSQL);
            ejecutar.setInt(1, a.getIdAutor());
            ejecutar.setString(2, a.getCedula());
            
            int res = ejecutar.executeUpdate();
            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Autor creado con éxito");
            } else {
                JOptionPane.showMessageDialog(null, "El Autor no ha sido creado, revise los datos ingresados");
            }
            ejecutar.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar el Autor. Contacte al administrador.");
            e.printStackTrace();
        }
    }

    public boolean actualizarAutor(AutorModelo a) {
        boolean exito = false;
        try {
            String sentenciaSQL = "UPDATE autores SET cedula = ? WHERE idAutor = ?";
            ejecutar = conectado.prepareStatement(sentenciaSQL);
            ejecutar.setString(1, a.getCedula());
            ejecutar.setInt(2, a.getIdAutor());
            
            int res = ejecutar.executeUpdate();
            if (res > 0) {
                exito = true;
                JOptionPane.showMessageDialog(null, "La información del autor se ha actualizado correctamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el autor con ese ID o la actualización falló.");
            }
            ejecutar.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar la información del autor. Contacte al administrador.");
            e.printStackTrace();
        }
        return exito;
    }

    public ArrayList<Object[]> buscarAutor(String cedula) {
        ArrayList<Object[]> listaAutores = new ArrayList<>();
        try {
            String sentenciaSQL = "SELECT * FROM autores WHERE cedula = ?";
            ejecutar = conectado.prepareStatement(sentenciaSQL);
            ejecutar.setString(1, cedula);
            resultado = ejecutar.executeQuery();

            while (resultado.next()) {
                Object[] fila = new Object[2];
                fila[0] = resultado.getInt("idAutor");
                fila[1] = resultado.getString("cedula");
                listaAutores.add(fila);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al buscar el autor.");
            e.printStackTrace();
        } finally {
            try {
                if (resultado != null) resultado.close();
                if (ejecutar != null) ejecutar.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return listaAutores;
    }

    public void eliminarAutor(int idAutor) {
        try {
            String sentenciaSQL = "DELETE FROM autores WHERE idAutor = ?";
            ejecutar = conectado.prepareStatement(sentenciaSQL);
            ejecutar.setInt(1, idAutor);
            
            int res = ejecutar.executeUpdate();
            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Autor eliminado con éxito.");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el autor con ese ID.");
            }
            ejecutar.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el autor. Contacte al administrador.");
            e.printStackTrace();
        }
    }
}

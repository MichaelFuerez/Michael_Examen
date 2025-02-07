package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.AutorModelo;

public class AutorControlador {

    private AutorModelo autor;
    private ConexionBDD conectar = new ConexionBDD();
    private Connection conectado = conectar.conectar();
    private PreparedStatement ejecutar;
    private ResultSet resultado;

    // Método para insertar un autor
    public void insertarAutor(AutorModelo autor) {
        try {
            String sentenciaSQL = "CALL sp_insertar_Autores(?, ?, ?)";  // Se agrega el campo nombreAutores
            ejecutar = conectado.prepareCall(sentenciaSQL);
            ejecutar.setInt(1, autor.getIdAutor());
            ejecutar.setString(2, autor.getCedula());
            ejecutar.setString(3, autor.getNombreAutores());  // Añadido el parámetro para el nombre del autor
            
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

    // Método para actualizar la información de un autor
    public boolean actualizarAutor(AutorModelo autor) {
        boolean exito = false;
        try {
            String sentenciaSQL = "UPDATE autores SET cedula = ?, nombreAutores = ? WHERE idAutor = ?"; // Se actualiza también el nombre del autor
            ejecutar = conectado.prepareStatement(sentenciaSQL);
            ejecutar.setString(1, autor.getCedula());
            ejecutar.setString(2, autor.getNombreAutores());  // Se agrega la actualización del nombre del autor
            ejecutar.setInt(3, autor.getIdAutor());
            
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

    // Método para buscar autores por cédula
    public ArrayList<Object[]> buscarAutor(String cedula) {
        ArrayList<Object[]> listaAutores = new ArrayList<>();
        try {
            String sentenciaSQL = "SELECT * FROM autores WHERE cedula = ?";
            ejecutar = conectado.prepareStatement(sentenciaSQL);
            ejecutar.setString(1, cedula);
            resultado = ejecutar.executeQuery();

            while (resultado.next()) {
                Object[] fila = new Object[3];  // Se actualiza para manejar los tres campos
                fila[0] = resultado.getInt("idAutor");
                fila[1] = resultado.getString("cedula");
                fila[2] = resultado.getString("nombreAutores");  // Se añade el nombre del autor
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

    // Método para eliminar un autor por su ID
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

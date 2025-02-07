package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.LibroModelo;


public class LibroControlador {

    ConexionBDD conectar = new ConexionBDD();
    Connection conectado = conectar.conectar();
    PreparedStatement ejecutar;
    ResultSet res;

    public void insertarLibro(LibroModelo libro) {
        try {
            String sql = "CALL sp_InsertarLibro(?, ?);";
            ejecutar = conectado.prepareCall(sql);
            ejecutar.setInt(1, libro.getIdLibro());
            ejecutar.setInt(2, libro.getIdAutor());

            int resultado = ejecutar.executeUpdate();
            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Libro creado con éxito.");
            } else {
                JOptionPane.showMessageDialog(null, "Error al crear el libro. Verifique los datos.");
            }
            ejecutar.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error SQL al insertar libro: " + e.getMessage());
        }
    }

    public ArrayList<LibroModelo> buscarLibrosPorCedula(String cedula) {
    ArrayList<LibroModelo> listaLibros = new ArrayList<>();

    try {
        String sql = "CALL sp_BuscarLibrosCedula(?);";  // Procedimiento que trae nombre de autor
        ejecutar = conectado.prepareCall(sql);
        ejecutar.setString(1, cedula);  // Pasamos la cédula como parámetro
        res = ejecutar.executeQuery();

        while (res.next()) {
            LibroModelo libro = new LibroModelo();
            libro.setIdLibro(res.getInt("idLibro"));  // Obtener idLibro
            libro.setIdAutor(res.getInt("idAutor"));  // Obtener idAutor
            libro.setNombreLibros(res.getString("nombreLibros"));  // Obtener nombre del libro
            libro.setNombreAutores(res.getString("nombreAutores"));  // Obtener nombre del autor
            listaLibros.add(libro);  // Añadir el libro a la lista
        }
        ejecutar.close();
    } catch (SQLException e) {
        System.out.println("Error al buscar libros: " + e.getMessage());
    }

    return listaLibros;
}

    public void actualizarLibro(LibroModelo libro) {
        try {
            String sql = "CALL sp_ActualizarLibro(?, ?);";
            ejecutar = conectado.prepareCall(sql);
            ejecutar.setInt(1, libro.getIdLibro());
            ejecutar.setInt(2, libro.getIdAutor());

            int resultado = ejecutar.executeUpdate();
            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Libro actualizado con éxito.");
            } else {
                JOptionPane.showMessageDialog(null, "Error al actualizar el libro.");
            }
            ejecutar.close();
        } catch (SQLException e) {
            System.out.println("Error SQL al actualizar libro: " + e.getMessage());
        }
    }

    public void eliminarLibro(int idLibro) {
        try {
            String sql = "CALL sp_EliminarLibro(?);";
            ejecutar = conectado.prepareCall(sql);
            ejecutar.setInt(1, idLibro);

            int resultado = ejecutar.executeUpdate();
            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Libro eliminado con éxito.");
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar el libro.");
            }
            ejecutar.close();
        } catch (SQLException e) {
            System.out.println("Error SQL al eliminar libro: " + e.getMessage());
        }
    }
}

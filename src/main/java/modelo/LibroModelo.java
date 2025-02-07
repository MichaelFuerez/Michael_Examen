package modelo;

/**
 *
 * @author HP
 */
public class LibroModelo extends AutorModelo {

    private int idLibro;

    // Constructor de la clase LibroModelo
    public LibroModelo(int idLibro, int idAutor, String cedula) {
        super(idAutor, cedula);  // Llama al constructor de AutorModelo
        this.idLibro = idLibro;
    }

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    @Override
    public String toString() {
        return "DATOS LIBRO\n"
                + "idLibro: " + idLibro + "\n"
                + super.toString(); 
    }

    public String getTitulo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getGenero() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

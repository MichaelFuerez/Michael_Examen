package modelo;

public class LibroModelo {

    private int idLibro;
    private int idAutor;
    private String nombreLibros;  // Nuevo campo para el nombre del libro

    // Constructor de la clase LibroModelo
    public LibroModelo(int idLibro, int idAutor, String nombreLibros) {
        this.idLibro = idLibro;
        this.idAutor = idAutor;
        this.nombreLibros = nombreLibros;
    }

    public LibroModelo() {}

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public int getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    }

    public String getNombreLibros() {
        return nombreLibros;
    }

    public void setNombreLibros(String nombreLibros) {
        this.nombreLibros = nombreLibros;
    }

    @Override
    public String toString() {
        return "Libro [idLibro=" + idLibro + ", idAutor=" + idAutor + ", nombreLibro=" + nombreLibros + "]";
    }
}

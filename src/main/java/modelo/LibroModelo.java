package modelo;

public class LibroModelo {

    private int idLibro;
    private int idAutor;

    // Constructor con parámetros
    public LibroModelo(int idLibro, int idAutor) {
        this.idLibro = idLibro;
        this.idAutor = idAutor;
    }

    // Constructor vacío
    public LibroModelo() {
    }

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

    @Override
    public String toString() {
        return "DATOS LIBRO\n"
                + "ID Libro: " + idLibro + "\n"
                + "ID Autor: " + idAutor + "\n";
    }
}

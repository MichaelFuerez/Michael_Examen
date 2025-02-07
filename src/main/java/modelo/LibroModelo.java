package modelo;

public class LibroModelo {

    private int idLibro;
    private int idAutor;
    private String nombreLibros;  // Nuevo campo para el nombre del libro
    private String nombreAutores; // Nuevo campo para el nombre del autor

    // Constructor de la clase LibroModelo
    public LibroModelo(int idLibro, int idAutor, String nombreLibros, String nombreAutores) {
        this.idLibro = idLibro;
        this.idAutor = idAutor;
        this.nombreLibros = nombreLibros;
        this.nombreAutores = nombreAutores;  // Inicializar el nombre del autor
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

    public String getNombreAutores() {
        return nombreAutores;  // Getter para el nombre del autor
    }

    public void setNombreAutores(String nombreAutores) {
        this.nombreAutores = nombreAutores;  // Setter para el nombre del autor
    }

    @Override
    public String toString() {
        return "Libro [idLibro=" + idLibro + ", idAutor=" + idAutor + ", nombreLibro=" + nombreLibros + ", nombreAutor=" + nombreAutores + "]";
    }
}

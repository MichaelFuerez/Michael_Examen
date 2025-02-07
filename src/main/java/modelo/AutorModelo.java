package modelo;

public class AutorModelo {

    private int idAutor;
    private String cedula;
    private String nombreAutores;  // Nuevo campo para el nombre del autor

    public AutorModelo(int idAutor, String cedula, String nombreAutores) {
        this.idAutor = idAutor;
        this.cedula = cedula;
        this.nombreAutores = nombreAutores;
    }

    public AutorModelo() {}

    public int getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombreAutores() {
        return nombreAutores;
    }

    public void setNombreAutores(String nombreAutores) {
        this.nombreAutores = nombreAutores;
    }

    @Override
    public String toString() {
        return "Autor [idAutor=" + idAutor + ", cedula=" + cedula + ", nombreAutor=" + nombreAutores + "]";
    }
}

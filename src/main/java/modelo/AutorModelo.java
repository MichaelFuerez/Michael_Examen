package modelo;

/**
 *
 * @author HP
 */
public class AutorModelo {

    private int idAutor;
    private String cedula;

    // Constructor con parámetros
    public AutorModelo(int idAutor, String cedula) {
        this.idAutor = idAutor;
        this.cedula = cedula;
    }

    // Constructor vacío
    public AutorModelo() {
    }

    // Métodos getter y setter
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

    // Método toString para mostrar los detalles del autor
    @Override
    public String toString() {
        return "DATOS AUTOR\n"
                + "idAutor: " + idAutor + "\n"
                + "Cédula: " + cedula + "\n";
    }
}

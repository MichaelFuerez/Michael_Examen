package modelo;

/**
 *
 * @author HP
 */
public class AutorModelo {

    private int idAutor;
    private String cedula;

    public AutorModelo(int idAutor, String cedula) {
        this.idAutor = idAutor;
        this.cedula = cedula;
    }

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

    @Override
    public String toString() {
        return "DATOS AUTOR\n"
                + "idAutor: " + getIdAutor() + "\n"
                + "Cédula: " + getCedula() + "\n";
    }
}

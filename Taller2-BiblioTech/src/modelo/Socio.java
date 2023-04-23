package modelo;



public class Socio {
    /**
     * nombre del socio
     */
    private String nombre;
    /**
     * apellido del socio
     */
    private String apellido;
    /**
     * correo del socio
     */
    private String correoElectronico;
    /**
     * numero del socio
     */
    private String numeroSocio;
    /**
     * contrasenia del socio
     */
    private String contrasenia;
    /**
     * lista de todos los libros que solicito prestados el socio
     */
    private Libro[] listaPrestamos;

    /**
     * constructor de la clase Socio
     * @param nombre nombre del socio
     * @param apellido apellido del socio
     * @param correoElectronico correo del socio
     * @param numeroSocio numero del socio
     * @param contrasenia contraseña del socio
     */
    public Socio(String nombre, String apellido, String correoElectronico, String numeroSocio, String contrasenia) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correoElectronico = correoElectronico;
        this.numeroSocio = numeroSocio;
        this.contrasenia = contrasenia;
        this.listaPrestamos = new Libro[100];
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getNumeroSocio() {
        return numeroSocio;
    }


    public String getContrasenia() {
        return contrasenia;
    }

    /**
     * Metodo que agrega un libro a la lista de prestamos (ListaPrestamos)
     * @param libro libro prestado
     * @return boolean
     */
    public boolean agregarLibroPrestado(Libro libro){
        if (listaPrestamos.length==100){
            return false;
        }
        for (int i=0;i<this.listaPrestamos.length;i++){
            if (this.listaPrestamos[i]==null){
                this.listaPrestamos[i]=libro;
            }
        }
        return true;
    }

    public String toString() {
        return "Nombre: " + getNombre() + "\n Apellido: " + getApellido() + "\n Correo: " + getCorreoElectronico();
    }
}

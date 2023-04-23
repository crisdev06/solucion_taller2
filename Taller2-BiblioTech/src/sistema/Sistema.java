package sistema;

import edu.princeton.cs.stdlib.StdOut;
import modelo.Libro;
import modelo.Socio;

public class Sistema {

    /**
     * Lista de Socios del sistema.
     */
    private Socio[] listaSocio;
    /**
     * Lista de Libros del sistema.
     */
    private Libro[] listaLibro;
    /**
     * Socio logueado en el sistema.
     */
    private Socio socioLogueado;

    /**
     * Constructor de la clase.
     */
    public Sistema() {
        this.listaSocio = new Socio[100];
        this.listaLibro = new Libro[100];
        this.socioLogueado = null;
        //pruebas del codigo
        Socio prueba1 = new Socio("cristian","jimenez","cj@gmail.cl","1","cj123");
        Socio prueba2 = new Socio("aa","bb","ab@gmail.com","2","ab12");
        Libro hP = new Libro("Harry Potter","J.K","ficcion","1221");
        Libro hM = new Libro("hola mundo","Helmer","ciencia","2112");
        this.listaSocio[0]=prueba1;
        this.listaSocio[1]=prueba2;
        this.listaLibro[0]=hP;
        this.listaLibro[1]=hM;
    }

    /**
     * Método que inicia sesión del usuario en el sistema.
     * @param numeroSocio numero de usuario.
     * @param contrasenia Contraseña del usuario.
     * @return "True" si se inició sesión y "False" si no se pudo.
     */
    public boolean iniciarSesion(String numeroSocio, String contrasenia) {

        // Comprobamos que no haya un socio en el sistema.
        if (socioLogueado != null){
            return false;
        }
        for (Socio socio : this.listaSocio) {

            // Comprobamos que haya un socio con ese número y que el socio encontrado coincida con la contraseña.
            if (socio.getNumeroSocio().equals(numeroSocio) && socio.getContrasenia().equals(contrasenia)) {
                return true;
            }


        }




        return true;
    }

    /**
     * Método que elimina un libro de la lista de libros del sistema y lo agrega a la lista de libros del socio.
     * @param isbn Identificador único de un libro.
     * @return "True" si el libro fue prestado exitosamente y "False" si no lo fue.
     */
    public boolean prestamoLibro(String isbn){

        // buscamos el libro con el isbn y eliminamos el libro encontrado
        for (int i=0;i<this.listaLibro.length;i++){

            if(this.listaLibro[i].getIsbn().equals(isbn)){
               this.listaLibro[i]=this.listaLibro[i+1];

               for (int j=i+1;j<this.listaLibro.length;j++){
                   this.listaLibro[j]=this.listaLibro[j+1];
               }

               //agregamos el libro a la lista de prestamos
               if (socioLogueado.agregarLibroPrestado(listaLibro[i])){
                   return true;
               }
            }
            else {
                throw new IllegalArgumentException("No quedan copias del libro");
            }
        }


        return false;
    }

    /**
     * Método que cambia el nombre del socio logueado en el sistema.
     * @param nombre Nuevo nombre para el socio.
     */
    public void editarNombreSocio(String nombre){
        // Lógica acá
        if(socioLogueado.getNombre().equals(nombre)){
            StdOut.println("No puede ser el mismo nombre.");
        }else {
            socioLogueado.setNombre(nombre);
        }
    }

    /**
     * Método que cambia el apellido del socio logueado en el sistema.
     * @param apellido Nuevo apellido para el socio.
     */
    public void editarApellidoSocio(String apellido){
        // Lógica acá
        if (socioLogueado.getApellido().equals(apellido)){
            StdOut.println("No puede ser el mismo apellido.");
        }else {
            socioLogueado.setApellido(apellido);
        }
    }

    /**
     * Método que cambia el correo del socio logueado en el sistema.
     * @param correo Nuevo correo para el socio.
     */
    public void editarCorreoSocio(String correo){
        if (socioLogueado.getCorreoElectronico().equals(correo)){
            StdOut.println("No puede ser el mismo correo.");
        }else {
            socioLogueado.setCorreoElectronico(correo);
        }
    }

    /**
     * Método que guarda en una lista los datos de los libros del sistema.
     * @return Lista con los datos de cada libro en forma de String.
     */
    public String[] catalogoLibros(){

        String[] datosLibros = new String[100];

        for (int i = 0; i < this.listaLibro.length; i++) {

            datosLibros[i] = this.listaLibro[i].toString();

        }
        return datosLibros;
    }

    /**
     * Método que obtiene los datos editables del socio en forma de único String.
     * @return Datos del socio.
     */
    public String obtenerDatosSocio(){
        return this.socioLogueado.toString();
    }


    /**
     * Metodo para agregar una nota
     * @param titulo titulo del libro que se busca
     * @param calificacion  nota que se desea agregar
     */
    public void calificarLibro(String titulo,int calificacion){

        for (Libro libro : this.listaLibro) {

            if (libro.getTitulo().equals(titulo)) {
                libro.setCalificaciones(calificacion);
                break;
            } else {
                StdOut.println("el titulo no es correcto.");
            }
        }

    }

    /**
     * Metodo que retorna el promedio total de calificaciones(estrellas) de un libro
     * @param titulo titulo del que se busca el promedio
     * @return promedio
     */
    public int promedioDelLibro(String titulo){
        int promedio;
        for (Libro libro : this.listaLibro) {
            if (libro.getTitulo().equals(titulo)) {
                promedio = libro.notaPromedio();
                return promedio;

            }
        }
        return -1;
    }

    /**
     * Método que cierra sesión del usuario.
     */
    public void cerrarSesion(){
        this.socioLogueado = null;
    }
}

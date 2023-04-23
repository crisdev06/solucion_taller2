package sistema;

import edu.princeton.cs.stdlib.StdIn;
import edu.princeton.cs.stdlib.StdOut;

import java.util.Objects;

public class Menu {

    private Sistema sistema;

    public Menu() {
        this.sistema = new Sistema();
    }

    public void iniciarSistema(){

        String opcion = null;
        while (!Objects.equals(opcion, "6")){

            StdOut.println("""
                [*] Bienvenido a BiblioTech [*]
                
                [1] Iniciar sesión
                [2] Salir
                """);
            StdOut.print("Escoja una opción: ");
            opcion = StdIn.readLine();

            switch (opcion){
                case "1" -> iniciarSesion(sistema);
                case "2" -> StdOut.println("¡Hasta Pronto!");
            }
        }
    }

    /**
     * metodo que inicia la ssion
     * @param sistema:
     */
    private void iniciarSesion(Sistema sistema){

        StdOut.println("[*] Iniciar sesión en BiblioTech [*]");
        StdOut.print("Ingrese su numero de socio: ");
        String numeroSocio = StdIn.readLine();

        StdOut.print("Ingrese su contraseña: ");
        String contrasenia = StdIn.readLine();

        // Logica de inicio de sesion.
        boolean resultado = sistema.iniciarSesion(numeroSocio, contrasenia);

        // Si el inicio de sesión fue exitoso se va al siguiente menú.
        if (resultado){
            menuPrincipal(sistema);
        }else{
            StdOut.println("No se pudo iniciar sesión, usuario inexistente o contraseña inválida");
        }

    }

    /**
     * Metodo que despliega el menu
     * @param sistema:
     */
    private void menuPrincipal(Sistema sistema){

        String opcion = null;
        while (!Objects.equals(opcion, "4")) {
            StdOut.println("""
                    [*] BiblioTech [*]
                                        
                    [1] Préstamo de un libro
                    [2] Editar información
                    [3] Calificar libro
                    [4] Cerrar sesión
                    """);

            StdOut.print("Escoja una opción: ");
            opcion = StdIn.readLine();

            switch (opcion) {
                case "1" -> menuPrestamo(sistema);
                case "2" -> editarInformacion(sistema);
                case "3" -> calificarLibro(sistema); //Crear metodo de calificar libro.
                case "4" -> sistema.cerrarSesion();
            }
        }
    }

    /**
     * Metodo que califica libros si estan en el sistema
     * @param sistema:
     */
    private void calificarLibro(Sistema sistema) {

        StdOut.println("Que libro quiere calificar?:");
        String titulo= StdIn.readLine();
        StdOut.println("ingrese la calificaion.(debe ser del 1 al 5):");
        int calificaion = StdIn.readInt();
        boolean opcion=true;
        while(opcion){
            if (calificaion>0 && calificaion<=5){
                sistema.calificarLibro(titulo,calificaion);
                opcion=false;
            }else{
                StdOut.println("el titulo o la calificaion fue erronea.");
                StdOut.println();
                StdOut.println();
                StdOut.println("Que libro quiere calificar?:");
                titulo= StdIn.readLine();
                StdOut.println("ingrese la calificaion.(debe ser del 1 al 5):");
                calificaion = StdIn.readInt();
            }
        }
        if (sistema.promedioDelLibro(titulo)<=calificaion){
            StdOut.println("La Calificaion fue agregada con exito, " +
                    "y el promedio de estrellas de este libro es:"+ calificaion);
        }
        else{
            StdOut.println("La calificaion fue agregada con exito, " +
                "y el promedio de estrellas de este libro es:"+ sistema.promedioDelLibro(titulo));
        }


    }

    /**
     * Metodo que despliega el menu de prestamos de libros y comprueba el estado del prestamo
     * @param sistema:
     */
    private void menuPrestamo(Sistema sistema){
        StdOut.println("[*] Préstamo de un Libro [*]");

        String[] datosLibros = sistema.catalogoLibros();

        for (String datosLibro : datosLibros) {
            StdOut.println(datosLibro);
        }

        StdOut.print("Ingrese el ISBN del libro a tomar prestado: ");
        String isbn = StdIn.readLine();

        boolean estadoPrestamo = sistema.prestamoLibro(isbn);
        //lógica que informe al usuario que el libro fue prestado o no.
        if (estadoPrestamo){
            StdOut.println("El prestamo fue exitoso, !!DISFRUTE SU LIBRO!!.");
        }else{
            StdOut.println("Lo sentimos, no se pudo realizar el prestamo. !!INTENTE MAS TARDE!!.");
        }

    }

    /**
     * metodo que despliega el menu para editar informacion
     * @param sistema:
     */
    private void editarInformacion(Sistema sistema){

        String opcion = null;
        while (!Objects.equals(opcion, "4")) {

            StdOut.println("[*] Editar Perfil [*]");
            StdOut.println(sistema.obtenerDatosSocio());
            StdOut.println("""               
                    [1] Editar nombre
                    [2] Editar apellido
                    [3] Editar correo
                    [4] Volver atrás
                    """);
            StdOut.print("Escoja una opción: ");
            opcion = StdIn.readLine();

            switch (opcion) {
                case "1" -> editarNombre(sistema);
                case "2" -> editarApellido(sistema);
                case "3" -> editarCorreo(sistema);
                case "4" -> StdOut.println("Volviendo al menú anterior...");
            }
        }
    }

    /**
     * Metodo que permite editar el nombre
     * @param sistema:
     */
    private void editarNombre(Sistema sistema){
        // codigo que solicita al metodo editarNombreSocio() cambiar el nombre.

        StdOut.println("Ingrese el nuevo nombre.");
        String nombreNuevo = StdIn.readLine();
        sistema.editarNombreSocio(nombreNuevo);
    }

    /**
     * Metodo que permite editar el apellido
     * @param sistema:
     */
    private void editarApellido(Sistema sistema){
        // solicita al metodo editarApellidoSocio() cambiar el apellido.

        StdOut.println("Ingrese el nuevo apellido.");
        String apellidoNuevo = StdIn.readLine();
        sistema.editarApellidoSocio(apellidoNuevo);

    }

    /**
     * Metodo que permite editar el correo
     * @param sistema :
     */

    private void editarCorreo(Sistema sistema){
        // solicita al metodo editarCorreoSocio cambiar el correo.

        StdOut.println("Ingrese el nuevo correo.");
        String correoNuevo=StdIn.readLine();
        sistema.editarCorreoSocio(correoNuevo);
    }

}

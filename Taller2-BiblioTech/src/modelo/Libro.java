package modelo;

import edu.princeton.cs.stdlib.StdOut;

public class Libro {

    private String titulo;
    private String autor;
    private String categoria;
    private String isbn;
    private int[] calificaciones= new int[10];

    /**
     * Constructor de la clase Libro
     * @param titulo:
     * @param autor:
     * @param categoria:
     * @param isbn:
     */
    public Libro(String titulo, String autor, String categoria, String isbn) {
        this.titulo = titulo;
        this.autor = autor;
        this.categoria = categoria;
        this.isbn = isbn;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public String getAutor() {
        return this.autor;
    }

    public String getCategoria() {
        return this.categoria;
    }

    public String getIsbn() {
        return this.isbn;
    }


    /**
     * Metodo que calcula el promedio de las calificacion en la lista calificaciones.
     */

    public int notaPromedio() {

        int suma= 0;
        int promedio=0;
        for (int i=0;i<this.calificaciones.length;i++){
            suma +=this.calificaciones[i];
            promedio=suma/(i+1);
        }
        return promedio;
    }

    /**
     *Metodo que agrega una calificacion a la lista calificaciones
     * @param calificacion: calificacion que se agregara a la lista.
     */
    public void setCalificaciones(int calificacion) {

        if (this.calificaciones[this.calificaciones.length-1]==0){
            for (int i = 0; i < this.calificaciones.length; i++) {
                if (this.calificaciones[i]==0){
                    this.calificaciones[i]=calificacion;
                    break;
                }
            }
        }
        else {
            StdOut.println("La lista esta llena.");
        }
    }

    public String toString(){
        return "Título: " + getTitulo() + "\n Autor: " + getAutor() + "\n ISBN: " + getIsbn() + "\n Categoría: "
                + getCategoria();
    }
}

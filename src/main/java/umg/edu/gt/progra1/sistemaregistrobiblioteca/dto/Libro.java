package umg.edu.gt.progra1.sistemaregistrobiblioteca.dto;

public class Libro {
    private String titulo;
    private String autor;
    private String codigo;
    private boolean disponible;

    public Libro() {
        // Constructor vacío
    }

    public Libro(String titulo, String autor, String codigo, boolean disponible) {
        this.titulo = titulo;
        this.autor = autor;
        this.codigo = codigo;
        this.disponible = disponible;
    }

    // Getters y Setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return "Libro{" + "titulo=" + titulo + ", autor=" + autor + 
               ", codigo=" + codigo + ", disponible=" + disponible + '}';
    }
}
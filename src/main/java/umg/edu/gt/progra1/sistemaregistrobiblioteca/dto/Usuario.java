package umg.edu.gt.progra1.sistemaregistrobiblioteca.dto;

public class Usuario {
    private String nombre;
    private int idUsuario;
    private Libro[] librosPrestados;
    private int cantidadLibrosPrestados;

    public Usuario() {
        this.librosPrestados = new Libro[3]; // Máximo 3 libros
        this.cantidadLibrosPrestados = 0;
    }

    public Usuario(String nombre, int idUsuario) {
        this();
        this.nombre = nombre;
        this.idUsuario = idUsuario;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Libro[] getLibrosPrestados() {
        return librosPrestados;
    }

    public int getCantidadLibrosPrestados() {
        return cantidadLibrosPrestados;
    }

    // Métodos para manejar préstamos
    public boolean prestarLibro(Libro libro) {
        if (cantidadLibrosPrestados < 3 && libro.isDisponible()) {
            librosPrestados[cantidadLibrosPrestados] = libro;
            cantidadLibrosPrestados++;
            libro.setDisponible(false);
            return true;
        }
        return false;
    }

    public boolean devolverLibro(Libro libro) {
        for (int i = 0; i < cantidadLibrosPrestados; i++) {
            if (librosPrestados[i].getCodigo().equals(libro.getCodigo())) {
                // Mover los libros restantes
                for (int j = i; j < cantidadLibrosPrestados - 1; j++) {
                    librosPrestados[j] = librosPrestados[j + 1];
                }
                librosPrestados[cantidadLibrosPrestados - 1] = null;
                cantidadLibrosPrestados--;
                libro.setDisponible(true);
                return true;
            }
        }
        return false;
    }

    public void mostrarLibrosPrestados() {
        System.out.println("\nLibros prestados a " + nombre + ":");
        if (cantidadLibrosPrestados == 0) {
            System.out.println("No tiene libros prestados");
        } else {
            for (int i = 0; i < cantidadLibrosPrestados; i++) {
                System.out.println(librosPrestados[i]);
            }
        }
    }

    @Override
    public String toString() {
        return "Usuario{" + "nombre=" + nombre + ", idUsuario=" + idUsuario + 
               ", librosPrestados=" + cantidadLibrosPrestados + "/3}";
    }
}
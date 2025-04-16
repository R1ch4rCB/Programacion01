package umg.edu.gt.progra1.sistemaregistrobiblioteca.dto;

public class Biblioteca {
    private Libro[] libros;
    private Usuario[] usuarios;
    private int totalLibros;
    private int totalUsuarios;

    public Biblioteca() {
        this(100, 100); // Valores por defecto
    }

    public Biblioteca(int maxLibros, int maxUsuarios) {
        libros = new Libro[maxLibros];
        usuarios = new Usuario[maxUsuarios];
        totalLibros = 0;
        totalUsuarios = 0;
    }

    public void registrarUsuario(Usuario usuario) {
        if (totalUsuarios < usuarios.length) {
            usuarios[totalUsuarios] = usuario;
            totalUsuarios++;
            System.out.println("Usuario registrado: " + usuario.getNombre());
        } else {
            System.out.println("No se pueden registrar más usuarios. Capacidad máxima alcanzada.");
        }
    }

    public void agregarLibro(Libro libro) {
        if (totalLibros < libros.length) {
            libros[totalLibros] = libro;
            totalLibros++;
            System.out.println("Libro agregado: " + libro.getTitulo());
        } else {
            System.out.println("No se pueden agregar más libros. Capacidad máxima alcanzada.");
        }
    }

    public void prestarLibro(int idUsuario, String codigo) {
        Usuario usuario = buscarUsuarioPorId(idUsuario);
        Libro libro = buscarLibroPorCodigo(codigo);

        if (usuario == null || libro == null) {
            System.out.println("Usuario o libro no existe");
            return;
        }

        if (!libro.isDisponible()) {
            System.out.println("El libro no está disponible");
            return;
        }

        if (usuario.prestarLibro(libro)) {
            System.out.println("Libro prestado con éxito a " + usuario.getNombre());
        } else {
            System.out.println("El usuario ya tiene el máximo de libros prestados (3)");
        }
    }

    public void devolverLibro(int idUsuario, String codigo) {
        Usuario usuario = buscarUsuarioPorId(idUsuario);
        Libro libro = buscarLibroPorCodigo(codigo);

        if (usuario == null || libro == null) {
            System.out.println("Usuario o libro no existe");
            return;
        }

        if (usuario.devolverLibro(libro)) {
            System.out.println("Libro devuelto con éxito por " + usuario.getNombre());
        } else {
            System.out.println("El usuario no tiene este libro prestado");
        }
    }

    public void mostrarLibrosDisponibles() {
        System.out.println("\n--- LIBROS DISPONIBLES ---");
        boolean hayDisponibles = false;
        for (int i = 0; i < totalLibros; i++) {
            if (libros[i].isDisponible()) {
                System.out.println(libros[i]);
                hayDisponibles = true;
            }
        }
        if (!hayDisponibles) {
            System.out.println("No hay libros disponibles actualmente");
        }
    }

    public void mostrarEstadoBiblioteca() {
        System.out.println("\n--- ESTADO DE LA BIBLIOTECA ---");
        System.out.println("Total libros: " + totalLibros);
        System.out.println("Total usuarios: " + totalUsuarios);
        
        mostrarLibrosDisponibles();
        
        System.out.println("\n--- USUARIOS REGISTRADOS ---");
        for (int i = 0; i < totalUsuarios; i++) {
            System.out.println(usuarios[i]);
            usuarios[i].mostrarLibrosPrestados();
        }
    }

    private Usuario buscarUsuarioPorId(int idUsuario) {
        for (int i = 0; i < totalUsuarios; i++) {
            if (usuarios[i].getIdUsuario() == idUsuario) {
                return usuarios[i];
            }
        }
        return null;
    }

    private Libro buscarLibroPorCodigo(String codigo) {
        for (int i = 0; i < totalLibros; i++) {
            if (libros[i].getCodigo().equals(codigo)) {
                return libros[i];
            }
        }
        return null;
    }

    // Getters y Setters
    public Libro[] getLibros() {
        return libros;
    }

    public Usuario[] getUsuarios() {
        return usuarios;
    }

    public int getTotalLibros() {
        return totalLibros;
    }

    public int getTotalUsuarios() {
        return totalUsuarios;
    }
}
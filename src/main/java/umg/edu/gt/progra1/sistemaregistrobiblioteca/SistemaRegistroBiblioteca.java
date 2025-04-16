package umg.edu.gt.progra1.sistemaregistrobiblioteca;

import umg.edu.gt.progra1.sistemaregistrobiblioteca.dto.Biblioteca;
import umg.edu.gt.progra1.sistemaregistrobiblioteca.dto.Libro;
import umg.edu.gt.progra1.sistemaregistrobiblioteca.dto.Usuario;

public class SistemaRegistroBiblioteca {

    public static void main(String[] args) {
        Libro comedia = new Libro("Padre, el ultimo mono", "Berto Romero", "COM-001", true);         
        Libro tragedia = new Libro("La divina comedia", "Dante Alighieri", "TRAG-001", false);
        Libro drama = new Libro("Don Quijote de la Mancha", "Miguel de Cervantes", "DRAM-001", false);
        Libro accion = new Libro();
        accion.setTitulo("Operaciones stormbreaker");
        accion.setAutor("Anthony Horowitz");
        accion.setDisponible(true);
        accion.setCodigo("ACT-001"); 
        
        Biblioteca biblioteca = new Biblioteca(4, 2);
        
        // Registrar usuarios
        biblioteca.registrarUsuario(new Usuario("Walter", 1));
        biblioteca.registrarUsuario(new Usuario("Anibal", 2));
        biblioteca.registrarUsuario(new Usuario("Pedro", 3)); // No se registrará (capacidad máxima 2)
        
        // Agregar libros
        biblioteca.agregarLibro(accion);
        biblioteca.agregarLibro(drama);
        biblioteca.agregarLibro(tragedia);
        biblioteca.agregarLibro(comedia);
        
        // Mostrar estado inicial
        System.out.println("\n=== ESTADO INICIAL ===");
        biblioteca.mostrarEstadoBiblioteca();
        
        // Prestar libros
        System.out.println("\n=== PRESTAMOS ===");
        biblioteca.prestarLibro(2, "DRAM-001"); // Anibal pide Don Quijote
        biblioteca.prestarLibro(1, "ACT-001");  // Walter pide Stormbreaker
        biblioteca.prestarLibro(2, "COM-001");  // Anibal pide Padre, el último mono
        
        // Mostrar estado después de préstamos
        System.out.println("\n=== DESPUÉS DE PRESTAMOS ===");
        biblioteca.mostrarEstadoBiblioteca();
        
        // Devolver libros
        System.out.println("\n=== DEVOLUCIONES ===");
        biblioteca.devolverLibro(2, "DRAM-001"); // Anibal devuelve Don Quijote
        
        // Mostrar estado final
        System.out.println("\n=== ESTADO FINAL ===");
        biblioteca.mostrarEstadoBiblioteca();
    }
}
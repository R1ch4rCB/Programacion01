/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package umg.edu.gt.progra1.programacion.impl;

import umg.edu.gt.progra1.programacion.impl.dto.Producto;

/**
 *
 * @author wcord
 */
public class Inventario {
    
    public void inicializarInventario() {
        Producto[] productos = new Producto[5];
        productos[0] = new Producto("Maseca", 100, 10.5, "Masa", true);
        productos[1] = new Producto("Coca cola", 0, 20, "Bebida", false);
        productos[2] = new Producto("Pepsi cola", 500, 15, "Bebida", true);
        productos[3] = new Producto("Galleta", 200, 7.25, "Golosinas", true);
        productos[4] = new Producto("Pinguino", 0, 7.25, "Golosinas", false);
        
        // Calcular el precio de todo el inventario       
        System.out.println("Precio total: " + calcularTotalInventario(productos));
        
        // Cuantos productos estan fuera de inventario?
        System.out.println("Productos fuera de inventario: " + contarProductosFueraInventario(productos));
        
        // Cuales son los productos disponibles?
        System.out.println("\nProductos disponibles:");
        mostrarProductosDisponibles(productos);
        
        // Hacer una tabla para mostrar el inventario total
        System.out.println("\nTabla de inventario completo:");
        mostrarTablaInventario(productos);
    }
    
    private double calcularTotalInventario(Producto[] productos) {
        double precioTotal = 0;
        for(Producto prod: productos) {
            precioTotal = precioTotal + prod.calcularValorTotal();
        }
        return precioTotal;
    }
    
    private int contarProductosFueraInventario(Producto[] productos) {
        int contador = 0;
        for(Producto prod: productos) {
            if(prod.getCantidad() == 0) {
                contador++;
            }
        }
        return contador;
    }
    
    private void mostrarProductosDisponibles(Producto[] productos) {
        for(Producto prod: productos) {
            if(prod.getCantidad() > 0 && prod.isDisponible()) {
                System.out.println("- " + prod.getNombre() + " (" + prod.getCantidad() + " unidades)");
            }
        }
    }
    
    private void mostrarTablaInventario(Producto[] productos) {
        System.out.println("-----------------------------------------------------");
        System.out.println("| Nombre       | Cantidad | Precio | Tipo      | Disponible |");
        System.out.println("-----------------------------------------------------");
        
        for(Producto prod: productos) {
            System.out.printf("| %-12s | %-8d | %-6.2f | %-9s | %-10s |\n",
                prod.getNombre(),
                prod.getCantidad(),
                prod.getPrecio(),
                prod.getTipo(),
                prod.isDisponible() ? "Sí" : "No");
        }
        
        System.out.println("-----------------------------------------------------");
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package umg.edu.gt.progra1.programacion.impl.dto;

/**
 *
 * @author wcord
 */
public class Producto {
    // Atributos
    private String nombre;
    private int cantidad;
    private double precio;
    private String tipo;
    // estados: existente (true), agotado (false)
    private boolean estado;
    
    // Constructores
    public Producto() {
    }
    
    public Producto(String nombre, int cantidad, double precio, String tipo, boolean estado) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.tipo = tipo;
        this.estado = estado;
    }
    
    // Métodos de comportamiento
    public double calcularValorTotal() {
        return precio * cantidad;
    }
    
    public boolean isDisponible() {
        return estado && cantidad > 0;
    }
    
    // Método toString
    @Override
    public String toString() {
        return "Producto{" + "nombre=" + nombre + ", cantidad=" + cantidad + 
               ", precio=" + precio + ", tipo=" + tipo + ", estado=" + estado + '}';
    }
    
    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
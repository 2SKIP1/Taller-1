package modelo;

import java.util.ArrayList;

public class ProductoMenu implements Producto {
    private String nombre;
    private int precioBase;


    public ProductoMenu(String elNombre, int elPrecio) {
        this.nombre = elNombre;
        this.precioBase = elPrecio;

    }

    public int getPrecio() {
        return precioBase;
    }

    public String getNombre() {
        return nombre;
    }

    public String generarTextoFactura() {
        return "Para que quieres saber eso jaja salu2";
    }
    
}


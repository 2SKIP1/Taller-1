package modelo;

import java.util.ArrayList;

public class Combo {
    private String nombreCombo;
    private Double descuento; //Esta dado en fraccion porcentual (Num/100)
    private ArrayList<Producto> itemsCombo;

    public Combo (String elNombre, Double elDescuento){
        this.nombreCombo = elNombre;
        this.descuento = elDescuento;
        itemsCombo = new ArrayList<Producto>();

    }
    public void agregarItemACombo(Producto itemCombo){
        itemsCombo.add(itemCombo);
    }
    public int getPrecio(){
        int preciototal = 0;
        for(Producto i : itemsCombo){
            preciototal += i.getPrecio();
        }
        // Falta aplicarle el descuento
        return preciototal;
    }
    public String generarTextoFactura(){ 
        // falta arreglar un poco el formato pero la idea es esta
        String respuesta = nombreCombo + " : ";
        for(Producto i : itemsCombo){
            String nombreItem = i.getNombre();
            respuesta = respuesta + nombreItem + ", ";
        }
        respuesta = respuesta + String.valueOf(this.getPrecio());
        return respuesta;
    }
}

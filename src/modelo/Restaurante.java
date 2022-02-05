package modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Restaurante {

    private Pedido pedidoEnCurso;
    private ArrayList<Pedido> pedidos;
    private ArrayList<Combo> combos;
    private ArrayList<Producto> menuBase;
    private ArrayList<Ingrediente> Ingredientes;

    public Restaurante(){
        combos = new ArrayList<Combo>();
        menuBase = new ArrayList<Producto>();
        Ingredientes = new ArrayList<Ingrediente>();

    }


    public void cargarInformacionRestaurante(String nombreArchivoCombos, String nombreArchivoIngredientes, String nombreArchivoMenu){
        
        cargarIngredientes (new File(nombreArchivoIngredientes));
        cargarMenu (new File (nombreArchivoMenu));
        cargarCombos(new File(nombreArchivoCombos));
        }
        

    public ArrayList<Producto> getMenuBase(){
        return menuBase;
    }

    private void cargarCombos (File archivoCombos){
        /** 
         * Para crear un Restaurante se necesita primero hacer la carga de Datos
         * */
        try
        {
                    // Abrir el archivo de Combos y leerlo línea por línea usando un BufferedReader
            BufferedReader br = new BufferedReader(new FileReader(archivoCombos));
            String linea = br.readLine();
            while (linea != null) // Cuando se llegue al final del archivo, linea tendrá el valor null
            {
                // Separar los valores que estaban en una línea
                String[] partes = linea.split(";");
                ArrayList<String> componentes = new ArrayList<String>(); // Crear este array aqui asegura que se reiniciara para la siguente linea
                String nombreCombo = "ERROR"; // Asegurar que el constructor le pasen variables
                Double descuento = 0.0;

                // Poner los datos en un formato facil de generar objetos con
                for(int i = 0; i < partes.length ; i++){
                    if( i == 0)
                    {
                        nombreCombo = partes[0];
                    }
                    else if( i == 1)
                    {
                        descuento = (Double.parseDouble(partes[1].replace("%", "")))/100;
                    }
                    else{
                        componentes.add(partes[i]);
                    }
                }
                Combo comboActual = new Combo(nombreCombo, descuento); // Crear el combo
                // Agrega los componentes del Combo a este
                for (String s : componentes){
                    for (Producto p : menuBase){
                        if (p.getNombre().equals(s)){
                            comboActual.agregarItemACombo(p);
                        }

                    }
                }
                combos.add(comboActual); // Agregar el combo al restaruante
                linea = br.readLine();
            }
            br.close();
        
        }
        catch (FileNotFoundException e)
        {
            System.out.println("ERROR: el archivo indicado no se encontró.");
        }
        catch (IOException e)
        {
            System.out.println("ERROR: hubo un problema leyendo el archivo.");
            System.out.println(e.getMessage());
        }
    }

    private void cargarIngredientes (File archivoIngredientes){
        try
        {
        // Abrir el archivo de Combos y leerlo línea por línea usando un BufferedReader
        BufferedReader br2 = new BufferedReader(new FileReader(archivoIngredientes));
        String linea2 = br2.readLine();
        while (linea2 != null) // Cuando se llegue al final del archivo, linea tendrá el valor null
        {
            // Separar los valores que estaban en una línea
            String[] partes = linea2.split(";");
            String nombreIngrediente = partes[0];
            int precioIngrediente = Integer.parseInt(partes[1]);

            // generar el objeto y guardarlo
            Ingredientes.add(new Ingrediente(nombreIngrediente,precioIngrediente));
            linea2 = br2.readLine();

        }
        br2.close();
        }

        catch (FileNotFoundException e)
        {
            System.out.println("ERROR: el archivo indicado no se encontró.");
        }
        catch (IOException e)
        {
            System.out.println("ERROR: hubo un problema leyendo el archivo.");
            System.out.println(e.getMessage());
        }

        
    }
    private void cargarMenu (File archivoMenu){
        /** 
         * Para crear un Restaurante se necesita primero hacer la carga de Datos
         * */
        try
        {
                                // Abrir el archivo de Combos y leerlo línea por línea usando un BufferedReader
                BufferedReader br3 = new BufferedReader(new FileReader(archivoMenu));
                String linea3 = br3.readLine();
                while (linea3 != null) // Cuando se llegue al final del archivo, linea tendrá el valor null
                {
                    // Separar los valores que estaban en una línea
                    String[] partes = linea3.split(";");
                    String nombreProductoMenu = "ERROR"; // Asegurar que el constructor le pasen variables
                    int precioBaseProductoMenu = 0;
    
                    // Poner los datos en un formato facil de generar objetos con
                    for(int i = 0; i < partes.length ; i++){
    
                            nombreProductoMenu = partes[0];
    
                            precioBaseProductoMenu = Integer.parseInt(partes[1]);
                        }
                    ProductoMenu productoMenuActual = new ProductoMenu(nombreProductoMenu, precioBaseProductoMenu); // Crear el combo
                    menuBase.add(productoMenuActual); // Agregar el combo al restaruante
                    linea3 = br3.readLine();
                }
                br3.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("ERROR: el archivo indicado no se encontró.");
        }
        catch (IOException e)
        {
            System.out.println("ERROR: hubo un problema leyendo el archivo.");
            System.out.println(e.getMessage());
        }
    }
}

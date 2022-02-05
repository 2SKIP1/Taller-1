package consola;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import modelo.Restaurante;

public class Aplicacion{
  private Restaurante restaruante;
  public static final String nombreArchivoCombos = "data/combos.txt";
  public static final String nombreArchivoIngredientes = "data/ingredientes.txt";
  public static final String nombreArchivoMenu = "data/menu.txt";

  public Aplicacion(){
    System.out.println("\n");
    System.out.println("Ejecutando carga de Datos.........");
    this.restaruante = new Restaurante();
    restaruante.cargarInformacionRestaurante(nombreArchivoCombos, nombreArchivoIngredientes, nombreArchivoMenu);
    System.out.println("Carga de Datos Exitosa.\n");

 
  }


    public void ejecutarAplicacion(){
    // Este es el while que corre toda la opcion y la mantiene corriendo hasta que se desee salir o surga un error
		boolean continuar = true;
		  while (continuar)
		  {
    
        try
        {
          mostrarMenu();
          int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opción: \n"));
          ejecutarOpcion(opcion_seleccionada);
        }
        catch (NumberFormatException e)
        {
          System.out.println("Debe seleccionar uno de los números de las opciones.");
        }
		  }
    }


    public void mostrarMenu(){
        
    }

  
    public void ejecutarOpcion(int opcionSeleccionada){

    }

    
    public String input(String mensaje)
    {
      try
      {
        System.out.print(mensaje + ": ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return reader.readLine();
      }
      catch (IOException e)
      {
        System.out.println("Error leyendo de la consola");
        e.printStackTrace();
      }
      return null;
    }

    public static void main(String[] args){
		Aplicacion aplicacion = new Aplicacion();
    aplicacion.ejecutarAplicacion();
		
	}

}
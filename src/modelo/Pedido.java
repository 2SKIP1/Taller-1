package modelo;

public class Pedido {

    private int numeroPedidos;
    private int idPedido;
    private String nombreCliente;
    private String direccionCliente;

    public Pedido(String elNombreCliente, String elDireccionCliente)
	{
        this.nombreCliente = elNombreCliente;
		this.direccionCliente = elDireccionCliente;
        this.numeroPedidos = 0;
		this.idPedido = 0;

	}
    
}

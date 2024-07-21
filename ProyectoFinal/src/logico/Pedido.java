package logico;

import java.util.ArrayList;
import java.util.Date;

public class Pedido {
    private String idPedido;
    private Cliente cliente;
    private ArrayList<Componente> componentesPedidos;
    private Date fechaFacturacion;
    private float precioTotal;

    
    public Pedido(String idPedido, Cliente cliente, ArrayList<Componente> componentesPedidos, Date fechaFacturacion,
			float precioTotal) {
		super();
		this.idPedido = idPedido;
		this.cliente = cliente;
		this.componentesPedidos = componentesPedidos;
		this.fechaFacturacion = fechaFacturacion;
		this.precioTotal = precioTotal;
	}



	public Cliente getCliente() {
		return cliente;
	}



	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}



	public ArrayList<Componente> getComponentesPedidos() {
		return componentesPedidos;
	}



	public void setComponentesPedidos(ArrayList<Componente> componentesPedidos) {
		this.componentesPedidos = componentesPedidos;
	}



	public Date getFechaFacturacion() {
		return fechaFacturacion;
	}



	public void setFechaFacturacion(Date fechaFacturacion) {
		this.fechaFacturacion = fechaFacturacion;
	}



	public float getPrecioTotal() {
		return precioTotal;
	}



	public void setPrecioTotal(float precioTotal) {
		this.precioTotal = precioTotal;
	}



	public String getIdPedido() {
		return idPedido;
	}

	private void calcularPrecioTotalConImpuestos() {
        precioTotal = 0;
        for (Componente componente : componentesPedidos) {
        	precioTotal += componente.getPrecio();
        }
        precioTotal += precioTotal * 0.18;
    }
}

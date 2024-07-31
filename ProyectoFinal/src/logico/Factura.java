package logico;

import java.io.Serializable;

public class Factura implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */

	private String idFactura;
	private String idCliente;
	private int fechaFacturacion;
	private Componente componente;
	private float precioTotal;
	
	
	public Factura(String idFactura, String idCliente, int fechaFacturacion, Componente componente, float precioTotal) {
		super();
		this.idFactura = idFactura;
		this.idCliente = idCliente;
		this.fechaFacturacion = fechaFacturacion;
		this.componente = componente;
		this.precioTotal = precioTotal;
	}



	public float getPrecioTotal() {
		return precioTotal;
	}



	public void setPrecioTotal(float precioTotal) {
		this.precioTotal = precioTotal;
	}



	public int getFechaFacturacion() {
		return fechaFacturacion;
	}
	public void setFechaFacturacion(int fechaFacturacion) {
		this.fechaFacturacion = fechaFacturacion;
	}
	public Componente getComponente() {
		return componente;
	}
	public void setComponente(Componente componente) {
		this.componente = componente;
	}
	public String getIdFactura() {
		return idFactura;
	}
	public String getIdCliente() {
		return idCliente;
	}
	

}

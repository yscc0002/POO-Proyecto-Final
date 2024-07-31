package logico;

public class Factura {
	
	private String idFactura;
	private String idCliente;
	private int fechaFacturacion;
	private Componente componente;
	
	
	public Factura(String idFactura, String idCliente, int fechaFacturacion, Componente componente) {
		super();
		this.idFactura = idFactura;
		this.idCliente = idCliente;
		this.fechaFacturacion = fechaFacturacion;
		this.componente = componente;
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

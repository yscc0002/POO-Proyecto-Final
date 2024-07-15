package logico;

public class Componente {
	
	private String numeroDeSerie;
	private String marca;
	private String modelo;
	private float precio; 
	private int cantDisponible;
	
	public Componente(String numeroDeSerie, String marca, String modelo, float precio, int cantDisponible) {
		super();
		this.numeroDeSerie = numeroDeSerie;
		this.marca = marca;
		this.modelo = modelo;
		this.precio = precio;
		this.cantDisponible = cantDisponible;
	}
	
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public int getCantDisponible() {
		return cantDisponible;
	}
	public void setCantDisponible(int cantDisponible) {
		this.cantDisponible = cantDisponible;
	}
	public String getNumeroDeSerie() {
		return numeroDeSerie;
	}
	
	

}

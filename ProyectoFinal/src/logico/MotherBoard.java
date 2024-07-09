package logico;

import java.util.ArrayList;

public class MotherBoard {
	
	private String numeroDeSerie;
	private float precio;
	private int cantDisponible;
	private String marca;
	private String modelo;
	private String tipoDeConector;
	private String tipoDeMemoriaRam;
	private ArrayList<DiscoDuro> discoDurosAceptados;
	
	public MotherBoard(String numeroDeSerie, float precio, int cantDisponible, String marca, String modelo,
			String tipoDeConector, String tipoDeMemoriaRam, ArrayList<DiscoDuro> discoDurosAceptados) {
		super();
		this.numeroDeSerie = numeroDeSerie;
		this.precio = precio;
		this.cantDisponible = cantDisponible;
		this.marca = marca;
		this.modelo = modelo;
		this.tipoDeConector = tipoDeConector;
		this.tipoDeMemoriaRam = tipoDeMemoriaRam;
		this.discoDurosAceptados = discoDurosAceptados;
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
	public String getTipoDeConector() {
		return tipoDeConector;
	}
	public void setTipoDeConector(String tipoDeConector) {
		this.tipoDeConector = tipoDeConector;
	}
	public String getTipoDeMemoriaRam() {
		return tipoDeMemoriaRam;
	}
	public void setTipoDeMemoriaRam(String tipoDeMemoriaRam) {
		this.tipoDeMemoriaRam = tipoDeMemoriaRam;
	}
	public ArrayList<DiscoDuro> getDiscoDurosAceptados() {
		return discoDurosAceptados;
	}
	public void setDiscoDurosAceptados(ArrayList<DiscoDuro> discoDurosAceptados) {
		this.discoDurosAceptados = discoDurosAceptados;
	}
	public String getNumeroDeSerie() {
		return numeroDeSerie;
	}
	
	


}

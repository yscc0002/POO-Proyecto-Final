package logico;

import java.io.Serializable;

public class Componente implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */

	private String numeroDeSerie;
	private String marca;
	private String modelo;
	private float precio;
	private int cantDisponible;
	private boolean seleccionado;


	public Componente(String numeroDeSerie, String marca, String modelo, float precio, int cantDisponible) {
		this.numeroDeSerie = numeroDeSerie;
		this.marca = marca;
		this.modelo = modelo;
		this.precio = precio;
		this.cantDisponible = cantDisponible;
	}

	public String getNumeroDeSerie() {
		return numeroDeSerie;
	}

	public void setNumeroDeSerie(String numeroDeSerie) {
		this.numeroDeSerie = numeroDeSerie;
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
	

	public boolean isSeleccionado() {
		return seleccionado;
	}

	public void setSeleccionado(boolean seleccionado) {
		this.seleccionado = seleccionado;
	}
}

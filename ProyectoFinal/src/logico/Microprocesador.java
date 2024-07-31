package logico;

import java.io.Serializable;

public class Microprocesador extends Componente {
	private static final long serialVersionUID = 1L;
	private float velocidadGHZ;
	private String socket;

	public Microprocesador(String numeroDeSerie, String marca, String modelo, float precio, int cantDisponible,
			float velocidadGHZ, String socket) {
		super(numeroDeSerie, marca, modelo, precio, cantDisponible);
		this.velocidadGHZ = velocidadGHZ;
		this.socket = socket;
	}

	public float getVelocidadGHZ() {
		return velocidadGHZ;
	}

	public void setVelocidadGHZ(float velocidadGHZ) {
		this.velocidadGHZ = velocidadGHZ;
	}

	public String getSocket() {
		return socket;
	}

	public void setSocket(String socket) {
		this.socket = socket;
	}
}
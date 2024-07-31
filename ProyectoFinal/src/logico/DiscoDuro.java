package logico;

import java.io.Serializable;

public class DiscoDuro extends Componente {
	private static final long serialVersionUID = 1L;
	private int capacidadDeAlmacenamientoGB;
	private String tipoDeConexion;

	public DiscoDuro(String numeroDeSerie, String marca, String modelo, float precio, int cantDisponible,
			int capacidadDeAlmacenamientoGB, String tipoDeConexion) {
		super(numeroDeSerie, marca, modelo, precio, cantDisponible);
		this.capacidadDeAlmacenamientoGB = capacidadDeAlmacenamientoGB;
		this.tipoDeConexion = tipoDeConexion;
	}

	public int getCapacidadDeAlmacenamientoGB() {
		return capacidadDeAlmacenamientoGB;
	}

	public void setCapacidadDeAlmacenamientoGB(int capacidadDeAlmacenamientoGB) {
		this.capacidadDeAlmacenamientoGB = capacidadDeAlmacenamientoGB;
	}

	public String getTipoDeConexion() {
		return tipoDeConexion;
	}

	public void setTipoDeConexion(String tipoDeConexion) {
		this.tipoDeConexion = tipoDeConexion;
	}
}

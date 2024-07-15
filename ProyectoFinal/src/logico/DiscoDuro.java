package logico;

import java.awt.Component;

public class DiscoDuro extends Component {
	
	public DiscoDuro(int capacidadDeAlmacenamientoGB, String tipoDeConexion) {
		super();
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
	private int capacidadDeAlmacenamientoGB;
	private String tipoDeConexion;

}

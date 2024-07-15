package logico;


import java.awt.Component;

public class Microprocesador extends Component {

	public Microprocesador(String tipoDeConexion, float velocidadGHZ) {
		super();
		this.tipoDeConexion = tipoDeConexion;
		this.velocidadGHZ = velocidadGHZ;
	}
	public String getTipoDeConexion() {
		return tipoDeConexion;
	}
	public void setTipoDeConexion(String tipoDeConexion) {
		this.tipoDeConexion = tipoDeConexion;
	}
	public float getVelocidadGHZ() {
		return velocidadGHZ;
	}
	public void setVelocidadGHZ(float velocidadGHZ) {
		this.velocidadGHZ = velocidadGHZ;
	}
	private String tipoDeConexion;
	private float velocidadGHZ;
}

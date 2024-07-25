package logico;

public class Microprocesador extends Componente {
    private float velocidadGHZ;
    private String tipoConexion;
    
 
    
	public Microprocesador(String numeroDeSerie, String marca, String modelo, float precio, int cantDisponible,
			float velocidadGHZ, String tipoConexion) {
		super(numeroDeSerie, marca, modelo, precio, cantDisponible);
		this.velocidadGHZ = velocidadGHZ;
		this.tipoConexion = tipoConexion;
	}
	public float getVelocidadGHZ() {
		return velocidadGHZ;
	}
	public void setVelocidadGHZ(float velocidadGHZ) {
		this.velocidadGHZ = velocidadGHZ;
	}
	public String getTipoConexion() {
		return tipoConexion;
	}
	public void setTipoConexion(String tipoConexion) {
		this.tipoConexion = tipoConexion;
	}

   
}

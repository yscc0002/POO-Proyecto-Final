package logico;

public class DiscoDuro {
	
	private String numeroDeSerie;
	private float precio;
	private int cantDisponible;
	private String marca;
	private String modelo;
	private int capacidadDeAlmacenamientoGB;
	private String tipoDeMemoriaRamGB;
	private String tipoDeConexion;
	
	public DiscoDuro(String numeroDeSerie, float precio, int cantDisponible, String marca, String modelo,
			int capacidadDeAlmacenamientoGB, String tipoDeMemoriaRamGB, String tipoDeConexion) {
		super();
		this.numeroDeSerie = numeroDeSerie;
		this.precio = precio;
		this.cantDisponible = cantDisponible;
		this.marca = marca;
		this.modelo = modelo;
		this.capacidadDeAlmacenamientoGB = capacidadDeAlmacenamientoGB;
		this.tipoDeMemoriaRamGB = tipoDeMemoriaRamGB;
		this.tipoDeConexion = tipoDeConexion;
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
	public int getCapacidadDeAlmacenamientoGB() {
		return capacidadDeAlmacenamientoGB;
	}
	public void setCapacidadDeAlmacenamientoGB(int capacidadDeAlmacenamientoGB) {
		this.capacidadDeAlmacenamientoGB = capacidadDeAlmacenamientoGB;
	}
	public String getTipoDeMemoriaRamGB() {
		return tipoDeMemoriaRamGB;
	}
	public void setTipoDeMemoriaRamGB(String tipoDeMemoriaRamGB) {
		this.tipoDeMemoriaRamGB = tipoDeMemoriaRamGB;
	}
	public String getTipoDeConexion() {
		return tipoDeConexion;
	}
	public void setTipoDeConexion(String tipoDeConexion) {
		this.tipoDeConexion = tipoDeConexion;
	}
	public String getNumeroDeSerie() {
		return numeroDeSerie;
	}
	
	
}

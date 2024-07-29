package logico;

import java.io.Serializable;

public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;
	private String idCliente;
	private String nombre;
	private String direccion;
	private String telefono;
	private String email;
	private String provincia;
	private String pais;

	public Cliente(String idCliente, String nombre, String direccion, String telefono, String email, String provincia,
			String pais) {
		super();
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.email = email;
		this.provincia = provincia;
		this.pais = pais;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIdCliente() {
		return idCliente;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public float calcularCostoEnvio() {
		if (pais.equalsIgnoreCase("Republica Dominicana")) {
			if (provincia.equalsIgnoreCase("La Vega")) {
				return 100;
			} else {
				return 200;
			}
		} else {
			return 500;
		}
	}

	public boolean actualizarComponente(String numeroDeSerie, String nuevaMarca, String nuevoModelo, float nuevoPrecio,
			int nuevaCantidadDisponible) {
		Controladora controladora = Controladora.getInstance();
		return controladora.actualizarComponente(numeroDeSerie, nuevaMarca, nuevoModelo, nuevoPrecio,
				nuevaCantidadDisponible);
	}
	
}

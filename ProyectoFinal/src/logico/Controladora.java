package logico;

import java.util.ArrayList;
import java.util.Date;

public class Controladora {
	
	private ArrayList<Componente> losComponentes;
	private ArrayList<Cliente> losClientes;
	private ArrayList<Pedido> losPedidos;
	public static int codComponente = 1;
	
	//Patron Singleton
	private static Controladora controladora = null;
	
	private Controladora() {
		super();
		this.losComponentes = new ArrayList<>();
		this.losClientes = new ArrayList<>();
		this.losPedidos = new ArrayList<>();
	}
	
	public static Controladora getInstance() {
		if(controladora==null) {
			controladora = new Controladora();
		}return controladora;
	}

	//Cierre Patron Singleton

	public ArrayList<Componente> getLosComponentes() {
		return losComponentes;
	}

	public void setLosComponentes(ArrayList<Componente> losComponentes) {
		this.losComponentes = losComponentes;
	}

	public ArrayList<Cliente> getLosClientes() {
		return losClientes;
	}

	public void setLosClientes(ArrayList<Cliente> losClientes) {
		this.losClientes = losClientes;
	}

	public ArrayList<Pedido> getLosPedidos() {
		return losPedidos;
	}

	public void setLosPedidos(ArrayList<Pedido> losPedidos) {
		this.losPedidos = losPedidos;
	}

	public Componente buscarComponentePorNumeroDeSerie(String numeroDeSerie) {
		for (Componente componente : losComponentes) {
			if (componente.getNumeroDeSerie().equals(numeroDeSerie)) {
				return componente;
			}
		}
		return null;
	}

	public int consultarDisponibilidadComponente(String numeroDeSerie) {
		for (Componente componente : losComponentes) {
			if (componente.getNumeroDeSerie().equals(numeroDeSerie)) {
				return componente.getCantDisponible();
			}
		}
		return -1; 
	}

	public void crearPedido(String idPedido, Cliente cliente, ArrayList<Componente> componentesSeleccionados) {
	    Date fechaActual = new Date();
	    float montoTotal = 0;
	    for (Componente componente : componentesSeleccionados) {
	        montoTotal += componente.getPrecio();
	    }
	    montoTotal += montoTotal * 0.18;
	    Pedido nuevoPedido = new Pedido(idPedido, cliente, componentesSeleccionados, fechaActual, montoTotal);
	    losPedidos.add(nuevoPedido);
	}
	
	public void agregarComponente(Componente nuevoComponente) {
		losComponentes.add(nuevoComponente);
	}
	
	 public boolean eliminarComponente(String numeroDeSerie) {
	        for (int i = 0; i < losComponentes.size(); i++) {
	            if (losComponentes.get(i).getNumeroDeSerie().equals(numeroDeSerie)) {
	            	losComponentes.remove(i);
	                return true; 
	            }
	        }
	        return false;
	 }
	 
	 public ArrayList<Componente> buscarComponentesPorMarcaYModelo(String marca, String modelo) {
	        ArrayList<Componente> componentesEncontrados = new ArrayList<>();
	        for (Componente componente : losComponentes) {
	            if (componente.getMarca().equalsIgnoreCase(marca) && componente.getModelo().equalsIgnoreCase(modelo)) {
	                componentesEncontrados.add(componente);
	            }
	        }
	        return componentesEncontrados;
	 }
	 
	 public void crearUsuarioCliente(String idCliente, String nombre, String direccion, String telefono, String email) {
	        Cliente nuevoCliente = new Cliente(idCliente, nombre, direccion, telefono, email);
	        losClientes.add(nuevoCliente);
	 }
}

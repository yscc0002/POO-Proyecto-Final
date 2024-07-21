package logico;

import java.util.ArrayList;
import java.util.Date;

public class Controladora {
	
	private ArrayList<Componente> losComponentes;
	private ArrayList<Cliente> losClientes;
	private ArrayList<Pedido> losPedidos;
	
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
		Pedido nuevoPedido = new Pedido(idPedido, cliente, componentesSeleccionados, fechaActual);
		losPedidos.add(nuevoPedido);
	}


}

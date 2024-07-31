package logico;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Controladora implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private ArrayList<Componente> losComponentes;
	private ArrayList<Cliente> losClientes;
	private ArrayList<Factura> lasFacturas;
	private ArrayList<Combo> losCombos;  
	private ArrayList<UserC> misUsuarios;
	public static int codComponente = 1;
	public static int codCliente = 1;
	public static int codFactura = 1;

	private static UserC loginUser;

	public static UserC getLoginUser() {
		return loginUser;
	}

	public static void setLoginUser(UserC loginUser) {
		Controladora.loginUser = loginUser;
	}

	// Patron Singleton
	private static Controladora controladora = null;

	private Controladora() {
		super();
		this.losComponentes = new ArrayList<>();
		this.losClientes = new ArrayList<>();
		this.lasFacturas = new ArrayList<>();
		this.losCombos = new ArrayList<>();
		this.misUsuarios = new ArrayList<>();
	}

	public static Controladora getInstance() {
		if (controladora == null) {
			controladora = new Controladora();
		}
		return controladora;
	}


	public static Controladora getControladora() {
		return controladora;
	}

	public static void setControladora(Controladora controladora) {
		Controladora.controladora = controladora;
	}

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

	public ArrayList<Factura> getLasFacturas() {
		return lasFacturas;
	}

	public void setLasFacturas(ArrayList<Factura> lasFacturas) {
		this.lasFacturas = lasFacturas;
	}

	public ArrayList<Combo> getLosCombos() {
		return losCombos;
	}

	public void setLosCombos(ArrayList<Combo> losCombos) {
		this.losCombos = losCombos;
	}

	public void actualizarCliente(Cliente cliente) {
		for (int i = 0; i < losClientes.size(); i++) {
			if (losClientes.get(i).getIdCliente().equals(cliente.getIdCliente())) {
				losClientes.set(i, cliente);
				return;
			}
		}
	}

	public Cliente buscarClientePorId(String id) {
		for (Cliente cliente : losClientes) {
			if (cliente.getIdCliente().equals(id)) {
				return cliente;
			}
		}
		return null;
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


	public void agregarComponente(Componente nuevoComponente) {
		losComponentes.add(nuevoComponente);
		codComponente++;
	}

	public void agregarFactura(String idFactura, String idCliente, int fechaFacturacion, float precioTotal, Componente componente) {
		Cliente cliente = buscarClientePorId(idCliente);
		if(cliente!=null) {
		//	lasFacturas.add(new Factura(idFactura,idCliente,fechaFacturacion,precioTotal,componente));
		}
		codFactura++;
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


	public void insertarCliente(Cliente cliente) {
		losClientes.add(cliente);
		codCliente++;
	}


	public void crearUsuarioCliente(String idCliente, String nombre, String direccion, String telefono, String email) {
		Cliente nuevoCliente = new Cliente(idCliente, nombre, direccion, email, telefono, "Provincia Desconocida", "Pais Desconocido");
		losClientes.add(nuevoCliente);
		codCliente++;
	}


	private MotherBoard buscarMotherBoardPorNumeroDeSerie(String numeroDeSerie) {
		for (Componente componente : losComponentes) {
			if (componente instanceof MotherBoard && componente.getNumeroDeSerie().equals(numeroDeSerie)) {
				return (MotherBoard) componente;
			}
		}
		return null;
	}

	private boolean esCompatible(DiscoDuro disco, ArrayList<DiscoDuro> discosAceptados) {
		for (DiscoDuro discoAceptado : discosAceptados) {
			if (disco.getTipoDeConexion().equalsIgnoreCase(discoAceptado.getTipoDeConexion())) {
				return true;
			}
		}
		return false;
	}
/*
	public ArrayList<String> generarReporteVentas() {
		ArrayList<String> reporteVentas = new ArrayList<>();

		for (Pedido pedido : losPedidos) {
			StringBuilder reporte = new StringBuilder();
			reporte.append("ID Pedido: ").append(pedido.getIdPedido()).append("\n");
			reporte.append("Cliente: ").append(pedido.getCliente().getNombre()).append("\n");
			reporte.append("Fecha de Facturacion: ").append(pedido.getFechaFacturacion()).append("\n");
			reporte.append("Precio Total: ").append(pedido.getPrecioTotal()).append("\n");
			reporte.append("Componentes:\n");
			for (Componente componente : pedido.getComponentesPedidos()) {
				reporte.append(" - ").append(componente.getMarca()).append(" ").append(componente.getModelo()).append(" (").append(componente.getNumeroDeSerie()).append(")\n");
			}
			reporteVentas.add(reporte.toString());
		}

		return reporteVentas;
	}
	*/

	public boolean actualizarComponente(String numeroDeSerie, String nuevaMarca, String nuevoModelo, float nuevoPrecio, int nuevaCantidadDisponible) {
		Componente componente = buscarComponentePorNumeroDeSerie(numeroDeSerie);
		if (componente != null) {
			componente.setMarca(nuevaMarca);
			componente.setModelo(nuevoModelo);
			componente.setPrecio(nuevoPrecio);
			componente.setCantDisponible(nuevaCantidadDisponible);
			return true;
		}
		return false;
	}

	public ArrayList<Microprocesador> encontrarMicroprocesadoresCompatibles(String numeroDeSerieMotherBoard) {
		MotherBoard motherboardBuscada = buscarMotherBoardPorNumeroDeSerie(numeroDeSerieMotherBoard);
		ArrayList<Microprocesador> microsCompatibles = new ArrayList<>();

		if (motherboardBuscada != null) {
			String socketRequerido = motherboardBuscada.getTipoDeConector();
			for (Componente componente : losComponentes) {
				if (componente instanceof Microprocesador) {
					Microprocesador micro = (Microprocesador) componente;
					if (micro.getSocket().equalsIgnoreCase(socketRequerido) && micro.getCantDisponible() > 0) {
						microsCompatibles.add(micro);
					}
				}
			}
		}
		return microsCompatibles;
	}

	public Combo verificarCombo(String codigo) {
		for (Combo combo : losCombos) {
			if (combo.getCodigo().equalsIgnoreCase(codigo)) {
				return combo;
			}
		}
		return null;
	}

	public void agregarCombo(Combo combo) {
		losCombos.add(combo);
	}



	public int buscarComponenteByIDGetIndex(String idComponente) {
		int componente = -1;
		boolean encontrado  = false;
		int i = 0;
		while (!encontrado && i < losComponentes.size()) {
			if(losComponentes.get(i).getNumeroDeSerie().equalsIgnoreCase(idComponente)){
				componente = i;
				encontrado = true;
			}
			i++;
		}

		return componente;
	}

	public void updateComponente(Componente componente) {
		int index = buscarComponenteByIDGetIndex(componente.getNumeroDeSerie());
		if(index!= -1){
			losComponentes.set(index, componente);
		}	
	}




	public ArrayList<Componente> getComponentesNoSeleccionados(){
		ArrayList<Componente> componentesNoSeleccionados = new ArrayList<>();

		for(Componente tempComponente : losComponentes) {
			if(!tempComponente.isSeleccionado()) {
				componentesNoSeleccionados.add(tempComponente);
			}
		}
		return componentesNoSeleccionados;
	}

	public ArrayList<Componente> getComponentesSeleccionados(){
		ArrayList<Componente> componentesSeleccionados = new ArrayList<>();

		for(Componente tempComponente : losComponentes) {
			if(tempComponente.isSeleccionado()) {
				componentesSeleccionados.add(tempComponente);
			}
		}
		return componentesSeleccionados;

	}

	public int buscarClientePorIDObtenerIndex(String codigo) {
		int index = -1;
		boolean encontrado = false;

		int i = 0;
		while (!encontrado && i < losClientes.size()) {
			if(losClientes.get(i).getIdCliente().equalsIgnoreCase(codigo)) {
				index = i;
				encontrado = true;
			}
			i++;
		}

		return index;
	}

	public void actualizarClienteV(Cliente cliente) {
		int index = buscarClientePorIDObtenerIndex(cliente.getIdCliente());
		if(index!=-1) {
			losClientes.set(index, cliente);
		}

	}


	public void realizarFactura(String idFactura, String idCliente, int fechaFacturacion,Componente componente, float precioTotal) {
		Cliente cliente = buscarClientePorId(idCliente);

		if(cliente!=null) {
			lasFacturas.add(new Factura(idFactura,idCliente,fechaFacturacion,componente,precioTotal));
		}
		codFactura++;
	}

	public void regUser(UserC user) {
		misUsuarios.add(user);
	}

	public boolean confirmLogin(String text, String text2) {
		boolean login = false;
		for (UserC user : misUsuarios) {
			if(user.getUsername().equals(text) && user.getPassword().equals(text2)){
				loginUser = user;
				login = true;
			}
		}
		return login;
	}

}
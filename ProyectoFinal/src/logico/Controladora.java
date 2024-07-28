package logico;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Controladora implements Serializable {
    private static final long serialVersionUID = 1L;

    private ArrayList<Componente> losComponentes;
    private ArrayList<Cliente> losClientes;
    private ArrayList<Pedido> losPedidos;
    public static int codComponente = 1;

    // Patron Singleton
    private static Controladora controladora = null;

    private Controladora() {
        super();
        this.losComponentes = new ArrayList<>();
        this.losClientes = new ArrayList<>();
        this.losPedidos = new ArrayList<>();
    }

    public static Controladora getInstance() {
        if (controladora == null) {
            controladora = new Controladora();
        }
        return controladora;
    }

    protected Object readResolve() {
        return getInstance();
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

    public ArrayList<Pedido> getLosPedidos() {
        return losPedidos;
    }

    public void setLosPedidos(ArrayList<Pedido> losPedidos) {
        this.losPedidos = losPedidos;
    }

    public void agregarCliente(Cliente cliente) {
        losClientes.add(cliente);
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
        Cliente nuevoCliente = new Cliente(idCliente, nombre, direccion, telefono, email, "Provincia Desconocida", "Pais Desconocido");
        losClientes.add(nuevoCliente);
    }

    public ArrayList<DiscoDuro> encontrarDiscosDurosCompatibles(String numeroDeSerieMotherBoard) {
        MotherBoard motherboardBuscada = buscarMotherBoardPorNumeroDeSerie(numeroDeSerieMotherBoard);
        ArrayList<DiscoDuro> discosCompatibles = new ArrayList<>();

        if (motherboardBuscada != null) {
            ArrayList<DiscoDuro> discosAceptados = motherboardBuscada.getDiscoDurosAceptados();
            for (Componente componente : losComponentes) {
                if (componente instanceof DiscoDuro) {
                    DiscoDuro disco = (DiscoDuro) componente;
                    if (esCompatible(disco, discosAceptados) && disco.getCantDisponible() > 0) {
                        discosCompatibles.add(disco);
                    }
                }
            }
        }
        return discosCompatibles;
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

    public static void setControladora(Controladora temp) {
        Controladora.controladora = temp;
    }
}

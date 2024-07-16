package logico;

import java.util.ArrayList;

public class Controladora {
    private ArrayList<Componente> inventario;
    private ArrayList<Cliente> losClientes;
    private ArrayList<Pedido> losPedidos;

    public Controladora() {
        this.inventario = new ArrayList<>();
        this.losClientes = new ArrayList<>();
        this.losPedidos = new ArrayList<>();
    }

    public ArrayList<Componente> getInventario() {
        return inventario;
    }

    public void setInventario(ArrayList<Componente> inventario) {
        this.inventario = inventario;
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

    public void agregarDiscoDuro(DiscoDuro discoDuro) {
        inventario.add(discoDuro);
    }

    public void agregarMemoriaRAM(MemoriaRAM memoriaRAM) {
        inventario.add(memoriaRAM);
    }

    public void agregarMicroprocesador(Microprocesador microprocesador) {
        inventario.add(microprocesador);
    }

    public void agregarMotherBoard(MotherBoard motherBoard) {
        inventario.add(motherBoard);
    }

    public Componente buscarComponentePorNumeroDeSerie(String numeroDeSerie) {
        for (Componente componente : inventario) {
            if (componente.getNumeroDeSerie().equals(numeroDeSerie)) {
                return componente;
            }
        }
        return null;
    }
}

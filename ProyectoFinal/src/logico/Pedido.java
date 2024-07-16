package logico;

import java.util.ArrayList;
import java.util.Date;

public class Pedido {
    private String id;
    private Cliente cliente;
    private ArrayList<Componente> componentes;
    private Date fecha;
    private float total;

    public Pedido(String id, Cliente cliente, ArrayList<Componente> componentes, Date fecha) {
        this.id = id;
        this.cliente = cliente;
        this.componentes = componentes;
        this.fecha = fecha;
        calcularTotal();
    }

    private void calcularTotal() {
        total = 0;
        for (Componente componente : componentes) {
            total += componente.getPrecio();
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<Componente> getComponentes() {
        return componentes;
    }

    public void setComponentes(ArrayList<Componente> componentes) {
        this.componentes = componentes;
        calcularTotal();
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public float getTotal() {
        return total;
    }
}

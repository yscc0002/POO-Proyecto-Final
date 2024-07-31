package logico;

import java.io.Serializable;

public class Combo implements Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	
	private int numComponentes;
    private double porcentajeDescuento;
    private String codigo;

    public Combo(int numComponentes, double porcentajeDescuento, String codigo) {
        this.numComponentes = numComponentes;
        this.porcentajeDescuento = porcentajeDescuento;
        this.codigo = codigo;
    }

    public int getNumComponentes() {
        return numComponentes;
    }

    public double getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(double porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public String getCodigo() {
        return codigo;
    }
}

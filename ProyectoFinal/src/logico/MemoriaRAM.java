package logico;

import java.io.Serializable;

public class MemoriaRAM extends Componente {
	private static final long serialVersionUID = 1L;
	private int cantMemoriaRAM;
	private String tipoMemoria;

	public MemoriaRAM(String numeroDeSerie, String marca, String modelo, float precio, int cantDisponible,
			int cantMemoriaRAM, String tipoMemoria) {
		super(numeroDeSerie, marca, modelo, precio, cantDisponible);
		this.cantMemoriaRAM = cantMemoriaRAM;
		this.tipoMemoria = tipoMemoria;
	}

	public int getCantMemoriaRAM() {
		return cantMemoriaRAM;
	}

	public void setCantMemoriaRAM(int cantMemoriaRAM) {
		this.cantMemoriaRAM = cantMemoriaRAM;
	}

	public String getTipoMemoria() {
		return tipoMemoria;
	}

	public void setTipoMemoria(String tipoMemoria) {
		this.tipoMemoria = tipoMemoria;
	}
}
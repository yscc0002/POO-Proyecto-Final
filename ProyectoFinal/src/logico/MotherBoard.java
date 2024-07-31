package logico;

import java.io.Serializable;
import java.util.ArrayList;

public class MotherBoard extends Componente {
	private static final long serialVersionUID = 1L;
	private String tipoDeConector;
	private String tipoDeMemoriaRAM;
	private String tipoDeConexionDiscoDuroMotherBoard;
	
	public MotherBoard(String numeroDeSerie, String marca, String modelo, float precio, int cantDisponible,
			String tipoDeConector, String tipoDeMemoriaRAM, String tipoDeConexionDiscoDuroMotherBoard) {
		super(numeroDeSerie, marca, modelo, precio, cantDisponible);
		this.tipoDeConector = tipoDeConector;
		this.tipoDeMemoriaRAM = tipoDeMemoriaRAM;
		this.tipoDeConexionDiscoDuroMotherBoard = tipoDeConexionDiscoDuroMotherBoard;
	}
	
	public String getTipoDeConector() {
		return tipoDeConector;
	}
	public void setTipoDeConector(String tipoDeConector) {
		this.tipoDeConector = tipoDeConector;
	}
	public String getTipoDeMemoriaRAM() {
		return tipoDeMemoriaRAM;
	}
	public void setTipoDeMemoriaRAM(String tipoDeMemoriaRAM) {
		this.tipoDeMemoriaRAM = tipoDeMemoriaRAM;
	}
	public String getTipoDeConexionDiscoDuroMotherBoard() {
		return tipoDeConexionDiscoDuroMotherBoard;
	}
	public void setTipoDeConexionDiscoDuroMotherBoard(String tipoDeConexionDiscoDuroMotherBoard) {
		this.tipoDeConexionDiscoDuroMotherBoard = tipoDeConexionDiscoDuroMotherBoard;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}

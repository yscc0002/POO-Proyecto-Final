package logico;

import java.awt.Component;
import java.util.ArrayList;

public class MotherBoard extends Component {
	private String tipoDeConector;
	private String tipoDeMemoriaRAM;
	private ArrayList<DiscoDuro> discoDurosAceptados;
	
	public MotherBoard(String tipoDeConector, String tipoDeMemoriaRAM, ArrayList<DiscoDuro> discoDurosAceptados) {
		super();
		this.tipoDeConector = tipoDeConector;
		this.tipoDeMemoriaRAM = tipoDeMemoriaRAM;
		this.discoDurosAceptados = discoDurosAceptados;
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
	public ArrayList<DiscoDuro> getDiscoDurosAceptados() {
		return discoDurosAceptados;
	}
	public void setDiscoDurosAceptados(ArrayList<DiscoDuro> discoDurosAceptados) {
		this.discoDurosAceptados = discoDurosAceptados;
	}
	

}

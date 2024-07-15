package logico;

import java.awt.Component;

public class MemoriaRAM extends Component {

	public MemoriaRAM(int cantMemoriaRAM) {
		super();
		this.cantMemoriaRAM = cantMemoriaRAM;
	}

	public int getCantMemoriaRAM() {
		return cantMemoriaRAM;
	}

	public void setCantMemoriaRAM(int cantMemoriaRAM) {
		this.cantMemoriaRAM = cantMemoriaRAM;
	}

	private int cantMemoriaRAM;
}

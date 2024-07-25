package logico;

public class MemoriaRAM extends Componente {
	
	
    private int cantMemoriaRAM;

    
	public MemoriaRAM(String numeroDeSerie, String marca, String modelo, float precio, int cantDisponible,
			int cantMemoriaRAM) {
		super(numeroDeSerie, marca, modelo, precio, cantDisponible);
		this.cantMemoriaRAM = cantMemoriaRAM;
	}

	public int getCantMemoriaRAM() {
		return cantMemoriaRAM;
	}

	public void setCantMemoriaRAM(int cantMemoriaRAM) {
		this.cantMemoriaRAM = cantMemoriaRAM;
	}
    
    

}

package logico;

import java.util.ArrayList;

public class Controladora {
	private ArrayList <DiscoDuro> losComponentes;

	public Controladora(ArrayList<DiscoDuro> losComponentes) {
		super();
		this.losComponentes = losComponentes;
	}

	public ArrayList<DiscoDuro> getLosComponentes() {
		return losComponentes;
	}

	public void setLosComponentes(ArrayList<DiscoDuro> losComponentes) {
		this.losComponentes = losComponentes;
	}

	
}

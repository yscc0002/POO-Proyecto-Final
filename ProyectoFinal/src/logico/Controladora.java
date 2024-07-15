package logico;

import java.util.ArrayList;

public class Controladora {

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

	private ArrayList <DiscoDuro> losComponentes;
	
}

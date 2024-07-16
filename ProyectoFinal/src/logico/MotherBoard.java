package logico;

import java.util.ArrayList;

public class MotherBoard extends Componente {
    private String tipoDeConector;
    private String tipoDeMemoriaRAM;
    private ArrayList<DiscoDuro> discoDurosAceptados;

    public MotherBoard(String numeroDeSerie, String marca, String modelo, float precio, int cantDisponible,
            String tipoDeConector, String tipoDeMemoriaRAM, ArrayList<DiscoDuro> discoDurosAceptados) {
        super(numeroDeSerie, marca, modelo, precio, cantDisponible);
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

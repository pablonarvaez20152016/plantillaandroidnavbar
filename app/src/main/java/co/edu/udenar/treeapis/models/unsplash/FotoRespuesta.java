package co.edu.udenar.treeapis.models.unsplash;

import java.util.ArrayList;

public class FotoRespuesta {
    private ArrayList<Foto> resultsfoto;
    public ArrayList<Foto> getResults() {
        return resultsfoto;
    }
    public void setResults(ArrayList<Foto> resultsfoto) {
        this.resultsfoto = resultsfoto;
    }
}

package co.edu.udenar.treeapis.apiservices;

import java.util.ArrayList;

import co.edu.udenar.treeapis.models.Escenarios_depor.Cancha;
import retrofit2.Call;
import retrofit2.http.GET;

public interface CanchaApiService {
    @GET("resource/vx6j-j5fb.json")
    Call<ArrayList<Cancha>> obtenerListacancha();
}

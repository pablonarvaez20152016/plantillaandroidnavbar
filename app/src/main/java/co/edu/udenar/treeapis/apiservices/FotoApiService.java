package co.edu.udenar.treeapis.apiservices;

import java.util.ArrayList;

import co.edu.udenar.treeapis.models.unsplash.Foto;
import retrofit2.Call;
import retrofit2.http.GET;

public interface FotoApiService {
    @GET("photos/?client_id=35faf6b0acb1067d36d06d2eadb25e9da77d484f67a5eef4fd04c748ebf47e7f")
    Call<ArrayList<Foto>> obtenerListafotos();
}

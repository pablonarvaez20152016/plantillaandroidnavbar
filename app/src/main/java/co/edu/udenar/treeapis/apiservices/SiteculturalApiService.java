package co.edu.udenar.treeapis.apiservices;

import java.util.ArrayList;

import co.edu.udenar.treeapis.models.siteculturales.Sitiocultural;
import retrofit2.Call;
import retrofit2.http.GET;

public interface SiteculturalApiService {
    @GET("resource/srjm-q6k9.json")
    Call<ArrayList<Sitiocultural>> obtenerListasitesCultural();
}

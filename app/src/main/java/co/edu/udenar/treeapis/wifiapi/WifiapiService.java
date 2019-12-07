package co.edu.udenar.treeapis.wifiapi;





import java.util.ArrayList;

import co.edu.udenar.treeapis.models.Wifi;
import retrofit2.Call;
import retrofit2.http.GET;

public interface WifiapiService {


    @GET("resource/pkga-gxrz.json")
    Call<ArrayList<Wifi>> obtenerListaWifi();
}

package co.edu.udenar.treeapis.ui.view1;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import java.util.ArrayList;

import co.edu.udenar.treeapis.R;
import co.edu.udenar.treeapis.apiservices.SiteculturalApiService;
import co.edu.udenar.treeapis.apiservices.WifiapiService;
import co.edu.udenar.treeapis.models.Wifi;
import co.edu.udenar.treeapis.models.siteculturales.Sitiocultural;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class View1Fragment extends Fragment {

    private View1ViewModel view1ViewModel;
    private Retrofit retrofitsites;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        view1ViewModel =
                ViewModelProviders.of(this).get(View1ViewModel.class);
        View root = inflater.inflate(R.layout.fragment_view1, container, false);
        final TextView textView = root.findViewById(R.id.text_gallery);
        view1ViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });



        retrofitsites=new Retrofit.Builder()
                .baseUrl("https://www.datos.gov.co/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        obtenerDatosSiteCultural();
        return root;
    }

    private void obtenerDatosSiteCultural() {
       SiteculturalApiService service = retrofitsites.create(SiteculturalApiService.class);
        Call<ArrayList<Sitiocultural>> SitesRespuestaCall = service.obtenerListasitesCultural();

        SitesRespuestaCall.enqueue(new Callback<ArrayList<Sitiocultural>>() {
            @Override
            public void onResponse(Call<ArrayList<Sitiocultural>> call, Response<ArrayList<Sitiocultural>> response) {
                if(response.isSuccessful()){
                    ArrayList listasites = response.body();
                    //mAdapter.setmDataSet(listawifi);


                    for(int i=0;i<listasites.size();i++)
                    {
                        Sitiocultural p = (Sitiocultural) listasites.get(i);


                        Log.i(TAG,"Sitio cultural: "+p.getEntidadCargo()+" Direccion: "+p.getDireccionsite());

                    }

                }else
                {
                    Log.e(TAG, "onResponse: "+response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Sitiocultural>> call, Throwable t) {
                Log.e(TAG," onFailure: "+t.getMessage());
            }
        });
    }
}
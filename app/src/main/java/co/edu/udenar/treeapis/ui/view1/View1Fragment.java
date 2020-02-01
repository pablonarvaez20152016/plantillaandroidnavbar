package co.edu.udenar.treeapis.ui.view1;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import co.edu.udenar.treeapis.R;
import co.edu.udenar.treeapis.adapters.SiteCulturalAdapter;
import co.edu.udenar.treeapis.adapters.Wifiadapter;
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
    private RecyclerView mRecyclerViewsite;
    public SiteCulturalAdapter mAdaptersite;
    private CardView cardViewsite;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        view1ViewModel =
                ViewModelProviders.of(this).get(View1ViewModel.class);
        View root = inflater.inflate(R.layout.fragment_view1, container, false);


        mRecyclerViewsite = (RecyclerView) root.findViewById(R.id.recycler_view_site);
        mRecyclerViewsite.setHasFixedSize(true);

        GridLayoutManager layoutManager = new GridLayoutManager(getContext(),2);
        mRecyclerViewsite.setLayoutManager(layoutManager);

        mAdaptersite = new SiteCulturalAdapter(getContext());
        mRecyclerViewsite.setAdapter(mAdaptersite);



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
                    mAdaptersite.setmDataSet(listasites);


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
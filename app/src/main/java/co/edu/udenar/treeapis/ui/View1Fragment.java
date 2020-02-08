package co.edu.udenar.treeapis.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import co.edu.udenar.treeapis.R;
import co.edu.udenar.treeapis.adapters.SiteCulturalAdapter;
import co.edu.udenar.treeapis.apiservices.SiteculturalApiService;
import co.edu.udenar.treeapis.models.siteculturales.Sitiocultural;
import co.edu.udenar.treeapis.ui.modelfragmensts.View1ViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static androidx.navigation.Navigation.findNavController;

public class View1Fragment extends Fragment {

    private View1ViewModel view1ViewModel;
    private Retrofit retrofitsites;
    private static String TAG="Sitios culturales => ";
    private RecyclerView mRecyclerViewsite;
    SiteCulturalAdapter mAdaptersite;
    private CardView cardViewsite;
    Button mapsite;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, final Bundle savedInstanceState) {

        view1ViewModel =
                ViewModelProviders.of(this).get(View1ViewModel.class);
        View root = inflater.inflate(R.layout.fragment_view1, container, false);


        mRecyclerViewsite = (RecyclerView) root.findViewById(R.id.recycler_view_site);
        mRecyclerViewsite.setHasFixedSize(true);

        GridLayoutManager layoutManager = new GridLayoutManager(getContext(),1);
        mRecyclerViewsite.setLayoutManager(layoutManager);

        mAdaptersite = new SiteCulturalAdapter(getContext());
        mRecyclerViewsite.setAdapter(mAdaptersite);











        retrofitsites=new Retrofit.Builder()
                .baseUrl("https://www.datos.gov.co/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        obtenerDatosSiteCultural();



//        mapsite=root.findViewById(R.id.mapasite);
//        mapsite.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Bundle bundle = new Bundle();
//                bundle.putInt("lat", 000);
//                Navigation.findNavController(v).navigate(R.id.action_nav_vista1_to_nav_vista3,bundle);
//
//            }
//        });
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
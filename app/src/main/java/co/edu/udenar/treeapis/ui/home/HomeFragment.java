package co.edu.udenar.treeapis.ui.home;

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
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import co.edu.udenar.treeapis.R;
import co.edu.udenar.treeapis.adapters.Wifiadapter;
import co.edu.udenar.treeapis.models.CoordenadasPuntosWifi;
import co.edu.udenar.treeapis.models.Wifi;
import co.edu.udenar.treeapis.ui.view1.View1Fragment;
import co.edu.udenar.treeapis.ui.view1.View1ViewModel;
import co.edu.udenar.treeapis.wifiapi.WifiapiService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private Retrofit retrofit;
    private static String TAG="wifi=> ";
    private RecyclerView mRecyclerView;
    Wifiadapter mAdapter;
    private CardView cardView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);


        mRecyclerView = (RecyclerView) root.findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);

        GridLayoutManager layoutManager = new GridLayoutManager(getContext(),2);
        mRecyclerView.setLayoutManager(layoutManager);

        mAdapter = new Wifiadapter(getContext());
        mRecyclerView.setAdapter(mAdapter);

        retrofit=new Retrofit.Builder()
                .baseUrl("https://www.datos.gov.co/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        obtenerDatos();
        return root;
    }
    private void obtenerDatos() {
        WifiapiService service = retrofit.create(WifiapiService.class);
        Call<ArrayList<Wifi>> WifiRespuestaCall = service.obtenerListaWifi();

        WifiRespuestaCall.enqueue(new Callback<ArrayList<Wifi>>() {
            @Override
            public void onResponse(Call<ArrayList<Wifi>> call, Response<ArrayList<Wifi>> response) {
                if(response.isSuccessful()){
                    ArrayList listawifi = response.body();
                    mAdapter.setmDataSet(listawifi);


                    for(int i=0;i<listawifi.size();i++)
                    {
                        Wifi p = (Wifi)listawifi.get(i);
                        CoordenadasPuntosWifi c =(CoordenadasPuntosWifi) p.getCoordenadasPuntosWifi();

                        Log.i(TAG,"Punto Wifi: "+p.getPuntoWifi()+" Direccion: "+p.getDireccion()+"\nCoordenadas:\n latitude"+c.getLatitude()+"\n longitud"+c.getLongitude());

                    }

                }else
                {
                    Log.e(TAG, "onResponse: "+response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Wifi>> call, Throwable t) {
                Log.e(TAG," onFailure: "+t.getMessage());
            }
        });


    }
}
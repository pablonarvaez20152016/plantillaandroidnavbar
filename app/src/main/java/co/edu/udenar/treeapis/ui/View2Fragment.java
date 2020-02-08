package co.edu.udenar.treeapis.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.takusemba.multisnaprecyclerview.MultiSnapRecyclerView;

import java.util.ArrayList;

import co.edu.udenar.treeapis.R;

import co.edu.udenar.treeapis.adapters.CanchaAdapter;
import co.edu.udenar.treeapis.apiservices.CanchaApiService;
import co.edu.udenar.treeapis.models.Escenarios_depor.Cancha;
import co.edu.udenar.treeapis.ui.modelfragmensts.View2ViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class View2Fragment extends Fragment {

    private View2ViewModel view2ViewModel;
    private Retrofit retrofitfoto;
    private static String TAG="Escenarios depor => ";
    private MultiSnapRecyclerView mRecyclerViewfoto,mRecyclerViewcancha2;
    CanchaAdapter mAdaptercancha;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        view2ViewModel =
                ViewModelProviders.of(this).get(View2ViewModel.class);
        View root = inflater.inflate(R.layout.fragment_view2, container, false);
        mRecyclerViewfoto =  root.findViewById(R.id.recycler_view_cancha);
        mRecyclerViewfoto.setHasFixedSize(true);

        mRecyclerViewcancha2 =  root.findViewById(R.id.recycler_cancha2);
        mRecyclerViewcancha2.setHasFixedSize(true);


        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(RecyclerView.HORIZONTAL);
        mRecyclerViewfoto.setLayoutManager(layoutManager);


        mAdaptercancha = new CanchaAdapter(getContext());
        mRecyclerViewfoto.setAdapter(mAdaptercancha);



        retrofitfoto=new Retrofit.Builder()
                .baseUrl("https://www.datos.gov.co/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        obtenerDatoscancha();
        obtenerDatoscancha2();
        return root;
    }

    private void obtenerDatoscancha() {

        CanchaApiService service = retrofitfoto.create(CanchaApiService.class);
        Call<ArrayList<Cancha>> FotosRespuestaCall = service.obtenerListacancha();

        FotosRespuestaCall.enqueue(new Callback<ArrayList<Cancha>>() {
            @Override
            public void onResponse(Call<ArrayList<Cancha>> call, Response<ArrayList<Cancha>> response) {
                if (response.isSuccessful()) {
                    ArrayList listacancha = response.body();
                    mAdaptercancha.setmDataSetcancha(listacancha);


                    for (int i = 0; i < listacancha.size(); i++) {
                        Cancha p = (Cancha) listacancha.get(i);


                        Log.i(TAG, "Comuna " + p.getComuna() + " Lugar " + p.getLocalizacion());

                    }

                } else {
                    Log.e(TAG, "onResponse: " + response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Cancha>> call, Throwable t) {
                Log.e(TAG," onFailure: "+t.getMessage());
            }
        });
    }

    private void obtenerDatoscancha2() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(RecyclerView.HORIZONTAL);
        mRecyclerViewcancha2.setLayoutManager(layoutManager);
        mRecyclerViewcancha2.setAdapter(mAdaptercancha);

        CanchaApiService service = retrofitfoto.create(CanchaApiService.class);
        Call<ArrayList<Cancha>> FotosRespuestaCall = service.obtenerListacancha();

        FotosRespuestaCall.enqueue(new Callback<ArrayList<Cancha>>() {
            @Override
            public void onResponse(Call<ArrayList<Cancha>> call, Response<ArrayList<Cancha>> response) {
                if (response.isSuccessful()) {
                    ArrayList listacancha2 = response.body();
                    mAdaptercancha.setmDataSetcancha(listacancha2);


                    for (int i = 0; i < listacancha2.size(); i++) {
                        Cancha p = (Cancha) listacancha2.get(i);


                        Log.i(TAG, "Comuna " + p.getComuna() + " Lugar " + p.getLocalizacion());

                    }

                } else {
                    Log.e(TAG, "onResponse: " + response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Cancha>> call, Throwable t) {
                Log.e(TAG," onFailure: "+t.getMessage());
            }
        });
    }
}

package co.edu.udenar.treeapis.ui;

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
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import co.edu.udenar.treeapis.R;
import co.edu.udenar.treeapis.adapters.FotoAdapter;
import co.edu.udenar.treeapis.apiservices.FotoApiService;
import co.edu.udenar.treeapis.models.unsplash.Foto;
import co.edu.udenar.treeapis.ui.modelfragmensts.View2ViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class View2Fragment extends Fragment {

    private View2ViewModel view2ViewModel;
    private Retrofit retrofitfoto;
    private static String TAG="fotos => ";
    private RecyclerView mRecyclerViewfoto;
    FotoAdapter mAdapterfoto;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        view2ViewModel =
                ViewModelProviders.of(this).get(View2ViewModel.class);
        View root = inflater.inflate(R.layout.fragment_view2, container, false);
        mRecyclerViewfoto = (RecyclerView) root.findViewById(R.id.recycler_view_foto);
        mRecyclerViewfoto.setHasFixedSize(true);
        Log.e("creo la vista", "o" );

        GridLayoutManager layoutManager = new GridLayoutManager(getContext(),1);
        mRecyclerViewfoto.setLayoutManager(layoutManager);

        mAdapterfoto = new FotoAdapter(getContext());
        mRecyclerViewfoto.setAdapter(mAdapterfoto);


        retrofitfoto=new Retrofit.Builder()
                .baseUrl("https://api.unsplash.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        obtenerDatosFotos();
        return root;
    }

    private void obtenerDatosFotos() {

        FotoApiService service = retrofitfoto.create(FotoApiService.class);
        Call<ArrayList<Foto>> FotosRespuestaCall = service.obtenerListafotos();

        FotosRespuestaCall.enqueue(new Callback<ArrayList<Foto>>() {
            @Override
            public void onResponse(Call<ArrayList<Foto>> call, Response<ArrayList<Foto>> response) {
                if (response.isSuccessful()) {
                    ArrayList listafotos = response.body();
                    mAdapterfoto.setmDataSet(listafotos);


                    for (int i = 0; i < listafotos.size(); i++) {
                        Foto p = (Foto) listafotos.get(i);


                        Log.i(TAG, "FotosUrls " + p.getUrls() + " Direccion: " + p.getDescription());

                    }

                } else {
                    Log.e(TAG, "onResponse: " + response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Foto>> call, Throwable t) {
                Log.e(TAG," onFailure: "+t.getMessage());
            }
        });
    }
}

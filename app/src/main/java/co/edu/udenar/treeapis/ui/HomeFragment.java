package co.edu.udenar.treeapis.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import co.edu.udenar.treeapis.R;

import static androidx.navigation.Navigation.createNavigateOnClickListener;
import static androidx.navigation.Navigation.findNavController;

public class HomeFragment extends Fragment {

//    private HomeViewModel mViewModel;
    private Button btnwifi,btnculturales,btnmapa;


    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View vistahome=inflater.inflate(R.layout.home_fragment, container, false);

        btnwifi=vistahome.findViewById(R.id.btnwifi);
        btnculturales=vistahome.findViewById(R.id.btnculturales);
        btnmapa=vistahome.findViewById(R.id.btnmapa);


        btnwifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findNavController(v).navigate(R.id.action_nav_home_to_nav_vista0);
            }
        });

        btnculturales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findNavController(v).navigate(R.id.action_nav_home_to_nav_vista1);
            }
        });

        btnmapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findNavController(v).navigate(R.id.action_nav_home_to_nav_vista3);
            }
        });


        return vistahome;
    }


}

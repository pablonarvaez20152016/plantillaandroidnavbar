package co.edu.udenar.treeapis.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapController;
import org.osmdroid.views.MapView;

import co.edu.udenar.treeapis.R;
import co.edu.udenar.treeapis.ui.modelfragmensts.View3ViewModel;

public class View3Fragment extends Fragment {

    private View3ViewModel view3ViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        view3ViewModel =
                ViewModelProviders.of(this).get(View3ViewModel.class);
        View root = inflater.inflate(R.layout.fragment_view3, container, false);
        GeoPoint madrid = new GeoPoint(1.234167, -77.285278);

        MapView myOpenMapView = (MapView) root.findViewById(R.id.mapview);
        myOpenMapView.setBuiltInZoomControls(true);
        MapController myMapController = (MapController) myOpenMapView.getController();
        myMapController.setCenter(madrid);
        myMapController.setZoom(15);

        myOpenMapView.setMultiTouchControls(true);
        return root;
    }

//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//        if (getArguments() != null) {
//            int drawableId = View3Fragment.fromBundle(getArguments().getString())
//
//        }
//    }
}
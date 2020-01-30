package co.edu.udenar.treeapis.ui.view3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapController;
import org.osmdroid.views.MapView;

import co.edu.udenar.treeapis.R;

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
        myMapController.setZoom(20);

        myOpenMapView.setMultiTouchControls(true);
        return root;
    }
}
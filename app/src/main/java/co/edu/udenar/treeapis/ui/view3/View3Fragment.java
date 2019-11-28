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

import co.edu.udenar.treeapis.R;

public class View3Fragment extends Fragment {

    private View3ViewModel view3ViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        view3ViewModel =
                ViewModelProviders.of(this).get(View3ViewModel.class);
        View root = inflater.inflate(R.layout.fragment_view3, container, false);
        final TextView textView = root.findViewById(R.id.text_share);
        view3ViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}
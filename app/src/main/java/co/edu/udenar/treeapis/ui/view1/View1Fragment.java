package co.edu.udenar.treeapis.ui.view1;

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

public class View1Fragment extends Fragment {

    private View1ViewModel view1ViewModel;

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
        return root;
    }
}
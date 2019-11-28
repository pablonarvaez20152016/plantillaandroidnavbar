package co.edu.udenar.treeapis.ui.view2;

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

public class View2Fragment extends Fragment {

    private View2ViewModel view2ViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        view2ViewModel =
                ViewModelProviders.of(this).get(View2ViewModel.class);
        View root = inflater.inflate(R.layout.fragment_view2, container, false);
        final TextView textView = root.findViewById(R.id.text_send);
        view2ViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}
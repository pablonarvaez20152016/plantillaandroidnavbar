package co.edu.udenar.treeapis.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import co.edu.udenar.treeapis.R;
import co.edu.udenar.treeapis.models.Wifi;
import co.edu.udenar.treeapis.ui.view2.View2ViewModel;


public class Wifiadapter extends RecyclerView.Adapter<Wifiadapter.ViewHolder> {
    private ArrayList<Wifi> mDataSet;
    private Context context;


    // Obtener referencias de los componentes visuales para cada elemento
    // Es decir, referencias de los EditText, TextViews, Buttons
    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tvname,tvdireccion,tvlatitude,tvlongitud;
        public ImageView ivwifi;
        public ViewHolder(View v) {
            super(v);
            tvname=v.findViewById(R.id.tvwifi);
            tvdireccion=v.findViewById(R.id.tvdireccion);
            tvlatitude=v.findViewById(R.id.tvlatitude);
            tvlongitud=v.findViewById(R.id.tvlongitud);
            ivwifi=v.findViewById(R.id.ivwifi);
        }
    }

    // Este es nuestro constructor (puede variar según lo que queremos mostrar)
    public Wifiadapter(Context context) {
        this.context=context;
        mDataSet= new ArrayList<>();
    }

    public void setmDataSet(ArrayList<Wifi> mDataSet) {
        this.mDataSet = mDataSet;
        notifyDataSetChanged();
    }

    // El layout manager invoca este método
    // para renderizar cada elemento del RecyclerView
    @Override
    public Wifiadapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        // Creamos una nueva vista
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardviewwifi, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        holder.tvname.setText(mDataSet.get(position).getPuntoWifi());
        Picasso.with(context)
                .load("https://source.unsplash.com/random/?{"+mDataSet.get(position).getPuntoWifi()+"},{Colombia}")
                .into(holder.ivwifi);
        holder.tvdireccion.setText(mDataSet.get(position).getDireccion());
        holder.tvlatitude.setText(mDataSet.get(position).getCoordenadasPuntosWifi().getLatitude());
        holder.tvlongitud.setText(mDataSet.get(position).getCoordenadasPuntosWifi().getLongitude());


    }



    // Método que define la cantidad de elementos del RecyclerView
    // Puede ser más complejo (por ejemplo si implementamos filtros o búsquedas)
    @Override
    public int getItemCount() {
        return mDataSet.size();
    }
}
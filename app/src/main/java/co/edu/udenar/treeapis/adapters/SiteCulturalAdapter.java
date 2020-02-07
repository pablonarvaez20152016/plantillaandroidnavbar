package co.edu.udenar.treeapis.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import co.edu.udenar.treeapis.R;
import co.edu.udenar.treeapis.models.siteculturales.Sitiocultural;

public class SiteCulturalAdapter extends RecyclerView.Adapter<SiteCulturalAdapter.ViewHolder>{
    private ArrayList<Sitiocultural> mDataSetsite;
    private Context context;


    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tventidadsitio,tvdirsitio,representante,telefono,correo;
        public ImageView ivsitio;
        public Button mapasite;
        public ViewHolder(View v) {
            super(v);
            tventidadsitio=v.findViewById(R.id.sitio);
            tvdirsitio=v.findViewById(R.id.dirsitio);
            representante=v.findViewById(R.id.representante);
            telefono=v.findViewById(R.id.telefono);
            correo=v.findViewById(R.id.correo);
            ivsitio=v.findViewById(R.id.imagensite);
        }
    }

    public SiteCulturalAdapter(Context context) {
        this.context=context;
        mDataSetsite= new ArrayList<>();

    }
    public void setmDataSet(ArrayList<Sitiocultural> mDataSetsite) {
        this.mDataSetsite = mDataSetsite;
        notifyDataSetChanged();
    }


    @Override
    public SiteCulturalAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                             int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardviewsites, parent, false);

        return new ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull SiteCulturalAdapter.ViewHolder holder, int position) {
        holder.tventidadsitio.setText(mDataSetsite.get(position).getEntidadCargo());
        holder.tvdirsitio.setText(mDataSetsite.get(position).getDireccionsite());
        holder.representante.setText(mDataSetsite.get(position).getRepresentante());
        holder.telefono.setText(mDataSetsite.get(position).getTelefono());
        holder.correo.setText(mDataSetsite.get(position).getCorreo());
        Picasso.with(context)
                .load("https://source.unsplash.com/random/?{"+mDataSetsite.get(position).getEntidadCargo()+"},{Colombia}")
                .into(holder.ivsitio);
        holder.tvdirsitio.setText(mDataSetsite.get(position).getDireccionsite());


    }

    @Override
    public int getItemCount() {
        return mDataSetsite.size();
    }
}

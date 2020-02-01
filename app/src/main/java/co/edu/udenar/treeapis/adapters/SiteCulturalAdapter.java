package co.edu.udenar.treeapis.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import co.edu.udenar.treeapis.R;
import co.edu.udenar.treeapis.models.siteculturales.Sitiocultural;

public class SiteCulturalAdapter extends RecyclerView.Adapter<SiteCulturalAdapter.ViewHolder>{
    private Context context;
    private ArrayList<Sitiocultural> mDataSetsite;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tventidadsitio,tvdirsitio;
        public ImageView ivsitio;
        public ViewHolder(View v) {
            super(v);
            tventidadsitio=v.findViewById(R.id.sitio);
            tvdirsitio=v.findViewById(R.id.dirsitio);
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

    @NonNull
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
        Picasso.with(context)
                .load("https://source.unsplash.com/random/?{"+mDataSetsite.get(position).getEntidadCargo()+"},{Colombia}")
                .into(holder.ivsitio);
        holder.tvdirsitio.setText(mDataSetsite.get(position).getDireccionsite());


    }

    @Override
    public int getItemCount() {
        return 0;
    }
}

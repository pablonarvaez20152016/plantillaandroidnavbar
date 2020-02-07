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
import co.edu.udenar.treeapis.models.unsplash.Foto;

public class FotoAdapter extends RecyclerView.Adapter<FotoAdapter.ViewHolder> {
    private ArrayList<Foto> mDataSetfoto;
    private Context context;



    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView idfoto ;
        public ImageView espaciofoto;

        public ViewHolder(View v) {
            super(v);
            idfoto=v.findViewById(R.id.idfoto);
            espaciofoto=v.findViewById(R.id.espaciofoto);
        }
    }



    public FotoAdapter(Context context) {
        this.context=context;
        mDataSetfoto= new ArrayList<>();

    }
    public void setmDataSet(ArrayList<Foto> mDataSetfoto) {
        this.mDataSetfoto = mDataSetfoto;
        notifyDataSetChanged();
    }


    @Override
    public FotoAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                             int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardviewview2, parent, false);

        return new ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull FotoAdapter.ViewHolder holder, int position) {
        holder.idfoto.setText(mDataSetfoto.get(position).getId());

        Picasso.with(context)
                .load("https://source.unsplassh.com/random/?{"+mDataSetfoto.get(position)+"},{Colombia}")
                .into(holder.espaciofoto);



    }

    @Override
    public int getItemCount() {
        return mDataSetfoto.size();
    }
}

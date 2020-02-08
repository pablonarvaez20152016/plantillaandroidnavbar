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
import co.edu.udenar.treeapis.models.Escenarios_depor.Cancha;

public class CanchaAdapter  extends RecyclerView.Adapter<CanchaAdapter.ViewHolder> {
    private ArrayList<Cancha> mDataSetcancha;
    private Context context;


    // Obtener referencias de los componentes visuales para cada elemento
// Es decir, referencias de los EditText, TextViews, Buttons
    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textcancha,textcomuna,textlocalizacion,textmatricula,textadmin;
        public ImageView imgcancha;

        public ViewHolder(View v) {
            super(v);
            textcancha = v.findViewById(R.id.textcancha);
            textcomuna = v.findViewById(R.id.comuna);
            textlocalizacion = v.findViewById(R.id.localizacion);
            textmatricula= v.findViewById(R.id.matricula);
            textadmin = v.findViewById(R.id.admin);
            imgcancha = v.findViewById(R.id.imgcancha);

        }
    }

    // Este es nuestro constructor (puede variar según lo que queremos mostrar)
    public CanchaAdapter(Context context) {
        this.context = context;
        mDataSetcancha = new ArrayList<>();
    }

    public void setmDataSetcancha(ArrayList<Cancha> mDataSetcancha) {
        this.mDataSetcancha = mDataSetcancha;
        notifyDataSetChanged();
    }

    // El layout manager invoca este método
    // para renderizar cada elemento del RecyclerView
    @Override
    public CanchaAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                       int viewType) {
        // Creamos una nueva vista
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardviewview2, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        holder.textcancha.setText(mDataSetcancha.get(position).getNombre());
        holder.textcomuna.setText(mDataSetcancha.get(position).getComuna());
        holder.textlocalizacion.setText(mDataSetcancha.get(position).getLocalizacion());
        holder.textmatricula.setText(mDataSetcancha.get(position).getMatriculaInmobiliaria());
        holder.textadmin.setText(mDataSetcancha.get(position).getAdminstracion());
        Picasso.with(context)
                .load("https://source.unsplash.com/random/?{" + mDataSetcancha.get(position).getNombre() + "},{"+ mDataSetcancha.get(position).getLocalizacion() +"}")
                .into(holder.imgcancha);


    }


    // Método que define la cantidad de elementos del RecyclerView
    // Puede ser más complejo (por ejemplo si implementamos filtros o búsquedas)
    @Override
    public int getItemCount() {
        return mDataSetcancha.size();
    }

}
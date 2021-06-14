package com.example.hidratada;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hidratada.model.Planta;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class PlantaAdapter extends RecyclerView.Adapter<PlantaAdapter.PlantaViewHolder> {

    private List<Planta> plantas;
    public PlantaAdapter(List<Planta> plantas) {
        this.plantas = plantas;
    }

    @NonNull
    @Override
    public PlantaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.planta_item, parent, false);
        return new PlantaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlantaViewHolder holder, int position) {
        Planta planta = plantas.get(position);
        holder.bind(planta);
    }

    @Override
    public int getItemCount() {
        return plantas.size();
    }

    class PlantaViewHolder extends RecyclerView.ViewHolder {

        TextView txtNome;
        public PlantaViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNome = itemView.findViewById(R.id.txt_nome_planta);
        }

        public void bind(Planta planta){
            txtNome.setText(planta.getNome());
        }
    }

}

package com.example.hidratada;

import android.graphics.Color;
import android.os.Build;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
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

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(@NonNull PlantaViewHolder holder, int position) {
        Planta planta = plantas.get(position);
        holder.bind(planta);
    }

    @Override
    public int getItemCount() {
        return plantas.size();
    }

    public  List<Planta> getPlantas() {
        return plantas;
    }

    class PlantaViewHolder extends RecyclerView.ViewHolder {

        TextView txtNome, txtIcone;
        ImageView imgNvAgua1, imgNvAgua2, imgNvAgua3, imgNvAgua4;

        public PlantaViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNome = itemView.findViewById(R.id.txt_nome_planta);
            txtIcone = itemView.findViewById(R.id.txt_icone);
            imgNvAgua1 = itemView.findViewById(R.id.img_nivel_agua_1);
            imgNvAgua2 = itemView.findViewById(R.id.img_nivel_agua_2);
            imgNvAgua3 = itemView.findViewById(R.id.img_nivel_agua_3);
            imgNvAgua4 = itemView.findViewById(R.id.img_nivel_agua_4);
        }

        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        public void bind(Planta planta){
            txtNome.setText(planta.getNome());
            txtIcone.setText(Character.toString(planta.getNome().charAt(0)).toUpperCase());
            switch (planta.getQuantidadeDeAgua()) {
                case 4:
                    imgNvAgua4.setColorFilter(ContextCompat.getColor(imgNvAgua4.getContext(), R.color.floresta_umida_variante), android.graphics.PorterDuff.Mode.SRC_IN);
                case 3:
                    imgNvAgua3.setColorFilter(ContextCompat.getColor(imgNvAgua3.getContext(), R.color.floresta_umida_variante), android.graphics.PorterDuff.Mode.SRC_IN);
                case 2:
                    imgNvAgua2.setColorFilter(ContextCompat.getColor(imgNvAgua2.getContext(), R.color.floresta_umida_variante), android.graphics.PorterDuff.Mode.SRC_IN);
                case 1:
                    imgNvAgua1.setColorFilter(ContextCompat.getColor(imgNvAgua1.getContext(), R.color.floresta_umida_variante), android.graphics.PorterDuff.Mode.SRC_IN);

                default:
            }
        }
    }

}

package com.example.hidratada;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ArrayAdapter;

import com.example.hidratada.model.Intervalo;
import com.example.hidratada.model.Planta;
import com.example.hidratada.model.PlantaList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private PlantaAdapter adapterPlanta;
    private RecyclerView rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Planta> plantas = PlantaList.getFakePlantas();

        adapterPlanta = new PlantaAdapter(plantas);

        rv = findViewById(R.id.recycler_view_main);
        rv.setAdapter(adapterPlanta);


        Planta novaPlanta =  (Planta) getIntent().getSerializableExtra("ch_nova_planta");
        if (novaPlanta != null) {

            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    adapterPlanta.getPlantas().add(0, novaPlanta);
                    adapterPlanta.notifyItemInserted(0);
                    rv.scrollToPosition(0);

                }
            }, 600);
        }

        ItemTouchHelper helper = new ItemTouchHelper(
                new ItemTouchHandler(ItemTouchHelper.UP | ItemTouchHelper.DOWN, ItemTouchHelper.LEFT)
        );

        helper.attachToRecyclerView(rv);
    }

    public void addPlanta(View view){
        Intent it = new Intent(MainActivity.this, PlantaManager.class);
        startActivity(it);
        /*
    adapterPlanta.getPlantas().add(0, new Planta("laurinha", new Intervalo(true, 2), 3));
    adapterPlanta.notifyItemInserted(0);
    rv.scrollToPosition(0);
    */
    }

    private class ItemTouchHandler extends ItemTouchHelper.SimpleCallback {

        public ItemTouchHandler(int dragDirs, int swipeDirs) {
            super(dragDirs, swipeDirs);
        }

        @Override
        public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
          int from = viewHolder.getAdapterPosition();
          int to = target.getAdapterPosition();

            Collections.swap(adapterPlanta.getPlantas(), from, to);
          adapterPlanta.notifyItemMoved(from, to);


            return true;
        }

        @Override
        public void onSwiped( RecyclerView.ViewHolder viewHolder, int direction) {
    adapterPlanta.getPlantas().remove(viewHolder.getAdapterPosition());
    adapterPlanta.notifyItemRemoved(viewHolder.getAdapterPosition());
        }
    }

}
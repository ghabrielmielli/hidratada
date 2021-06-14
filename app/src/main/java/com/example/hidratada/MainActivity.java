package com.example.hidratada;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import com.example.hidratada.model.Intervalo;
import com.example.hidratada.model.Planta;
import com.example.hidratada.model.PlantaList;

import java.util.ArrayList;
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


    }

    public void addPlanta(View view){
    adapterPlanta.getPlantas().add(0, new Planta("laurinha", new Intervalo(true, 2), 3));
    adapterPlanta.notifyItemInserted(0);
    rv.scrollToPosition(0);
    }
}
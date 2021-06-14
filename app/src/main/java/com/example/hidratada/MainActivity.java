package com.example.hidratada;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.example.hidratada.model.Planta;
import com.example.hidratada.model.PlantaList;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Planta> plantas = PlantaList.getFakePlantas();

        PlantaAdapter adapterPlanta = new PlantaAdapter(plantas);

        RecyclerView rv = findViewById(R.id.recycler_view_main);
        rv.setAdapter(adapterPlanta);


    }
}
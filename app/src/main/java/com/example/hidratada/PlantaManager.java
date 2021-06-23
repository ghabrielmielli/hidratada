package com.example.hidratada;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.hidratada.model.Intervalo;
import com.example.hidratada.model.Planta;

import java.util.ArrayList;

public class PlantaManager extends AppCompatActivity {


    EditText edtNome, edtFrequencia;
    ImageView imgNvAgua1, imgNvAgua2, imgNvAgua3, imgNvAgua4;
    TextView txtFrequenciaPt1, txtFrequenciaPt2;

    CheckBox checkboxTodoDia;

    Boolean editMode = false;
    Planta editModePlanta;
    Toolbar toolbar;

    //Valores:
    int quantidadeAgua = 1;

    //DBHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planta_manager);

        bindElements();
        setListeners();
    }

    private void bindElements() {
        edtNome = findViewById(R.id.edt_nome);
        edtFrequencia = findViewById(R.id.edt_frequencia);
        imgNvAgua1 = findViewById(R.id.img_nivel_agua_1);
        imgNvAgua2 = findViewById(R.id.img_nivel_agua_2);
        imgNvAgua3 = findViewById(R.id.img_nivel_agua_3);
        imgNvAgua4 = findViewById(R.id.img_nivel_agua_4);
        txtFrequenciaPt1 = findViewById(R.id.txt_edt_frequencia_1);
        txtFrequenciaPt2 = findViewById(R.id.txt_edt_frequencia_2);
        checkboxTodoDia = findViewById(R.id.checkbox_todo_dia);

    }

    private void setListeners() {
        imgNvAgua1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mudarQuantidadeAgua(1);
            }
        });
        imgNvAgua2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mudarQuantidadeAgua(2);
            }
        });
        imgNvAgua3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mudarQuantidadeAgua(3);
            }
        });
        imgNvAgua4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mudarQuantidadeAgua(4);
            }
        });

    }

    public void voltar(View view) {
        finish();
    }

    public void mudarQuantidadeAgua(int nivel) {
        quantidadeAgua = nivel;
        switch (nivel) {
            case 4:
                imgNvAgua4.setColorFilter(ContextCompat.getColor(imgNvAgua4.getContext(), R.color.floresta_umida_variante), android.graphics.PorterDuff.Mode.SRC_IN);
                imgNvAgua3.setColorFilter(ContextCompat.getColor(imgNvAgua3.getContext(), R.color.floresta_umida_variante), android.graphics.PorterDuff.Mode.SRC_IN);
                imgNvAgua2.setColorFilter(ContextCompat.getColor(imgNvAgua2.getContext(), R.color.floresta_umida_variante), android.graphics.PorterDuff.Mode.SRC_IN);
                break;
            case 3:
                imgNvAgua4.setColorFilter(ContextCompat.getColor(imgNvAgua4.getContext(), R.color.alcaparra), android.graphics.PorterDuff.Mode.SRC_IN);
                imgNvAgua3.setColorFilter(ContextCompat.getColor(imgNvAgua3.getContext(), R.color.floresta_umida_variante), android.graphics.PorterDuff.Mode.SRC_IN);
                imgNvAgua2.setColorFilter(ContextCompat.getColor(imgNvAgua2.getContext(), R.color.floresta_umida_variante), android.graphics.PorterDuff.Mode.SRC_IN);
                break;
            case 2:
                imgNvAgua4.setColorFilter(ContextCompat.getColor(imgNvAgua4.getContext(), R.color.alcaparra), android.graphics.PorterDuff.Mode.SRC_IN);
                imgNvAgua3.setColorFilter(ContextCompat.getColor(imgNvAgua3.getContext(), R.color.alcaparra), android.graphics.PorterDuff.Mode.SRC_IN);
                imgNvAgua2.setColorFilter(ContextCompat.getColor(imgNvAgua2.getContext(), R.color.floresta_umida_variante), android.graphics.PorterDuff.Mode.SRC_IN);
                break;
            case 1:
                imgNvAgua4.setColorFilter(ContextCompat.getColor(imgNvAgua4.getContext(), R.color.alcaparra), android.graphics.PorterDuff.Mode.SRC_IN);
                imgNvAgua3.setColorFilter(ContextCompat.getColor(imgNvAgua3.getContext(), R.color.alcaparra), android.graphics.PorterDuff.Mode.SRC_IN);
                imgNvAgua2.setColorFilter(ContextCompat.getColor(imgNvAgua2.getContext(), R.color.alcaparra), android.graphics.PorterDuff.Mode.SRC_IN);
                break;

            default:
        }
    }

    public void salvar(View view) {
        String nome = edtNome.getText().toString();
        int frequencia = Integer.parseInt( edtFrequencia.getText().toString());
        boolean isTodoDia = checkboxTodoDia.isChecked();

        Planta planta = new Planta(nome,new Intervalo(isTodoDia,frequencia), quantidadeAgua);

        Intent it = new Intent(PlantaManager.this, MainActivity.class);
        it.putExtra("ch_nova_planta",planta);
        startActivity(it);
    }
}
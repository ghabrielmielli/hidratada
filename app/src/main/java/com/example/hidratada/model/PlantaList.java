package com.example.hidratada.model;

import java.util.ArrayList;
import java.util.List;

public class PlantaList {
    public static List<Planta> getFakePlantas(){
        List<Planta> plantas = new ArrayList<>();
        plantas.add(new Planta("jacira", new Intervalo(false, 1), 3));
        plantas.add(new Planta("luana", new Intervalo(true, 2), 4));
        plantas.add(new Planta("matilde", new Intervalo(true, 5), 1));
        plantas.add(new Planta("pirineia", new Intervalo(false, 2), 3));
        plantas.add(new Planta("jula", new Intervalo(false, 3), 2));
        return plantas;
    }
}

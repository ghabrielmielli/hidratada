package com.example.hidratada;

public class Intervalo {
    private boolean isTodoDia;
    private int frequencia; // a cada x dias ou x vezes por dia

    public Intervalo(boolean isTodoDia, int frequencia) {
        this.isTodoDia = isTodoDia;
        this.frequencia = frequencia;
    }

    public boolean isTodoDia() {
        return isTodoDia;
    }

    public void setTodoDia(boolean todoDia) {
        isTodoDia = todoDia;
    }

    public int getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(int frequencia) {
        this.frequencia = frequencia;
    }
}

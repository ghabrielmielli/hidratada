package com.example.hidratada;

public class Planta {
    private int id;
    private String nome;
    private Intervalo quandoMolhar;
    private boolean isHidratada;

    public Planta(String nome, Intervalo quandoMolhar) {
        this.id = (int) Math.random() * 10000;
        this.nome = nome;
        this.quandoMolhar = quandoMolhar;
        this.isHidratada = false;
    }

    @Override
    public String toString() {
        return "Planta{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", quandoMolhar=" + quandoMolhar +
                ", isHidratada=" + isHidratada +
                '}';
    }

    public Planta(int id, String nome, Intervalo quandoMolhar, boolean isHidratada) {
        this.id = id;
        this.nome = nome;
        this.quandoMolhar = quandoMolhar;
        this.isHidratada = isHidratada;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Intervalo getQuandoMolhar() {
        return quandoMolhar;
    }

    public void setQuandoMolhar(Intervalo quandoMolhar) {
        this.quandoMolhar = quandoMolhar;
    }

    public boolean isHidratada() {
        return isHidratada;
    }

    public void setHidratada(boolean hidratada) {
        isHidratada = hidratada;
    }

    public int getId() {
        return id;
    }
}

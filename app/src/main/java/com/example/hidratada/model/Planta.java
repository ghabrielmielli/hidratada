package com.example.hidratada.model;

import java.io.Serializable;

public class Planta implements Serializable {
    private int id;
    private String nome;
    private Intervalo quandoMolhar;
    private boolean isHidratada;
    private int quantidadeDeAgua; // quanto de agua deve usar pra molhar ela


    public Planta(String nome, Intervalo quandoMolhar, int quantidadeDeAgua) {
        this.id = (int) Math.random() * 10000;
        this.nome = nome;
        this.quandoMolhar = quandoMolhar;
        this.isHidratada = false;
        this.quantidadeDeAgua = quantidadeDeAgua;
    }

    public Planta(int id, String nome, Intervalo quandoMolhar, boolean isHidratada) {
        this.id = id;
        this.nome = nome;
        this.quandoMolhar = quandoMolhar;
        this.isHidratada = isHidratada;
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


    public int getQuantidadeDeAgua() {
        return quantidadeDeAgua;
    }

    public void setQuantidadeDeAgua(int quantidadeDeAgua) {
        this.quantidadeDeAgua = quantidadeDeAgua;
    }

}

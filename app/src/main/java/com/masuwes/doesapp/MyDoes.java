package com.masuwes.doesapp;

public class MyDoes {
    String titledoes;
    String descdoes;
    String datedoes;
    String keydoes;

    public MyDoes() {
    }

    public MyDoes(String titledoes, String descdoes, String datedoes, String keydoes) {
        this.titledoes = titledoes;
        this.descdoes = descdoes;
        this.datedoes = datedoes;
        this.keydoes = keydoes;
    }

    public String getKeydoes() {
        return keydoes;
    }

    public void setKeydoes(String keydoes) {
        this.keydoes = keydoes;
    }

    public String getTitledoes() {
        return titledoes;
    }

    public void setTitledoes(String titledoes) {
        this.titledoes = titledoes;
    }

    public String getDescdoes() {
        return descdoes;
    }

    public void setDescdoes(String descdoes) {
        this.descdoes = descdoes;
    }

    public String getDatedoes() {
        return datedoes;
    }

    public void setDatedoes(String datedoes) {
        this.datedoes = datedoes;
    }
}

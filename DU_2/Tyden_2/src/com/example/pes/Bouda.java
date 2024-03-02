package com.example.pes;

public class Bouda {
    private int vyska;
    private int sirka;
    private int hloubka;


    public int getVyska() {
        return vyska;
    }

    public void setVyska(int vyska) {
        this.vyska = vyska;
    }

    public int getSirka() {
        return sirka;
    }

    public void setSirka(int sirka) {
        this.sirka = sirka;
    }

    public int getHloubka() {
        return hloubka;
    }

    public void setHloubka(int hloubka) {
        this.hloubka = hloubka;
    }

    public int getObjem(){
        int objem;
        objem = hloubka * vyska * sirka;
        return objem;
    }
}

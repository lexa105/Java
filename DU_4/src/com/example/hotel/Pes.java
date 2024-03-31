package com.example.hotel;
import java.util.Random;



public class Pes {

    private static final String VYCHOZI_BARVA_PSA = "- barva je tajná -";

    private String jmeno;
    private String barva;
    private int delka;
    private Bouda bouda;


    public Pes(String jmeno, int delka) {
        this(jmeno, delka, VYCHOZI_BARVA_PSA);
    }
    public Pes(String jmeno, int delka, String barva) {
        this.jmeno = jmeno;
        this.delka = delka;
        this.barva = barva;
        this.bouda = null;
    }


    public String getJmeno() {
        return jmeno;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public String getBarva() {
        return barva;
    }

    public void setBarva(String barva) {
        this.barva = barva;
    }

    public int getDelka() {
        return delka;
    }

    public void setDelka(int delka) {
        this.delka = delka;
    }

    public String zastekej() {
        Random rand = new Random();
        int upperBound = 1;
        int int_random = rand.nextInt(upperBound);
        String stekot = "Haf haf";
        String stekot_eng = "Woof woof";

        if(int_random == 0) {
            return stekot;
        } else {
            return stekot_eng;
        }
    }
}

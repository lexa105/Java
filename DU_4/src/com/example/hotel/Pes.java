package com.example.hotel;

public class Pes {

    private static final String VYCHOZI_BARVA_PSA = "- barva je tajná -";

    private String jmeno;
    private String barva;
    private int delka;

//    public Pes(String jmeno, int delka){
//        this(jmeno, delka, VYCHOZI_BARVA_PSA);
//    }

    public Pes(String jmeno, String barva, int delka) {
        this.jmeno = jmeno;
        this.barva = barva;
        this.delka = delka;
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
        String stekot = "Haf haf";

        return stekot;
    }
}

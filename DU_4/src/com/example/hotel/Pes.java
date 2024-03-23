package com.example.hotel;

public class Pes {

    private static final String VYCHOZI_BARVA_PSA = "- barva je tajná -";

    private String jmeno;
    private String barva;
    private int delka;

    public Pes(String jmeno, int delka){
        this(jmeno, delka, VYCHOZI_BARVA_PSA);
    }

    public Pes(String jmeno, String barva, int delka) {
        this.jmeno = jmeno;
        this.barva = barva;
        this.delka = delka;

    }

}

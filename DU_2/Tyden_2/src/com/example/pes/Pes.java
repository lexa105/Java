package com.example.pes;

public class Pes {

    public Bouda bouda;
    public String jmeno;
    public String barva;
    public int delka;
    public boolean zableseny;

    private static final boolean DEFAULT_ZABLESENI = false;


    public Pes(Bouda bouda, String jmeno, String barva, int delka, boolean zableseny) {
        this.bouda = bouda;
        this.jmeno = jmeno;
        this.barva = barva;
        this.delka = delka;
        this.zableseny = true;
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

    public boolean isZableseny() {
        return zableseny;
    }

    public void setZableseny(boolean zableseny) {
        this.zableseny = zableseny;
    }

    public int getObjemBoudy() {
        int objem = bouda.getObjem();
        return objem;
    }

    public String zastekej() {
        String steknuti = "Haf haf";
        return steknuti;
    }

    @Override
    public String toString() {
        return "Pes{" +
                "bouda=" + bouda +
                ", jmeno='" + jmeno + '\'' +
                ", barva='" + barva + '\'' +
                ", delka=" + delka +
                ", zableseny=" + zableseny +
                '}';
    }
}

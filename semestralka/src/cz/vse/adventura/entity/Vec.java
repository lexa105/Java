package cz.vse.adventura.entity;

import cz.vse.adventura.prikazy.IPrikaz;

public class Vec {

    private String nazev;
    private String popis;
    protected boolean isMoveable = true; //Dovoluje použití tohoto booleanu pouze třídám, které dědí tuto vlastnost s třídou "Věc".

    public Vec(String nazev, String popis) {
        this.nazev = nazev;
        this.popis = popis;
    }

    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public String getPopis() {
        return popis;
    }

    public void setPopis(String popis) {
        this.popis = popis;
    }

    public boolean isMoveable() {
        return isMoveable;
    }




}

package cz.vse.adventura.entity;

import cz.vse.adventura.prikazy.IPrikaz;

public class Vec {

    private String nazev;
    private String popis;
    protected boolean isMoveable = true; //Dovoluje použití tohoto booleanu pouze třídám, které dědí tuto vlastnost s třídou "Věc".
    private IPrikaz interakce;

    public Vec(String nazev, String popis) {
        this.nazev = nazev;
        this.popis = popis;
    }

    public String getNazev() {
        return nazev;
    }

    public String getPopis() {
        return popis;
    }

    public boolean isMoveable() {
        return isMoveable;
    }

    public void setMoveable(boolean moveable) {
        isMoveable = moveable;
    }

    public IPrikaz getInterakce() {
        return interakce;
    }

    public void setInterakce(IPrikaz interakce) {
        this.interakce = interakce;
    }


}

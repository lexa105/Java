package cz.vse.adventura.entity;

import cz.vse.adventura.prikazy.IPrikaz;

public class Vec {

    private String nazev;
    private String popis;
    private boolean isMoveable;
    private IPrikaz interakce;

    public Vec(String nazev, String popis, boolean isMoveable) {
        this.nazev = nazev;
        this.popis = popis;
        this.isMoveable = isMoveable;
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

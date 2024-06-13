package cz.vse.adventura.entity;

public class LockedProstor extends Prostor {

    public LockedProstor(String nazev, String popis, String password) {
        super(nazev, popis);
        this.isLocked = true;
        this.password = password;
    };


}

package cz.vse.adventura.entity;

public class NPC extends Vec{


    
    public NPC(String nazev, String popis) {
        super(nazev, popis);
        this.isNPC = true;
    }


}

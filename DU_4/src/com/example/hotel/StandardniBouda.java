package com.example.hotel;

import java.util.HashSet;
import java.util.Set;

public class StandardniBouda implements Bouda {
    private int vyska = 1;
    private int sirka = 1;
    private int hloubka = 2;
    private int kapacita = 1;
    private Set<Pes> ubytovani;

    public int getVyska() {
        return this.vyska;
    }

    public int getSirka() {
        return this.sirka;
    }

    public int getHloubka(){
        return this.hloubka;
    }

    @Override
    public int getKapacita() {
        return this.kapacita;
    }

    @Override
    public void setKapacita(int kapacita) {
        this.kapacita = kapacita;
    }

    @Override
    public boolean isObsazeno() {
        return false;
    }

    @Override
    public boolean pridejPsa(Pes pes) {
        return false;
    }

    @Override
    public boolean odeberPsa(Pes pes) {
        return false;
    }

    @Override
    public boolean ubytovavaPsa(Pes pes) {
        return false;
    }

    @Override
    public HashSet<Pes> getUbytovaniPsi() {
        return null;
    }

    @Override
    public int getObjem() {
        return 0;
    }
}

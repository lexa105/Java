package com.example.hotel;

import java.util.ArrayList;
import java.util.List;

public class PsiHotel {

    private int maximalniObjemProBoudy = 20;
    private List<Bouda> boudy = new ArrayList<>();

    public int getMaximalniObjemProBoudy() {
        return maximalniObjemProBoudy;
    }

    public void setMaximalniObjemProBoudy(int maximalniObjemProBoudy) {
        this.maximalniObjemProBoudy = maximalniObjemProBoudy;
    }

    public boolean pridejBoudu(Bouda bouda) {
        return true;
    }

    public boolean odeberBoudu(Bouda bouda) {
        return false;
    }

    public void zastekejVsichniPsi() {
        if (boudy != null) {
            for (Bouda bouda: this.boudy)
            {
                for (Pes pes: bouda.getUbytovaniPsi()) {

                }
            }
        }
    }

    public boolean   isObsazeno() {
        int pocetboud = boudy.size();
        int volnemisto = this.maximalniObjemProBoudy - pocetboud;
        if(pocetboud == this.maximalniObjemProBoudy) {
            return true;
        } else {
            System.out.println("Ještě se tu vejde: " + volnemisto);
            return false;
        }

    }

    public boolean ubytujPsa(Pes pes) {

    }



    public void vypisBoudySePsi() {
        return this.boudy;
    }

}

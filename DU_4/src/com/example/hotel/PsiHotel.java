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
        for (Bouda bouda: this.boudy)
        {
            for (Pes pes: bouda.getUbytovaniPsi()) {

            }
        }
    }

}

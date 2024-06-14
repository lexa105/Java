package cz.vse.adventura.prikazy;

import cz.vse.adventura.entity.Batoh;
import cz.vse.adventura.entity.Prostor;
import cz.vse.adventura.entity.Vec;
import cz.vse.adventura.logika.HerniPlan;

import java.util.*;

public class PrikazScan implements IPrikaz{

    private static final String NAZEV = "vypis";
    private HerniPlan plan;

    public PrikazScan(HerniPlan plan) {
        this.plan = plan;
    }

    public String getNazev() {
        return NAZEV;
    }

    public void scanloading(String scanning) throws InterruptedException{
        System.out.print("Vypisuji " + scanning);
        for (int i = 0; i < 3; i++) {
            System.out.print(".");
            Thread.sleep(200);
        }
        System.out.print("\n");

    }

    @Override
    public String provedPrikaz(String... parametry) {

        if(parametry.length == 0) {
            // pokud chybí druhé slovo (název věci), tak ....
            return "Co mám vypsat - musíš napsat prostor nebo baťoh, abych mohl vypsat.";
        }

        String nazev = parametry[0];

        if (Objects.equals(nazev, "batoh")) {
            System.out.println("Vypisuji batoh...");
            return plan.vypisBatoh();

        } else if (Objects.equals(nazev, "prostor")) {
            try {
                scanloading("prostor");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return plan.vypisProstor();
        }
        else {
            return "Nevím co chceš vypsat - musíš zadat buď: batoh    prostor";
        }

    }


}

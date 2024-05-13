package cz.vse.adventura.prikazy;

import cz.vse.adventura.entity.Batoh;
import cz.vse.adventura.entity.Prostor;
import cz.vse.adventura.entity.Vec;
import cz.vse.adventura.logika.HerniPlan;

public class PrikazSeber implements IPrikaz{

    private static final String NAZEV = "seber";
    private HerniPlan plan;

    public PrikazSeber(HerniPlan plan) {
        this.plan = plan;
    }

    public String getNazev() {
        return NAZEV;
    }


    //Prikaz seber.
    //Hráčovi dovoluje sebrat věc ze země, jeli taková v místnosti
    @Override
    public String provedPrikaz(String... parametry) {
        if(parametry.length == 0) {
            // pokud chybí druhé slovo (název věci), tak ....
            return "Co mám sebrat - musíš napsat název věci, kterou mám sebrat.";
        }

        String nazev = parametry[0];

        return plan.seberVec(nazev);

    }
}

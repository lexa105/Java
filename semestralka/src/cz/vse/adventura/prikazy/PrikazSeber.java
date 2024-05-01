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


    //TODO: Dodelat tohle
    @Override
    public String provedPrikaz(String... parametry) {
        if(parametry.length == 0) {
            // pokud chybí druhé slovo (název věci), tak ....
            return "Co mám sebrat - musíš napsat název věci, kterou mám sebrat.";
        }

        String nazev = parametry[0];

        Prostor aktualniProstor = this.plan.getAktualniProstor();
        Batoh aktualniBatoh = this.plan.getAktualniBatoh();

        try {
            Vec sebranaVec = aktualniProstor.odeberVec(nazev);
            if(sebranaVec != null) {
                aktualniBatoh.addItem(sebranaVec);
                return sebranaVec.getNazev() + " sebrana ze zeme";
            } else {
                return nazev + "  v prostoru není";
            }

        } catch (IllegalStateException exception) {
            return exception.getMessage();
        }

    }
}

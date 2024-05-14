package cz.vse.adventura.prikazy;

import cz.vse.adventura.logika.HerniPlan;

public class PrikazPoloz implements IPrikaz{
    private static final String NAZEV = "poloz";
    private HerniPlan plan;

    public PrikazPoloz(HerniPlan plan) {
        this.plan = plan;
    }

    public String getNazev() {
        return NAZEV;
    }

    //Prikaz Poloz.
    //Hracovi dovoluje pokladat veci ze sve tasky. Dovoluje mu uvolnovat misto v inventari.
    //Nebo v nasem pripade vyhrat i hru pomoci polozeni tajneho receptu v restuaraci kamaradskeho kybliku.

    @Override
    public String provedPrikaz(String... parametry) {
        if (parametry.length == 0) {
            return "Co mám polozit? Musíš napsat název věci, kterou chceš položit.";
        }
        String nazev = parametry[0];

        return plan.polozVec(nazev);
    }
}

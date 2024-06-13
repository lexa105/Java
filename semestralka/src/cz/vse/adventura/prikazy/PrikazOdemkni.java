package cz.vse.adventura.prikazy;

import cz.vse.adventura.entity.LockedProstor;
import cz.vse.adventura.entity.Prostor;
import cz.vse.adventura.logika.HerniPlan;

public class PrikazOdemkni implements IPrikaz{

    private static final String NAZEV = "odemkni";

    private HerniPlan plan;
    //Constructor tridy

    public PrikazOdemkni(HerniPlan plan
    ) {this.plan = plan;}

    @Override
    public String provedPrikaz(String... parametry) {
        if (parametry.length < 2) {
            if (parametry.length == 0) {
                return "Co mám odemknout? Musíš napsat prostor a heslo (př. odemkni jidelna 56423)";
            } else {
                return "Chybí ti zadat heslo. př. odemkni jidelna 56423";
            }
        }
        String prostor = parametry[0];
        Prostor sousedniProstor = plan.getAktualniProstor().vratSousedniProstor(prostor);

        if(sousedniProstor == null) {
            return "Takový prostor neexistuje.";
        } else if (!sousedniProstor.isLocked()) {
            return "Tento prostor neni uzamčený, můžeš použít příkaz \"jdi\" ";
        }

        String heslo = parametry[1];

        if (heslo.isEmpty()) {
            return "Chybí ti heslo, které potřebuješ k odemknutí prostoru!";
        }

        return plan.odemkniProstor(sousedniProstor, heslo);
    }

    @Override
    public String getNazev() {
        return NAZEV;
    }


}

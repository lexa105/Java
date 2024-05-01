package cz.vse.adventura.prikazy;

import cz.vse.adventura.entity.Vec;
import cz.vse.adventura.logika.HerniPlan;

import java.util.HashSet;
import java.util.Set;

public class PrikazScan implements IPrikaz{

    private static final String NAZEV = "skenuj";
    private HerniPlan plan;

    public PrikazScan(HerniPlan plan) {
        this.plan = plan;
    }

    public String getNazev() {
        return NAZEV;
    }

    public void scanloading() throws InterruptedException{
        System.out.println("Skenuji mistnost");
        boolean isLoading = true;
        String dots = "...";
        while (isLoading) {
            System.out.print("\\r...");
            Thread.sleep(500);
        }
    }
    @Override
    public String provedPrikaz(String... parametry) {

        Set<Vec> veci = this.plan.getAktualniProstor().vratVeciNaZemi();
        Set<String> nazvyveci = new HashSet<>();
        for (Vec vec : veci) {
            nazvyveci.add(vec.getNazev());
        }
        return nazvyveci.toString();

    }


}

package cz.vse.adventura.logika;


import cz.vse.adventura.entity.Batoh;
import cz.vse.adventura.entity.Prostor;
import cz.vse.adventura.entity.Vec;
import cz.vse.adventura.entity.VelkaVec;

import java.util.*;

/**
 *  Class HerniPlan - třída představující mapu a stav adventury.
 * 
 *  Tato třída inicializuje prvky ze kterých se hra skládá:
 *  vytváří všechny prostory,
 *  propojuje je vzájemně pomocí východů 
 *  a pamatuje si aktuální prostor, ve kterém se hráč právě nachází.
 *
 *@author     Michael Kolling, Lubos Pavlicek, Jarmila Pavlickova
 *@version    pro školní rok 2016/2017
 */
public class HerniPlan {
    
    private Prostor aktualniProstor;
    private Batoh aktualniBatoh;

    
     /**
     *  Konstruktor který vytváří jednotlivé prostory a propojuje je pomocí východů.
     *  Jako výchozí aktuální prostor nastaví halu.
     */
    public HerniPlan() {
        zalozProstoryHry();
        zalozBatoh();

    }
    /**
     *  Vytváří jednotlivé prostory a propojuje je pomocí východů.
     *  Jako výchozí aktuální prostor nastaví domeček.
     */
    private void zalozProstoryHry() {
        // vytvářejí se jednotlivé prostory
        Prostor domecek = new Prostor("domeček","domeček, ve kterém bydlí Karkulka");
        Prostor chaloupka = new Prostor("chaloupka", "chaloupka, ve které bydlí babička Karkulky");
        Prostor jeskyne = new Prostor("jeskyně","stará plesnivá jeskyně");
        Prostor les = new Prostor("les","les s jahodami, malinami a pramenem vody");
        Prostor hlubokyLes = new Prostor("hluboký_les","temný les, ve kterém lze potkat vlka");


        //Prostory pro semestrální práci.
        Prostor kkStart = new Prostor("kamaradsky_kyblik", "Vaše restaurace, která má přesně 0 slovy nula zákazníků");
        Prostor ulice = new Prostor("ulice", "ulice Conch streets");
        Prostor krupKrab = new Prostor("krupavy_krab", "Křupavý krab je váš konkurent, jež se mu daří lépe než Vám, udělejte s tím něco!");
        Prostor jidelna = new Prostor("jidelna", "Jidelna křupavého kraba");
        Prostor ananas = new Prostor("Spongebobův barák", "Ananas v němž žije Spongebob, je ve tvaru ananasu.");


        Vec mec = new Vec("hovna", "Mec dava damage");
        VelkaVec postel = new VelkaVec("Postel", "Postel kde spíš");
        
        // přiřazují se průchody mezi prostory (sousedící prostory)
        domecek.setVychod(les);

        les.setVychod(domecek);
        les.setVychod(hlubokyLes);
        hlubokyLes.setVychod(les);
        hlubokyLes.setVychod(jeskyne);
        hlubokyLes.setVychod(chaloupka);
        jeskyne.setVychod(hlubokyLes);
        chaloupka.setVychod(hlubokyLes);

        domecek.setVeciNaZemi(mec);
        domecek.setVeciNaZemi(postel);



                
        aktualniProstor = domecek;  // hra začíná v domečku       
    }
    
    /**
     *  Metoda vrací odkaz na aktuální prostor, ve ktetém se hráč právě nachází.
     *
     *@return     aktuální prostor
     */

    private void zalozBatoh() {
        this.aktualniBatoh = new Batoh();
    }

    /**
     *  Zalozi batoh jako inventar pro hrace.
     *  @return
     */
    public Batoh getAktualniBatoh() {
        return aktualniBatoh;
    }
    
    public Prostor getAktualniProstor() {
        return aktualniProstor;
    }
    
    /**
     *  Metoda nastaví aktuální prostor, používá se nejčastěji při přechodu mezi prostory
     *
     *@param  prostor nový aktuální prostor
     */
    public void setAktualniProstor(Prostor prostor) {
       aktualniProstor = prostor;
    }


    /**
     *  Metoda sebere věc a dá ji do inventáře hráče.
     *
     */
    public String seberVec(String nazev) {
        if (aktualniBatoh == null) {
            return "Nemáš žádný batoh";
        } else {
            try {
                Vec sebranaVec = aktualniProstor.odeberVec(nazev);
                if(sebranaVec != null ) {
                    if(sebranaVec.isMoveable()) {
                        aktualniBatoh.addItem(sebranaVec);
                        return sebranaVec.getNazev() + " sebrana ze zeme";
                    }
                    else {
                        return sebranaVec.getNazev() + "  je moc velká, aby se vešla do batohu";
                    }
                } else {
                    return nazev + " v prostoru není";
                }

            } catch (IllegalStateException exception) {
                return exception.getMessage();
            }
        }
    }


    public String polozVec(String nazev) {
        if(aktualniBatoh == null) {
            return "Nemáš žáadný batoh";
        }
        else
            try {
                Vec polozenaVec = aktualniBatoh.removeItem(nazev);
                if(polozenaVec != null) {
                    aktualniProstor.setVeciNaZemi(polozenaVec);
                    return polozenaVec.getNazev() + " byla polozena na zem";
                 }
                else {
                    return nazev + "v batohu není, nelze položit na zem.";
                }
            }
            catch (IllegalStateException exception) {
                return exception.getMessage();
            }


    }

    public String vypis(String nazev) {
        if (Objects.equals(nazev, "batoh")) {
            System.out.println("Vypisuji batoh");
            LinkedHashMap<String, Vec> inventar = aktualniBatoh.getInventory();
            Set<String> nazvyveci = inventar.keySet();
            String vysledek = nazvyveci.toString();
            return vysledek;

        } else if (Objects.equals(nazev, "prostor")) {
            System.out.println("Vypisuji prostor");
            Set<String> nazvyveci = new HashSet<>();
            Collection<Prostor> vychody = aktualniProstor.getVychody();
            Set<Vec> veci = aktualniProstor.vratVeciNaZemi();
            for (Vec vec : veci) {
                nazvyveci.add(vec.getNazev());
            }
            String vyseledek = "Veci na zemi:" + nazvyveci + "\n"
                    + "Vystupy:" +  vychody.toString();

            return vyseledek;
        }
        else {
            return "Nerozumím co chceš vypsat.";
        }

    }

    public void win() {

    }

}

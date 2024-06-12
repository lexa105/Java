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
        Prostor kkStart = new Prostor("Kamaradasky_Kyblik", "Vaše restaurace, která má přesně 0 slovy nula zákazníků");
        Prostor ulice = new Prostor("ulice", "ulice Conch streets");
        Prostor krupavyKrab = new Prostor("krupavy_krab", "Křupavý krab je váš konkurent, jež se mu daří lépe než Vám, udělejte s tím něco!");
        Prostor jidelna = new Prostor("jidelna", "Jidelna křupavého kraba");
        Prostor kuchyn = new Prostor("kuchyn", "Zde se dělá Krabí Hambáč, nedělá ho nikdo jiný než Spongebob v Kalhotách");
        Prostor kancelar = new Prostor("kancelar", "Zde sídlí pan Krabs a taky tajný recept.");
        Prostor sejf = new Prostor("sejf", "Za tímto sejfem je Tajný recept na krabí hambáč.");
        Prostor sejfIn = new Prostor("vnitrek", "Dostal ses dovnitř najdi recept.");
        //Zachody
        Prostor wc = new Prostor("zachody", "Zde jsou záchody");
        Prostor zachod1 = new Prostor("zachod1", "Zachod #1");
        Prostor zachod2 = new Prostor("zachod2", "Zachod #2");
        Prostor spongebobDum = new Prostor("spongebob_dum", "Ananas v němž žije Spongebob, je ve tvaru ananasu.");
        Prostor sepiakDum = new Prostor("sepiak_dum", "Dům ve kterém bydlí Sépiák");
        Prostor patrikDum = new Prostor("patrik_dum", "Tady bydlí Patrik hvězdice, je to kámen...");




        //Kamaradsky kyblik start
        kkStart.setVychod(ulice);

        ulice.setVychod(krupavyKrab);
        ulice.setVychod(spongebobDum);
        ulice.setVychod(sepiakDum);
        ulice.setVychod(patrikDum);

        krupavyKrab.setVychod(jidelna);

        jidelna.setVychod(kuchyn);
        jidelna.setVychod(kancelar);
        jidelna.setVychod(wc);

        kancelar.setVychod(sejf);

        sejf.setVychod(sejfIn);

        wc.setVychod(zachod1);
        wc.setVychod(zachod2);


        Vec mec = new Vec("hovna", "Mec dava damage");
        VelkaVec postel = new VelkaVec("Postel", "Postel kde spíš");


                
        aktualniProstor = kkStart;  // hra začíná v domečku
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
            return "Nemáš žádný batoh";
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


    // Vrátí, co všechno se nachází v batohu hráče.
    public String vypisBatoh() {
        System.out.println("Vypisuji batoh...");
        LinkedHashMap<String, Vec> inventar = aktualniBatoh.getInventory();
        Set<String> nazvyveci = new HashSet<>();
        for (Vec veci : inventar.values()) {
            if(!veci.isMoveable()) {
                //Styl a barva textů
                final String RED_ITALIC = "\033[31m";
                final String RESET = "\033[0m";
                String styledNazev = RED_ITALIC + veci.getNazev() + RESET;
                nazvyveci.add(styledNazev);
            }
            else {
                nazvyveci.add(veci.getNazev());
            }
        }
        String vysledek = nazvyveci.toString();
        return vysledek;
    }
    public String vypisProstor() {
        System.out.println("Vypisuji prostor...");
        String vychody = aktualniProstor.popisVychodu();
        Set<Vec> veci = aktualniProstor.vratVeciNaZemi();
        Set<String> nazvyveci = new HashSet<>();
        for (Vec vec : veci) {
            if(!vec.isMoveable()) {
                final String RED_ITALIC = "\033[31m";
                final String RESET = "\033[0m";
                String styledNazev = RED_ITALIC + vec.getNazev() + RESET;
                nazvyveci.add(styledNazev);
            }
            else {
                nazvyveci.add(vec.getNazev());
            }
        }

        String vyseledek = "Veci na zemi: " + nazvyveci + "\n"
                + vychody;

        return vyseledek;
    }


}

package cz.vse.adventura.logika;


import cz.vse.adventura.entity.*;

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

        //Prostory pro semestrální práci.
        Prostor kkStart = new Prostor("Kamaradasky_Kyblik", "Vaše restaurace, která má přesně 0 slovy nula zákazníků");
        Prostor ulice = new Prostor("ulice", "ulice Conch streets");
        Prostor krupavyKrab = new Prostor("krupavy_krab", "Křupavý krab je váš konkurent, jež se mu daří lépe než Vám, udělejte s tím něco!");
        Prostor kuchyn = new Prostor("kuchyn", "Zde se dělá Krabí Hambáč, nedělá ho nikdo jiný než Spongebob v Kalhotách");
        Prostor kancelar = new Prostor("kancelar", "Zde sídlí pan Krabs a taky tajný recept.");
        LockedProstor sejf = new LockedProstor("sejf", "Za tímto sejfem je Tajný recept na krabí hambáč.", "30111942");
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

        krupavyKrab.setVychod(kuchyn);
        krupavyKrab.setVychod(kancelar);
        krupavyKrab.setVychod(wc);

        kancelar.setVychod(sejf);

        sejf.setVychod(sejfIn);
        sejfIn.setVychod(sejf);

        wc.setVychod(zachod1);
        wc.setVychod(zachod2);

        //KK velke veci.
        VelkaVec kasa_kk = new VelkaVec("Kasa", "Kvůli nulovým prodejům tu máš přesně 0 USD");
        VelkaVec stul_KK = new VelkaVec("Stůl", "stůl pro zákazníky");
        VelkaVec zidle_KK = new VelkaVec("Židle", "zidle ke stolu pt.1");
        VelkaVec zidle1_KK = new VelkaVec("Židle2", "zidle ke stolu pt.2");
        kkStart.setVeciNaZemi(kasa_kk);
        kkStart.setVeciNaZemi(stul_KK);
        kkStart.setVeciNaZemi(zidle_KK);
        kkStart.setVeciNaZemi(zidle1_KK);
        //KK male veci
        Vec prach = new Vec("prach", "prach a špína.");
        kkStart.setVeciNaZemi(prach);
        //KK NPCs

        //ulice velké veci.
        VelkaVec velkysutr = new VelkaVec("Šutr", "obří kámen/šutr");
        ulice.setVeciNaZemi(velkysutr);
        //ulice male veci
        Vec kaminek = new Vec("kaminek", "Nic nedělá, ale vypadá jako cool kamínek");
        ulice.setVeciNaZemi(kaminek);
        //ulice NPCs

        //Krupavy Krab velke veci.
        VelkaVec stul_krab = new VelkaVec("Stůl","Stůl pro zákazníky");
        VelkaVec zidle_krab = new VelkaVec("Židle", "židle pro zákazníky");
        VelkaVec zidle_krab2 = new VelkaVec("Židle2", "židle pro zákazníky");
        VelkaVec zakaznik1 = new VelkaVec("Zákazník", "zákazník");
        VelkaVec kasa_krab = new VelkaVec("Kasa", "Kasa křupavého Kraba, za ní stojí Sépiák.");
        krupavyKrab.setVeciNaZemi(stul_krab);
        krupavyKrab.setVeciNaZemi(zidle_krab2);
        krupavyKrab.setVeciNaZemi(zidle_krab);
        krupavyKrab.setVeciNaZemi(zakaznik1);
        krupavyKrab.setVeciNaZemi(kasa_krab);
        //Krupavy Krab male veci
        Vec hamburger = new Vec("hambáč", "Krabí hambáč");
        Vec ubrousek = new Vec("ubrousek", "ubrousek");
        krupavyKrab.setVeciNaZemi(hamburger);
        krupavyKrab.setVeciNaZemi(ubrousek);



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
        LinkedHashMap<String, Vec> inventar = aktualniBatoh.getInventory();
        Set<String> nazvyveci = new HashSet<>();
        for (Vec veci : inventar.values()) {
            if(!veci.isMoveable()) {
                final String BLUE_font = "\033[36;3m";
                if (!veci.isNPC()) {
                //Styl a barva textů
                final String RED_font = "\033[31m";
                final String RESET = "\033[0m";
                String styledNazev = RED_font + veci.getNazev() + RESET;
                nazvyveci.add(styledNazev);}
            }
            else {
                nazvyveci.add(veci.getNazev());
            }
        }
        String vysledek = nazvyveci.toString();
        return vysledek;
    }
    public String vypisProstor() {
        String vychody = aktualniProstor.popisVychodu();
        Set<Vec> veci = aktualniProstor.vratVeciNaZemi();
        Set<String> nazvyveci = new HashSet<>();
        for (Vec vec : veci) {
            if(!vec.isMoveable()) {
                final String BLUE_font = "\033[36;3m";
                if (!vec.isNPC()) {
                    //Styl a barva textů
                    final String RED_font = "\033[31m";
                    final String RESET = "\033[0m";
                    String styledNazev = RED_font + vec.getNazev() + RESET;
                    nazvyveci.add(styledNazev);}
            }
            else {
                nazvyveci.add(vec.getNazev());
            }
        }

        String actualLocation = "Jsi v místnosti " + getAktualniProstor().getNazev() + "\n";
        String vyseledek = actualLocation + "Veci na zemi: " + nazvyveci + "\n"
                + vychody;

        return vyseledek;
    }

    public String odemkniProstor(Prostor prostor, String password) {
        if(password.contains(prostor.getPassword())) {
            aktualniProstor = prostor;
            prostor.setLocked(false);
            return "Prostor úspěšně odemčen, vstupuješ do místnosti:" + prostor.getNazev();
        }
        else {
            return "Špatné heslo, odemkni znova jiným heslem.";
        }
    }


}

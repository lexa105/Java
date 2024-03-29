package com.example.hotel;

import java.util.HashSet;
import java.util.Set;

public interface Bouda {
    public int getKapacita();
    public void setKapacita(int kapacita);
    public boolean isObsazeno();
    public boolean pridejPsa(Pes pes);
    public boolean odeberPsa(Pes pes);
    public boolean ubytovavaPsa(Pes pes);
    public HashSet<Pes> getUbytovaniPsi();
    public int getObjem();
}

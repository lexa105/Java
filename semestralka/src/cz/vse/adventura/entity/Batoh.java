package cz.vse.adventura.entity;

import java.util.HashSet;
import java.util.Set;

public class Batoh {

    private final int inventorySize = 5;
    private Set<Vec> inventory;

    public Batoh() {
        inventory = new HashSet<>();
    }


    public void addItem(Vec item) {
        if(inventory.size() < inventorySize) {
            inventory.add(item);
        } else {
            System.out.println("Batoh je plnej. Neco odeber");
        }
    }
    public Set<Vec> getInventory() {
        return inventory;
    }

    public Vec odeberVec(String nazevVeci) {
        //TODO: Dodelat
        Vec odebranaVec =
        if(inventory.contains())

    }


}

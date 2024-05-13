package cz.vse.adventura.entity;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;

public class Batoh {

    private final int inventorySize = 5;
    private LinkedHashMap<String, Vec> inventory;

    public Batoh() {
        inventory = new LinkedHashMap<>();
    }


    public void addItem(Vec item) {
        if(inventory.size() < inventorySize) {
            String itemName = item.getNazev();
            inventory.put(itemName, item);
            System.out.println(inventory.size()+ "/" + inventorySize );
        } else {
            System.out.println("Batoh je plnej. Neco odeber");
        }
    }
    public LinkedHashMap<String, Vec> getInventory() {
        return inventory;
    }



    //Vec bude moci byt vyndana z batohu na zem prostoru. Vrati Vec a da ji do prostoru.
    public Vec removeItem(String itemName) {
        //TODO: Dodelat
        if (inventory.containsKey(itemName)) {
            Vec removedItem = inventory.get(itemName);
            inventory.remove(removedItem);
            return removedItem;
        } else {
            return null;
        }

    }
}
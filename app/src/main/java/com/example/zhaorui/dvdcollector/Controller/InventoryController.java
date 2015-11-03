package com.example.zhaorui.dvdcollector.Controller;

import com.example.zhaorui.dvdcollector.Model.DVD;
import com.example.zhaorui.dvdcollector.Model.Inventory;
import com.example.zhaorui.dvdcollector.Model.User;

import java.util.ArrayList;

/**
 * Created by dingkai on 15/11/1.
 */
public class InventoryController {
    private Inventory inventory;

    public InventoryController(){
        inventory = User.instance().getInventory();
    }

    public Inventory getInventory(){return inventory;}

    public Inventory getInventory(String category){
        Inventory categoryInventory = new Inventory();
        for (DVD dvd : inventory){
            if (dvd.getCategory() == category){
                categoryInventory.add(dvd);
            }
        }
        return categoryInventory;
    }

    public void add(DVD dvd){inventory.add(dvd);}

    public void set(int index, DVD dvd){inventory.set(index, dvd);}

    public void remove(int index){inventory.remove(index);}

    public DVD get(int index){ return inventory.get(index);}

    public int indexOf(DVD dvd) {return inventory.indexOf(dvd);}
}

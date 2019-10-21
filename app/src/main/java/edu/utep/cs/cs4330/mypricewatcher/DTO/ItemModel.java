package edu.utep.cs.cs4330.mypricewatcher.DTO;

/**
 * @author Julio A Hernandez
 * @version 1.0
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Class created to retrieve all item information to implement MVC
 */
public class ItemModel {
    private List<Item> items;

    public ItemModel(){
        this.items = new ArrayList<>();
    }

    public void addItem(Item item){
        this.items.add(item);
    }

    public Iterator<Item> getItems(){
        return items.iterator();
    }

    public void calculateCurrentPriceChange(){
        for(Item item : items){
            double change =  (((item.currentPrice - item.initialPrice) / item.initialPrice) * 100);
            item.setPriceChage(change);
        }
    }

    public int getItemSize(){
        return items.size();
    }

    public void updatePrice(int index, double newPrice){
        Item item = items.get(index);
        item.setCurrentPrice(newPrice);
    }

    public void removeItem(Item item)
    {
        for(int i = 0; i < items.size(); i++){
            if(item.name == items.get(i).name){
                items.remove(i);
            }
        }
    }
    public Item getItem(int index){
        return items.get(index);
    }

}

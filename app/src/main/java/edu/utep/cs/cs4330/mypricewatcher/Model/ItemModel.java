package edu.utep.cs.cs4330.mypricewatcher.Model;

/**
 * @author Julio A Hernandez
 * @version 1.0
 */

import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Class created to retrieve all item information to implement MVC
 */
public class ItemModel {
    //private List<Item> items;
    private Database db;

    public ItemModel(Context context){
        this.db = new Database(context);
        //this.items = new ArrayList<>();
    }

    public void addItem(Item item){
       // this.items.add(item);
        this.db.insertData(item);
    }

    public Cursor getItems(){
        return db.getAll();
    }
/*
    public void calculateCurrentPriceChange(){
        for(Item item : items){
            double change =  (((item.currentPrice - item.initialPrice) / item.initialPrice) * 100);
            item.setPriceChange(change);
        }
    }

    public void updatePrice(int index, double newPrice){
        Item item = items.get(index);
        item.setCurrentPrice(newPrice);
    }
    */

    public void removeItem(Item item) {
        this.db.deleteData(item.id);
        }

    public void editItem(Item item) {
        this.db.editData(item);
    }
/*
    public Item getItem(int index){
        return items.get(index);
    }*/

}

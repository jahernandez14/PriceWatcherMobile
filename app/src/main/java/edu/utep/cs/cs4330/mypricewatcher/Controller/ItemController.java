package edu.utep.cs.cs4330.mypricewatcher.Controller;

/**
 * @author Julio A Hernandez
 * @version 1.0
 */

import android.database.Cursor;
import android.util.Log;

import edu.utep.cs.cs4330.mypricewatcher.Model.Item;
import edu.utep.cs.cs4330.mypricewatcher.View.MainActivity;
import edu.utep.cs.cs4330.mypricewatcher.Model.ItemModel;

/**
 * Class created to provide data to item model
 */
public class ItemController {
    private ItemModel model;
    private MainActivity view;
    private PriceFinder priceFinder;


    public ItemController(ItemModel model, MainActivity view){
        this.model = model;
        this.view = view;
        this.priceFinder = new PriceFinder();
    }

    //We are going to use price Finder to update all the prices of the items
    public void updatePrice(int i){
            model.updatePrice(i, priceFinder.createRandom());
        Log.d("TESTING", "update price method called " + priceFinder.createRandom());
        updateView();
    }

    //Adding item to the model
    public void addItem(Item item){
        model.addItem(item);
        updateView();
    }

    public void editItem(int index, String name){
        Item item = model.getItem(index);
        item.setName(name);
        updateView();
    }

    public void removeItem(Item item){
        model.removeItem(item.id);
        updateView();
    }

    public void updateView(){
        view.clearItems();
        Cursor cursor = model.getItems();
       while (cursor.moveToNext()){
           Item item = new Item(cursor.getString(0), cursor.getString(1), cursor.getString(2),cursor.getDouble(3), cursor.getDouble(4),cursor.getDouble(5));
           view.displayItem(item.getName(), item.getInitialPrice(), item.getUrl(), item.getPriceChange(), item.getCurrentPrice());
       }
    }

}

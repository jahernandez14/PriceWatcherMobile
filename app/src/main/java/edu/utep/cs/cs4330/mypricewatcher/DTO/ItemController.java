package edu.utep.cs.cs4330.mypricewatcher.DTO;

/**
 * @author Julio A Hernandez
 * @version 1.0
 */

import android.util.Log;

import edu.utep.cs.cs4330.mypricewatcher.MainActivity;

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
        model.removeItem(item);
        updateView();
    }

    public void updateView(){
        view.clearItems();
       for(int i = 0; i < model.getItemSize(); i ++){
           Item item = model.getItem(i);
           view.displayItem(item.getName(), item.getInitialPrice(), item.getUrl(), item.getPriceChage(), item.getCurrentPrice());
       }
    }

}

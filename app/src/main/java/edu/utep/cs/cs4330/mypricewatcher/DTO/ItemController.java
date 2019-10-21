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
    public void updatePrice(Item item){
        model.updatePrice(item);
        updateView();
    }

    //Adding item to the model
    public void addItem(Item item){
        model.addItem(item);
        updateView();
    }

    public void editItem(Item item, String name){
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

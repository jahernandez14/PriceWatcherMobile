package edu.utep.cs.cs4330.mypricewatcher.Controller;

/**
 * @author Julio A Hernandez
 * @version 3.0
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

    public void updatePrice(Item item){

        item.setInitialPrice(item.getCurrentPrice());
        new Thread(new Runnable() {
            public void run() {
                item.setCurrentPrice(priceFinder.urlPrice(item.getUrl()));
                item.setPriceChange(priceChange(item));
                model.updatePrice(item);
                Log.d("result","" + item.currentPrice);
            }
        }).start();

        Log.d("result","" + item.currentPrice);
        //item.setCurrentPrice(priceFinder.urlPrice(item.getUrl()));

        //item.setCurrentPrice(priceFinder.createRandom());
        new Network().sleep();
        updateView();
    }

    public double priceChange(Item item){
        double priceChange;
        priceChange =  (((item.currentPrice - item.initialPrice) / item.initialPrice) * 100);
        return priceChange;
    }

    public void addItem(Item item){
        model.addItem(item);
        updateView();
    }

    public void editItem(Item item){
        model.editItem(item);
        updateView();
    }

    public void removeItem(Item item){
        model.removeItem(item);
        updateView();
    }

    public void updateView(){
        view.clearItems();
        Cursor cursor = model.getItems();
       while (cursor.moveToNext()){
           Item item = new Item(cursor.getString(0), cursor.getString(1), cursor.getString(2),cursor.getDouble(3), cursor.getDouble(4),cursor.getDouble(5));
           view.displayItem(item.getId(), item.getName(), item.getInitialPrice(), item.getUrl(), item.getPriceChange(), item.getCurrentPrice());
       }
       cursor.close();
    }

}

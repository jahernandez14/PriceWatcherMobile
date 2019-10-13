package edu.utep.cs.cs4330.mypricewatcher.DTO;

/**
 * @author Julio A Hernandez
 * @version 1.0
 */

import edu.utep.cs.cs4330.mypricewatcher.MainActivity;

/**
 * Class created to provide data to item model
 */
public class ItemController {
    private ItemModel model;
    private MainActivity view;
    private PriceFinder priceFinder;

    /**
     *
     * @param model
     * @param view
     */
    public ItemController(ItemModel model, MainActivity view){
        this.model = model;
        this.view = view;
        this.priceFinder = new PriceFinder();
    }

    public String getURL(){
        return model.getItemURL();
    }

    public void updatePrice(){
        model.setInitialPrice(model.getCurrentPrice());
        model.updatePrice(priceFinder.createRandom());
    }

    public void updateChange(){//change attempted to calculate price change
        model.getPriceChange();
    }

    public void updateView(){
        view.displayItem(model.getName(), model.getInitPrice(), model.getItemURL(), model.getCurrPriceChange(), model.getCurrentPrice());
    }

}

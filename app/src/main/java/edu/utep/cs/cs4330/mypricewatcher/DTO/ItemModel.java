package edu.utep.cs.cs4330.mypricewatcher.DTO;

/**
 * @author Julio A Hernandez
 * @version 1.0
 */

/**
 * Class created to retrieve all item information to implement MVC
 */
public class ItemModel {
    private Item item;

    public ItemModel(Item item){
        this.item = item;
    }

    public ItemModel() {

    }

    public void setItem(Item item){
        this.item = item;
    }

    public double getCurrentPrice(){
        return item.getCurrentPrice();
    }

    public void setInitialPrice(double newPrice){
        this.item.initialPrice = newPrice;
    }



    public String getName(){
        return this.item.name;
    }

    public double getPrice(){
        return this.item.currentPrice;
    }

    public String getItemURL(){
        return this.item.url;
    }


    public double getPriceChange(){
        return this.item.priceChage;
    }

    public double getInitPrice(){
        return this.item.initialPrice;
    }

    public double getCurrPriceChange(){
        double change =  (((item.currentPrice - item.initialPrice) / item.initialPrice) * 100);
        item.priceChage = change;
        return this.item.priceChage;
    }

    /**
     *
     * @param newPrice
     */
    public void updatePrice(double newPrice){
        if(this.item != null){
            this.item.setCurrentPrice(newPrice);
        }
    }

}

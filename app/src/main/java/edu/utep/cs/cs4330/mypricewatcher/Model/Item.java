package edu.utep.cs.cs4330.mypricewatcher.Model;

/**
 * @author Julio A Hernandez
 * @version 1.0
 */

/**
 * Object class to store item information
 */
public class Item {
    public String id;
    public String name;
    public String url;
    public double initialPrice;
    public double currentPrice;
    public double priceChange;

    /**
     *
     * @param name
     * @param url
     * @param initialPrice
     * @param currentPrice
     * @param priceChange
     */
    public Item(String id, String name, String url, double initialPrice, double currentPrice, double priceChange){
        this.id = id;
        this.name = name;
        this.url = url;
        this.initialPrice = initialPrice;
        this.currentPrice = initialPrice;
        this.priceChange = priceChange;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public double getInitialPrice() {
        return initialPrice;
    }

    public void setInitialPrice(double initialPrice) {
        this.initialPrice = initialPrice;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public double getPriceChange() {
        return priceChange;
    }

    public void setPriceChange(double priceChange) {
        this.priceChange = priceChange;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

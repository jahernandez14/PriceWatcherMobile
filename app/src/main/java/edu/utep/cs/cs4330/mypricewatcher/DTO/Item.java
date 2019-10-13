package edu.utep.cs.cs4330.mypricewatcher.DTO;

/**
 * @author Julio A Hernandez
 * @version 1.0
 */

/**
 * Object class to store item information
 */
public class Item {
    public String name;
    public String url;
    public double initialPrice;
    public double currentPrice;
    public double priceChage;

    /**
     *
     * @param name
     * @param url
     * @param initialPrice
     * @param currentPrice
     * @param priceChage
     */
    public Item(String name, String url, double initialPrice, double currentPrice, double priceChage){
        this.name = name;
        this.url = url;
        this.initialPrice = initialPrice;
        this.currentPrice = initialPrice;
        this.priceChage = priceChage;
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

    public double getPriceChage() {
        return priceChage;
    }

    public void setPriceChage(double priceChage) {
        this.priceChage = priceChage;
    }
}

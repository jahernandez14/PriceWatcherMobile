package edu.utep.cs.cs4330.mypricewatcher.DTO;

/**
 * @author Julio A Hernandez
 * @version 1.0
 */

import java.util.Random;

/**
 * Class created to provide a random price to the item.
 */
public class PriceFinder {

    PriceFinder(){
    }

    /**
     *
     * @return
     */
    public double createRandom() {
        double min = 250;
        double max = 400;

        Random random = new Random();
        double holder = min + (max - min) * random.nextDouble();
        return Math.round(holder * 100.00) / 100.0;
    }
}
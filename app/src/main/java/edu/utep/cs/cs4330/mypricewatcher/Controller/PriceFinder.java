package edu.utep.cs.cs4330.mypricewatcher.Controller;

/**
 * @author Julio A Hernandez
 * @version 3.0
 */

import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Random;

public class PriceFinder {
    private double price;

    public PriceFinder() {

    }

    public double urlPrice(String url){
        Pattern pattern;
        try {
            if(url.substring(12,21).equals("homedepot")){
                pattern = Pattern.compile("content=\"\\d+[\\.]\\d+\\d");
                price = reader(url,pattern);
                return price;
            }

            else if(url.substring(12,19).equals("walmart")) {
                pattern = Pattern.compile("content=\"\\d+[\\.]\\d+\\d");
                price = reader(url,pattern);
                return price;
            }

            else if(url.substring(12,16).equals("ebay")) {
                pattern = Pattern.compile("content=\"\\d+[\\.]\\d+\\d");
                price = reader(url,pattern);
                return price;
            }
        }
        catch (Exception e) {
            Log.d("Price Calculated", "not found");
        }
        return price;
    }

    public double reader(String store, Pattern pattern) throws Exception {
        URL url = new URL(store);
        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
        String line;
        while ((line = in.readLine()) != null) {
            Matcher matcher = pattern.matcher(line);
            if (matcher.find()) {
                price = Double.parseDouble((line.substring(matcher.start(0),matcher.end(0))).substring(9));
                Log.d("Price", String.valueOf(price));
                return price;

            }
        }
        in.close();
        return price;
    }

    public double createRandom() {
        double min = 250;
        double max = 400;

        Random random = new Random();
        double holder = min + (max - min) * random.nextDouble();
        return Math.round(holder * 100.00) / 100.0;
    }
}
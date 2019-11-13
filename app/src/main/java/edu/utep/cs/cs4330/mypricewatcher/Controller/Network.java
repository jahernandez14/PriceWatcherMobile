package edu.utep.cs.cs4330.mypricewatcher.Controller;

import android.app.Activity;

/**
 * @author
 * sleeping class
 */
public class Network extends Activity {
    public void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {}
    }
}
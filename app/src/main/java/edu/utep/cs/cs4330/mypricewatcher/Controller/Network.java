package edu.utep.cs.cs4330.mypricewatcher.Controller;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;
import android.widget.TextView;

import edu.utep.cs.cs4330.mypricewatcher.R;

public class Network extends Activity {
    public void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {}
    }
}
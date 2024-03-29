package edu.utep.cs.cs4330.mypricewatcher.View;

/**
 * @author Julio A Hernandez
 * @version 3.0
 */

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.Nullable;

import edu.utep.cs.cs4330.mypricewatcher.R;

/**
 * Activity created to display launched web URL
 */
public class WebViewActivity extends Activity {
    private WebView webview;

    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview_layout);

        webview = (WebView) findViewById(R.id.WebViewURL);
        String url = getIntent().getStringExtra("url");
        webview.setWebViewClient(new WebViewClient());
        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webview.loadUrl(url);
    }
}

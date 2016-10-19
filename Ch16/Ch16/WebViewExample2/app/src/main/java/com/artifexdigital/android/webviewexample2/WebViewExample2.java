package com.artifexdigital.android.webviewexample2;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;


public class WebViewExample2 extends Activity {
    WebView myWV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_example2);

        myWV = (WebView)findViewById(R.id.webView);
        myWV.loadData("<html><p><b>A WebView HTML Page</b></p></html>",
                "text/html",
                "UTF-8");
    }

}

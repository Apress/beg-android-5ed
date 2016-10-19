package com.artifexdigital.android.webviewexample;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;


public class WebViewExample extends Activity {
    WebView myWV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_example);

        myWV = (WebView)findViewById(R.id.webView);
        myWV.loadUrl("http://www.artifexdigital.com");
    }

}

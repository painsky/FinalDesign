package com.classtable.pain.finaldesign;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

/**
 * Created by pain on 2016/4/27.
 */
public class WebActivity extends Activity{
    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.whole_web);
        webView= (WebView) findViewById(R.id.webview);
        webView.loadUrl("http://210.40.2.253:8888");
    }
}

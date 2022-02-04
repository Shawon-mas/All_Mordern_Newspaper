package com.allnewspaper.allmordernnewspaper.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.allnewspaper.allmordernnewspaper.R;

public class NewsLoadActivity extends AppCompatActivity {
    WebView webView_load;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_load);
        webView_load=findViewById(R.id.webview);
        webView_load.loadUrl(getIntent().getStringExtra("Link"));
        WebSettings webSettings = webView_load.getSettings();
        webSettings.setJavaScriptEnabled(true);
        WebViewClient viewClient=new WebViewClient();
        webView_load.setWebViewClient(viewClient);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
package com.example.photosightflow;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;


import java.io.IOException;


public class MainActivity extends AppCompatActivity {

    private WebView webView;
    private int number = 7154993;
    String num = "";
    String scr = "";
    private Button frvBtn;
    private Button bckBtn;
    private Button frv10Btn;
    private Button bck10Btn;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView = findViewById(R.id.webView);
        frvBtn = findViewById(R.id.frvBtn);
        bckBtn = findViewById(R.id.bckBtn);
        frv10Btn = findViewById(R.id.frv10Btn);
        bck10Btn = findViewById(R.id.bck10Btn);
        webView.setWebViewClient(new WebViewClient());
        num = String.valueOf(number);

        webView.loadUrl("https://photosight.ru/photo/alone/" + num);
        frvBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number += 1;
                num = String.valueOf(number);
                webView.loadUrl("https://photosight.ru/photo/alone/" + num);
            }
        });
        bckBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number -= 1;
                num = String.valueOf(number);
                webView.loadUrl("https://photosight.ru/photo/alone/" + num);
            }
        });
        frv10Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number += 10;
                num = String.valueOf(number);
                webView.loadUrl("https://photosight.ru/photo/alone/" + num);
            }
        });
        bck10Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number -= 10;
                num = String.valueOf(number);
                webView.loadUrl("https://photosight.ru/photo/alone/" + num);
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
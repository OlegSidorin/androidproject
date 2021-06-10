package com.example.photosightflow;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;


public class MainActivity extends AppCompatActivity {

    private WebView webView;
    private int number = 7154993;
    String num = "";
    String scr = "";
    private Button frvBtn;
    private Button bckBtn;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView = findViewById(R.id.webView);
        frvBtn = findViewById(R.id.frvBtn);
        bckBtn = findViewById(R.id.bckBtn);
        textView = findViewById(R.id.textView);
        webView.setWebViewClient(new WebViewClient());
        num = String.valueOf(number);
        String title = "privet";
/*
        Document doc = null;
        try {
            doc = Jsoup.connect("http://example.com/").get();
        } catch (IOException e) {
            e.printStackTrace();
        }


        title = doc.title();

        if (title == null) {
            title = "rrrrrr";
        }
        textView.setText(title);

 */
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
package com.example.firebase;

import android.os.Bundle;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

public class websites extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_websites);

            Bundle b=getIntent().getExtras();
            //    String num=b.getString("i");
            int n=getIntent().getIntExtra("i", 0);
            WebView myWebView = (WebView) findViewById(R.id.webView);
            myWebView.setInitialScale(1);
            myWebView.getSettings().setJavaScriptEnabled(true);
            myWebView.getSettings().setLoadWithOverviewMode(true);
            myWebView.getSettings().setUseWideViewPort(true);
            myWebView.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
            myWebView.setScrollbarFadingEnabled(false);
            if(n==0){
                myWebView.loadUrl("https://www.codechef.com/problems/school/?itm_medium=navmenu&itm_campaign=problems");
            }
            else if(n==1){
                myWebView.loadUrl("https://codeforces.com/problemset");
            }
            else if(n==2){
                myWebView.loadUrl("https://projecteuler.net/archives");
            }
            else if(n==3){
                myWebView.loadUrl("https://leetcode.com/problemset/all/");
            }
            else if(n==4){
                myWebView.loadUrl("https://coderbyte.com/challenges");
            }
            else if(n==5){
                myWebView.loadUrl("https://open.kattis.com/problems");
            }
            else if(n==6){
                myWebView.loadUrl("https://www.codechef.com/");
            }
            else if(n==7){
                myWebView.loadUrl("https://www.spoj.com/problems/classical/");
            }
        }

    }

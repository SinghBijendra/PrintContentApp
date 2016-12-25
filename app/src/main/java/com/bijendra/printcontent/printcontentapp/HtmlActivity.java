package com.bijendra.printcontent.printcontentapp;

import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintJob;
import android.print.PrintManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class HtmlActivity extends AppCompatActivity {
    private static final String TAG =HtmlActivity.class.toString() ;
    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_html);

        mWebView= (WebView) findViewById(R.id.webView);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.loadUrl("file:///android_asset/test_print.html");
      
    }
   

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_print,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.actionPrint)
        {
            printHtmlContent();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void printHtmlContent() {
        PrintManager pManager= (PrintManager) getSystemService(PRINT_SERVICE);
        PrintDocumentAdapter pDocAdapter=mWebView.createPrintDocumentAdapter();
        String pWork=getString(R.string.title_activity_html);
        pManager.print(pWork,pDocAdapter, new PrintAttributes.Builder().build());

     }
}

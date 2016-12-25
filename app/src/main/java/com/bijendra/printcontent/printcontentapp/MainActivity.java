package com.bijendra.printcontent.printcontentapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void gotoAction(View view)
    {
        if(view.getTag().toString().equalsIgnoreCase("0"))
            startActivity(new Intent(this,PhotoActivity.class));
        if(view.getTag().toString().equalsIgnoreCase("1"))
            startActivity(new Intent(this,HtmlActivity.class));
        if(view.getTag().toString().equalsIgnoreCase("2"))
            startActivity(new Intent(this,ScreenPrintActivity.class));

    }
}

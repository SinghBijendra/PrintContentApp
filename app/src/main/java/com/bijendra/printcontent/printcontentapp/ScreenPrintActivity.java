package com.bijendra.printcontent.printcontentapp;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.print.PrintHelper;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

public class ScreenPrintActivity extends AppCompatActivity {

    LinearLayout mLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_print);
        mLayout= (LinearLayout) findViewById(R.id.activity_main);
        mLayout.setDrawingCacheEnabled(true);
        
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
            printScreenContent();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void printScreenContent() {

        try {
            /*
        SCALE_MODE_FIT - This option sizes the image so that the whole image is shown within the printable area of the page.
       SCALE_MODE_FILL - This option scales the image so that it fills the entire printable area of the page. Choosing this
       setting means that some portion of the top and bottom, or left and right edges of the image is not printed.
       This option is the default value if you do not set a scale mode.
        */
            Bitmap bitmap = Bitmap.createBitmap(mLayout.getDrawingCache());
            CUtils.printImage(this,bitmap,PrintHelper.SCALE_MODE_FIT);

        } catch (Throwable e) {
            // Several error may come out with file handling or OOM
            e.printStackTrace();
        }

    }

}

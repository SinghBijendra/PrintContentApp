package com.bijendra.printcontent.printcontentapp;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.print.PrintHelper;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

public class PhotoActivity extends AppCompatActivity {

    private ImageView mIvPhoto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);
        mIvPhoto= (ImageView) findViewById(R.id.ivPhoto);
        mIvPhoto.setDrawingCacheEnabled(true);

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
            printPhoto();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * This function is used to call print ,to print image
     */
    private void printPhoto() {
        /*
        SCALE_MODE_FIT - This option sizes the image so that the whole image is shown within the printable area of the page.
       SCALE_MODE_FILL - This option scales the image so that it fills the entire printable area of the page. Choosing this
       setting means that some portion of the top and bottom, or left and right edges of the image is not printed.
       This option is the default value if you do not set a scale mode.
        */
        Bitmap bitmap= mIvPhoto.getDrawingCache();
        CUtils.printImage(this,bitmap,PrintHelper.SCALE_MODE_FIT);


    }
}

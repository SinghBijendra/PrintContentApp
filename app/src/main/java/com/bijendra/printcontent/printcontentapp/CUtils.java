package com.bijendra.printcontent.printcontentapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.print.PrintHelper;

/**
 * Created by Newdream on 25-Dec-16.
 */

public class CUtils {

    /**
     * This function is used to print passed image
     * @param context
     * @param bitmap
     * @param scaleType
     */
    public static  void printImage(Context context, Bitmap bitmap, int scaleType) {
        PrintHelper pHelper=new PrintHelper(context);
        pHelper.setScaleMode(scaleType);
        pHelper.printBitmap("test-image",bitmap);

    }
}

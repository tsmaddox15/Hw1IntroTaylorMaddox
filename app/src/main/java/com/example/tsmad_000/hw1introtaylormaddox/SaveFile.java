package com.example.tsmad_000.hw1introtaylormaddox;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Environment;
import android.util.Log;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.io.File;

public class SaveFile {
    private Context thisCtx;
    private String pFolder = "/hw1";

    public void saveImage(Context ctx, Bitmap image) {
        thisCtx = ctx;
        String filePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        SimpleDateFormat dtFormat = new SimpleDateFormat("HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        String dt = dtFormat.format(calendar.getTime());
        Log.d("myTag", filePath + pFolder);
        File dir = new File(filePath + pFolder);
        if (!dir.exists()) {
            Log.d("myTag", "Making dir.");
            dir.mkdir();
        }
        File file = new File(dir, dt + ".jpg");
        try {
            FileOutputStream os = new FileOutputStream(file);
            image.compress(Bitmap.CompressFormat.JPEG, 100, os);
            os.flush();
            os.close();
        } catch (Exception e) {

        }

    }

}


package com.example.tsmad_000.hw1introtaylormaddox;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class part2 extends AppCompatActivity {
    touchView newTouchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part2);
        newTouchView = new touchView(this, null);
        setContentView(newTouchView);
        setTitle("Hw 1 Part 2 Taylor Maddox");
    }

    //creates actionbar
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.app_bar_menu, menu);
        return true;
    }

    //Determine what option in action bar is selected.
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.clear_canvas) {
            recreate();
            Log.d("test", "howdy");
            return true;
        } else if (id == R.id.save_image) {
            touchView newTouchView = new touchView(this, null);
            Bitmap bitmap = newTouchView.getBitmap();
            SaveFile save = new SaveFile();
            save.saveImage(this, bitmap);
        } else if (id == R.id.change_color) {
            Intent intent = new Intent(this, Pop.class);
            startActivityForResult(intent, 2);
        }

        return super.onOptionsItemSelected(item);
    }

    //Receives the results of Pop.java for color change.
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null) {
            int red = data.getIntExtra("red", 0);
            int green = data.getIntExtra("green", 0);
            int blue = data.getIntExtra("blue", 0);
            newTouchView.setColor(red, green, blue);
        }

    }
}

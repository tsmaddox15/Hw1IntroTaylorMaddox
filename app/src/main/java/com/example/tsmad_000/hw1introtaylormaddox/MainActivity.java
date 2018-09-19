package com.example.tsmad_000.hw1introtaylormaddox;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button b1;
    Button b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = (Button) findViewById(R.id.button);
        b2 = (Button) findViewById(R.id.button2);

    }

    //Switches between activities.
    public void selection(View view) {
        switch (view.getId()) {
            case R.id.button:
                Log.d("myTag", "Part 1");
                Intent intent = new Intent(this, part1.class);
                // It will open the activity
                startActivity(intent);
                break;


            case R.id.button2:
                Log.d("myTag", "Part 2");
                Intent intent2 = new Intent(this, part2.class);
                // It will open the activity
                startActivity(intent2);
                break;
        }
    }


}

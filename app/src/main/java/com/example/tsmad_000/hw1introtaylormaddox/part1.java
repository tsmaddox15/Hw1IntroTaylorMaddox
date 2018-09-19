package com.example.tsmad_000.hw1introtaylormaddox;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class part1 extends AppCompatActivity {
    Button color;
    EditText textC;
    TextView currentC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part1);
        setTitle("Hw 1 Part 1 Taylor Maddox");
        color = (Button) findViewById(R.id.color);
        textC = (EditText) findViewById(R.id.textC);
        currentC = (TextView) findViewById(R.id.currentC);
    }

    public void changeColor(View view) {
        Random random = new Random();
        //Amount of red,green,blue for the random color.
        int redC = random.nextInt(256);
        int greenC = random.nextInt(256);
        int blueC = random.nextInt(256);
        int color = Color.argb(255, redC, greenC, blueC);
        textC.setTextColor(color);
        String hexC = String.format("#%02x%02x%02x", redC, greenC, blueC);
        currentC.setText("Current Color: " + redC + "r, " + greenC + "g, " + blueC + "b " + " Hex: " + hexC);
    }
}

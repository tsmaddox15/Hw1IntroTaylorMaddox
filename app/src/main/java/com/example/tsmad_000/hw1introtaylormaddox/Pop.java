package com.example.tsmad_000.hw1introtaylormaddox;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Pop extends Activity {
    TextView textR;
    TextView textG;
    TextView textB;
    EditText editR;
    EditText editG;
    EditText editB;
    part2 newPart2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popwindow);
        textR = (TextView) findViewById(R.id.textR);
        textG = (TextView) findViewById(R.id.textG);
        textB = (TextView) findViewById(R.id.textB);
        editR = (EditText) findViewById(R.id.editR);
        editG = (EditText) findViewById(R.id.editG);
        editB = (EditText) findViewById(R.id.editBlue);
        newPart2 = new part2();
        //Sets dimensions on pop up.
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        double width = dm.widthPixels;
        double height = dm.heightPixels;
        getWindow().setLayout((int) (width), (int) (height));
    }

    public void pickColor(View view) {
        //Gets int value of edit views
        String strR = (String) editR.getText().toString();
        String strG = (String) editG.getText().toString();
        String strB = (String) editB.getText().toString();
        int intR = Integer.parseInt(strR);
        int intG = Integer.parseInt(strG);
        int intB = Integer.parseInt(strB);

        //Bundles and sends the int values to part2.java
        Intent resultIntent = new Intent();
        Bundle b = new Bundle();
        b.putInt("red", intR);
        b.putInt("green", intG);
        b.putInt("blue", intB);
        resultIntent.putExtras(b);
        setResult(part2.RESULT_OK, resultIntent);
        finish();
    }
}

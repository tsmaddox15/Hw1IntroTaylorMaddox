package com.example.tsmad_000.hw1introtaylormaddox;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

public class touchView extends View {
    public Paint paint = new Paint();
    private Path path = new Path();
    private Bitmap mBitmap = Bitmap.createBitmap(1080, 1080, Bitmap.Config.ARGB_8888);
    public Canvas c;
    private List<Stroke> allStrokes;
    private ArrayList<Path> paths = new ArrayList<Path>();
    private SparseArray<Stroke> activeStrokes;
    private int red;
    private int green;
    private int blue;

    public touchView(Context ctx, AttributeSet attrs) {
        super(ctx, attrs);
        allStrokes = new ArrayList<Stroke>();
        activeStrokes = new SparseArray<Stroke>();
        paint.setColor(Color.BLACK);
        paint.setAntiAlias(true);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(4f);
        paths.add(path);
        c = new Canvas(mBitmap);
        c.drawColor(Color.WHITE);
    }

    //Sets globals from Pop.java.
    public void setColor(int r, int g, int b) {
        this.red = r;
        this.blue = b;
        this.green = g;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.WHITE);
        if (allStrokes != null) {
            for (Stroke stroke : allStrokes) {
                if (stroke != null) {
                    Path path = stroke.getPath();
                    Paint painter = stroke.getPaint();
                    if ((path != null) && (painter != null)) {
                        canvas.drawPath(path, painter);
                        super.onDraw(canvas);
                    }
                }
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        final int action = event.getActionMasked();
        final int pointerCount = event.getPointerCount();
        switch (action) {

            case MotionEvent.ACTION_DOWN: {
                pointDown((int) event.getX(), (int) event.getY(), event.getPointerId(0));
                break;
            }
            case MotionEvent.ACTION_MOVE: {
                for (int pc = 0; pc < pointerCount; pc++) {
                    pointMove((int) event.getX(pc), (int) event.getY(pc), event.getPointerId(pc));
                }
                break;
            }
            case MotionEvent.ACTION_POINTER_DOWN: {
                for (int pc = 0; pc < pointerCount; pc++) {
                    pointDown((int) event.getX(pc), (int) event.getY(pc), event.getPointerId(pc));
                }
                break;
            }
            case MotionEvent.ACTION_UP: {
                break;
            }
            case MotionEvent.ACTION_POINTER_UP: {
                break;
            }
        }
        invalidate();
        return true;
    }

    private void pointDown(int x, int y, int id) {
        //Makes a new paint for the stroke.
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10);
        paint.setColor(Color.argb(255, red, green, blue));

        //creates a Stroke to be stored.
        Point pt = new Point(x, y);
        Stroke stroke = new Stroke(paint);
        stroke.addPoint(pt);
        activeStrokes.put(id, stroke);
        allStrokes.add(stroke);
    }

    private void pointMove(int x, int y, int id) {
        //retrieve the stroke and add a new point to its path
        Stroke stroke = activeStrokes.get(id);
        if (stroke != null) {
            Point pt = new Point(x, y);
            stroke.addPoint(pt);
        }
    }

    public Bitmap getBitmap() {
        return mBitmap;
    }
}



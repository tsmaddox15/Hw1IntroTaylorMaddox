package com.example.tsmad_000.hw1introtaylormaddox;

import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;

public class Stroke {
    private Path path;
    private Paint paint;

    public Stroke(Paint paint) {
        this.paint = paint;
    }

    public Path getPath() {
        return path;
    }

    public Paint getPaint() {
        return paint;
    }

    public void addPoint(Point pt) {
        if (path == null) {
            path = new Path();
            path.moveTo(pt.x, pt.y);
        } else {
            path.lineTo(pt.x, pt.y);
        }
    }
}

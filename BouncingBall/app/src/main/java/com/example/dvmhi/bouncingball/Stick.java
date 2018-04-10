package com.example.dvmhi.bouncingball;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

public class Stick {
    private int x=1000, y=1000, width, height;

    public Stick(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void Draw(Canvas canvas, Paint paint, String color) {
        paint.setColor(Color.parseColor(color));
        canvas.drawRect(new RectF(x, y, x + width, y + height), paint);
    }
}

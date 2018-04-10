package com.example.dvmhi.bouncingball;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Ball {
    private int x=100, y=100, dx=10, dy=10, radius;

    public Ball(int x, int y, int dx, int dy, int radius) {
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
        this.radius = radius;
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

    public int getDx() {
        return dx;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public int getDy() {
        return dy;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public void Move() {
            x += dx;
            y += dy;
    }

    public void CheckHitWall(int wallWidth, int wallHeight) {
        if(x>wallWidth || x<0)
            dx=-dx;

        if(y>wallHeight || y<0)
            dy=-dy;
    }

    public void changeDirection() {
        dx=-dx;
        dy=-dy;
    }

    public void checkHitBall(Ball anotherBall) {
        if (Math.sqrt(Math.pow(this.x - anotherBall.getX(),2) + Math.pow(this.y - anotherBall.getY(),2)) < 100){
            changeDirection();
            anotherBall.changeDirection();
        }
    }

    public void checkHitStick (Stick stick) {
        if ((this.x>stick.getX()&&this.x<this.x+stick.getWidth())&&(this.y>stick.getY()&&this.y<this.y+this.radius)) {
            dy=-dy;
        }
    }

    public void Draw(Canvas canvas, Paint paint, String color) {
        paint.setColor(Color.parseColor(color));
        canvas.drawCircle(x, y, radius, paint);
    }
}
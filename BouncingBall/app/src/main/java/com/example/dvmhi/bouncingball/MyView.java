package com.example.dvmhi.bouncingball;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class MyView extends View {

    private Ball ball1, ball2;
    private Stick stick;
    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        ball1 = new Ball(100, 100, 15, 15, 50);
        ball2 = new Ball(1000, 1200, 20, 20, 50);
        stick = new Stick(300, 1500, 500, 50);
    }

    @Override

    protected void onDraw(Canvas canvas) {

        // TODO Auto-generated method stub

        super.onDraw(canvas);

        Paint paint = new Paint();

        paint.setStyle(Paint.Style.FILL);

        paint.setColor(Color.WHITE);

        canvas.drawPaint(paint);
        // Use Color.parseColor to define HTML colors

        stick.Draw(canvas, paint, "#000000");

        ball1.Draw(canvas, paint, "#2A4390");
        ball1.Move();
        ball1.CheckHitWall(this.getWidth(), this.getHeight());

        ball2.Draw(canvas, paint, "#B22222");
        ball2.Move();
        ball2.CheckHitWall(this.getWidth(), this.getHeight());

        ball1.checkHitBall(ball2);

        ball1.checkHitStick(stick);
        ball2.checkHitStick(stick);

        invalidate();
    }

    @Override
    protected void onSizeChanged(int xNew, int yNew, int xOld, int yOld){
        stick.setX((this.getWidth())/2);
        stick.setY(this.getHeight() - 100);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        boolean handled = false;

        int xTouch;
        int yTouch;
        int actionIndex = event.getActionIndex();


        switch (event.getActionMasked()) {
            case MotionEvent.ACTION_DOWN:

                xTouch = (int) event.getX(0);
                yTouch = (int) event.getY(0);

                handled = true;
                break;

            case MotionEvent.ACTION_POINTER_DOWN:
                xTouch = (int) event.getX(actionIndex);
                yTouch = (int) event.getY(actionIndex);

                handled = true;
                break;

            case MotionEvent.ACTION_MOVE:
                final int pointerCount = event.getPointerCount();

                for (actionIndex = 0; actionIndex < pointerCount; actionIndex++) {

                    xTouch = (int) event.getX(actionIndex);
                    yTouch = (int) event.getY(actionIndex);

                    stick.setX(xTouch);
                }


                invalidate();
                handled = true;
                break;

            case MotionEvent.ACTION_UP:

                invalidate();
                handled = true;
                break;

            case MotionEvent.ACTION_POINTER_UP:

                invalidate();
                handled = true;
                break;

            case MotionEvent.ACTION_CANCEL:

                handled = true;
                break;

            default:
                // do nothing
                break;
        }

        return super.onTouchEvent(event) || handled;
    }
}
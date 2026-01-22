package com.flappygit.app;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class GameView extends View {

    private Paint paint;
    private float playerY;
    private float velocity = 0;
    private float gravity = 1.2f;

    public GameView(Context context) {
        super(context);
        paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setAntiAlias(true);
        playerY = 300;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // fond
        canvas.drawColor(Color.parseColor("#1DB954"));

        // gravité
        velocity += gravity;
        playerY += velocity;

        // sol
        if (playerY > getHeight() - 100) {
            playerY = getHeight() - 100;
            velocity = 0;
        }

        // joueur (cercle)
        canvas.drawCircle(200, playerY, 40, paint);

        invalidate(); // boucle du jeu
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            velocity = -20; // saut
        }
        return true;
    }
          }

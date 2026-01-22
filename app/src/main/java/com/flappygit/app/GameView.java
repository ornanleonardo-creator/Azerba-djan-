package com.flappygit.app;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
    private Bitmap player;

    public GameView(Context context) {
        super(context);
        paint = new Paint();
        paint.setAntiAlias(true);
        playerY = 300;

        player = BitmapFactory.decodeResource(getResources(), R.drawable.player);
        player = Bitmap.createScaledBitmap(player, 80, 80, false);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // Fond vert
        canvas.drawColor(Color.parseColor("#1DB954"));

        // Physique
        velocity += gravity;
        playerY += velocity;

        if (playerY > getHeight() - 100) {
            playerY = getHeight() - 100;
            velocity = 0;
        }

        // Dessiner le joueur
        canvas.drawBitmap(player, 150, playerY, null);

        invalidate();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            velocity = -20;
        }
        return true;
    }
}

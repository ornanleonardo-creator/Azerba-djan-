package com.flappygit.app;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView t = new TextView(this);
        t.setText("FlappyGit démarre !");
        t.setTextSize(24);
        setContentView(t);
    }
}

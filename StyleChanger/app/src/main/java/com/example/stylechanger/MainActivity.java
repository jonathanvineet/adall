package com.example.stylechanger;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    LinearLayout layout; TextView tvSample;
    int colorIdx = 0, styleIdx = 0; float fontSize = 18f;
    int[] colors = {Color.YELLOW, Color.CYAN, Color.GREEN, Color.WHITE};
    int[] styles = {Typeface.NORMAL, Typeface.BOLD, Typeface.ITALIC, Typeface.BOLD_ITALIC};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layout  = findViewById(R.id.layout);     // add id="@+id/layout" to LinearLayout
        tvSample = findViewById(R.id.tvSample);

        findViewById(R.id.btnColor).setOnClickListener(v -> {
            layout.setBackgroundColor(colors[colorIdx++ % colors.length]);
        });
        findViewById(R.id.btnFont).setOnClickListener(v -> {
            tvSample.setTypeface(null, styles[styleIdx++ % styles.length]);
        });
        findViewById(R.id.btnSize).setOnClickListener(v -> {
            fontSize = (fontSize >= 30f) ? 14f : fontSize + 4f;
            tvSample.setTextSize(fontSize);
        });
    }
}

package com.example.mir.colorcreator;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.SeekBar;
import android.widget.TableLayout;
import android.widget.TextView;

import static com.example.mir.colorcreator.R.id.tv;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {
    int N = 3;
    TextView[] tvColorText = new TextView[N];
    TextView[] Rnumber = new TextView[N];
    NumberPicker[] Number = new NumberPicker[N];
    SeekBar[] ColorEdit = new SeekBar[N];
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvColorText[0] = (TextView) findViewById(R.id.tvColorRText);
        tvColorText[1] = (TextView) findViewById(R.id.tvColorGText);
        tvColorText[2] = (TextView) findViewById(R.id.tvColorBText);

        Rnumber[0] = (TextView) findViewById(R.id.tvRnumber);
        Rnumber[1] = (TextView) findViewById(R.id.tvGnumber);
        Rnumber[2] = (TextView) findViewById(R.id.tvBnumber);

        ColorEdit[0] = (SeekBar) findViewById(R.id.seekRed);
        ColorEdit[1] = (SeekBar) findViewById(R.id.seekGreen);
        ColorEdit[2] = (SeekBar) findViewById(R.id.seekBlue);

        ColorEdit[0].setOnSeekBarChangeListener(this);
        ColorEdit[1].setOnSeekBarChangeListener(this);
        ColorEdit[2].setOnSeekBarChangeListener(this);
        tv = (TextView) findViewById(R.id.tv);
    }


    @Override
    public void onProgressChanged(SeekBar seekbar, int progress, boolean fromUser) {

        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = ColorEdit[i].getProgress();
        }
        for (int i = 0; i < N; i++) {
            Rnumber[i].setText(String.valueOf(ColorEdit[i].getProgress())+"\n"+Integer.toHexString(a[i]));
        }
        tv.setTextColor(Color.rgb(255 - ColorEdit[0].getProgress(), 255 - ColorEdit[1].getProgress(), 255 - ColorEdit[2].getProgress()));
        tv.setText("Color #"+Integer.toHexString(a[0]) + Integer.toHexString(a[1]) + Integer.toHexString(a[2]));
        tv.setBackgroundColor(Color.rgb(ColorEdit[0].getProgress(), ColorEdit[1].getProgress(), ColorEdit[2].getProgress()));
        tvColorText[0].setTextColor((Color.rgb(ColorEdit[0].getProgress(), 0, 0)));
        tvColorText[1].setTextColor((Color.rgb(0, ColorEdit[1].getProgress(), 0)));
        tvColorText[2].setTextColor((Color.rgb(0, 0, ColorEdit[2].getProgress())));
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}

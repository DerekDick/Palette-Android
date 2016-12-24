package com.example.derekdick.palette;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {
    private View palette;
    private View red;

    private View green;
    private View blue;
    private SeekBar seekBarRed;
    private SeekBar seekBarGreen;
    private SeekBar seekBarBlue;
    private TextView textViewRGB;
    private TextView textViewR;
    private TextView textViewG;
    private TextView textViewB;
    private TextView textViewRNum;
    private TextView textViewGNum;
    private TextView textViewBNum;
    private String colorRGB = "#000000";
    private String colorR = "00";
    private String colorG = "00";
    private String colorB = "00";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the private views
        initViews();

        // Set listeners
        seekBarRed.setOnSeekBarChangeListener(this);
        seekBarGreen.setOnSeekBarChangeListener(this);
        seekBarBlue.setOnSeekBarChangeListener(this);
    }

    private void initViews() {
        // Initialize the private views
        palette = findViewById(R.id.palette);
        red = findViewById(R.id.red);
        green = findViewById(R.id.green);
        blue = findViewById(R.id.blue);
        seekBarRed = (SeekBar) findViewById(R.id.seek_bar_red);
        seekBarGreen = (SeekBar) findViewById(R.id.seek_bar_green);
        seekBarBlue = (SeekBar) findViewById(R.id.seek_bar_blue);
        textViewRGB = (TextView) findViewById(R.id.text_rgb);
        textViewR = (TextView) findViewById(R.id.text_r);
        textViewG = (TextView) findViewById(R.id.text_g);
        textViewB = (TextView) findViewById(R.id.text_b);
        textViewRNum = (TextView) findViewById(R.id.text_r_num);
        textViewGNum = (TextView) findViewById(R.id.text_g_num);
        textViewBNum = (TextView) findViewById(R.id.text_b_num);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        switch (seekBar.getId()) {
            // Red
            case R.id.seek_bar_red: {
                colorR = Integer.toHexString((progress & 0x000000FF) | 0xFFFFFF00).substring(6);
                red.setBackgroundColor(Color.parseColor("#" + colorR + "0000"));
                textViewR.setText("0x" + colorR);
                textViewR.setTextColor(Color.parseColor("#" + colorR + "0000"));
                textViewRNum.setText(String.valueOf(progress));
                textViewRNum.setTextColor(Color.parseColor("#" + colorR + "0000"));

                break;
            }

            // Green
            case R.id.seek_bar_green: {
                colorG = Integer.toHexString((progress & 0x000000FF) | 0xFFFFFF00).substring(6);
                green.setBackgroundColor(Color.parseColor("#00" + colorG + "00"));
                textViewG.setText("0x" + colorG);
                textViewG.setTextColor(Color.parseColor("#00" + colorG + "00"));
                textViewGNum.setText(String.valueOf(progress));
                textViewGNum.setTextColor(Color.parseColor("#00" + colorG + "00"));

                break;
            }

            // Blue
            case R.id.seek_bar_blue: {
                colorB = Integer.toHexString((progress & 0x000000FF) | 0xFFFFFF00).substring(6);
                blue.setBackgroundColor(Color.parseColor("#0000" + colorB));
                textViewB.setText("0x" + colorB);
                textViewB.setTextColor(Color.parseColor("#0000" + colorB));
                textViewBNum.setText(String.valueOf(progress));
                textViewBNum.setTextColor(Color.parseColor("#0000" + colorB));

                break;
            }

            // Exceptions
            default: {
                break;
            }
        }
        // Mix the color
        int r = ((ColorDrawable) red.getBackground()).getColor();
        int g = ((ColorDrawable) green.getBackground()).getColor();
        int b = ((ColorDrawable) blue.getBackground()).getColor();
        palette.setBackgroundColor(r + g + b);
        colorRGB = "#" + colorR + colorG + colorB;
        textViewRGB.setText(colorRGB);
        textViewRGB.setTextColor(r + g + b);
    }
}

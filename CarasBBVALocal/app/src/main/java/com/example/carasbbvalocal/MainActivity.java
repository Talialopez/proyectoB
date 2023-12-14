package com.example.carasbbvalocal;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private int score = 0;
    private TextView tvScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int orientation = getResources().getConfiguration().orientation;
        if(orientation == Configuration.ORIENTATION_LANDSCAPE){
            setContentView(R.layout.activity_main);
        } else {
            setContentView(R.layout.activity_main);
        }
    }

    public void onOkClick(View view) {
        score += 3;
        logScore();
    }

    public void onNeutralClick(View view) {
        score += 2;
        logScore();
    }


    public void onDisagreementClick(View view) {
        score += 1;
        logScore();
    }

    private String getFormattedDateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        return sdf.format(new Date());
    }

    private void logScore() {
        String formattedDateTime = getFormattedDateTime();
        Log.d("prueba", ("Current Score: " + score + " | Date and Time: " + formattedDateTime));
    }
}


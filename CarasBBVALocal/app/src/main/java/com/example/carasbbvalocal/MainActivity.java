package com.example.carasbbvalocal;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private int score = 0;
    private int voto = 0;
    private TextView tvScore;

    private TextView tittleEn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int orientation = getResources().getConfiguration().orientation;
        if(orientation == Configuration.ORIENTATION_LANDSCAPE){
            setContentView(R.layout.activity_main_land);
        } else {
            setContentView(R.layout.activity_main);
        }

        tittleEn = findViewById(R.id.tittle);
    }

    private void actualizarResource(String idioma) {
        Resources recursos = getResources();
        Configuration configuracion = recursos.getConfiguration();
        Locale locale = new Locale(idioma);
        configuracion.setLocale(locale);
        recursos.updateConfiguration(configuracion, recursos.getDisplayMetrics());

        tittleEn.setText(recursos.getString(R.string.tittle));

    }

    public void onOkClick(View view) {
        score += 3;
        voto=3;
        logScore();
        lanzarGrateful();
    }

    private void lanzarGrateful() {
    }

    public void onNeutralClick(View view) {
        score += 2;
        voto=2;
        logScore();
        lanzarGrateful();
    }


    public void onDisagreementClick(View view) {
        score += 1;
        voto=1;
        logScore();
        lanzarGrateful();
    }

    private String getFormattedDateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        return sdf.format(new Date());
    }

    private void logScore() {
        String formattedDateTime = getFormattedDateTime();
        Log.d("prueba", ("Su voto: " + voto +" | Puntuación total: " + score + " | Date and Time: " + formattedDateTime));
    }

  
    private void lanzarGrateful() {

                Intent intent = new Intent(MainActivity.this, grateful_activity.class);
                startActivity(intent);
                finish();
    }
}



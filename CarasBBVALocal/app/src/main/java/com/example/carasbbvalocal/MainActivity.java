package com.example.carasbbvalocal;

import android.content.ContentValues;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private int voto = 0;
    private String servicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Valores que recibe
         servicio = getIntent().getStringExtra("servicio");


        // Lógica de la actividad

        int orientation = getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            setContentView(R.layout.activity_main_land);
        } else {
            setContentView(R.layout.activity_main_land);
        }

        Spinner languageSpinner = findViewById(R.id.languageSpinner);

        // Opciones Spinner creando un array de languages
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.languages,
                R.layout.spinner_items
        );
        adapter.setDropDownViewResource(R.layout.spiner_item_selected);
        languageSpinner.setAdapter(adapter);

        languageSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String selectedLanguage = (String) parentView.getItemAtPosition(position);
                //updateTexts(selectedLanguage);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
            }
        });
    }
/*
    private void updateTexts(String selectedLanguage) {
        TextView titleTextView = findViewById(R.id.tittle);

        // ID segun el idioma seleccionado
        int titleResourceId;
        if (selectedLanguage.equalsIgnoreCase("Inglés")) {
            titleResourceId = R.string.tittle_ingles;
        } else if (selectedLanguage.equalsIgnoreCase("Gallego")) {
            titleResourceId = R.string.tittle_gallego;
        } else if (selectedLanguage.equalsIgnoreCase("Catalán")) {
            titleResourceId = R.string.tittle_catalan;
        } else if (selectedLanguage.equalsIgnoreCase("Euskera")) {
            titleResourceId = R.string.tittle_euskera;
        } else {
            // Por defecto, título en español
            titleResourceId = R.string.tittle;
        }

        // Actualizar el texto de la pantalla
        titleTextView.setText("Valora nuestro servicio");
    }
*/
    public void onOkClick(View view) {
        voto = 3;
        //logScore();
        guardarBBDD(getFormattedDateTime(), servicio, voto);
        lanzarGrateful();
    }

    public void onNeutralClick(View view) {
        voto = 2;
        //logScore();
        guardarBBDD(getFormattedDateTime(), servicio, voto);
        lanzarGrateful();
    }

    public void onDisagreementClick(View view) {
        voto = 1;
        //logScore();
        guardarBBDD(getFormattedDateTime(), servicio, voto);
        lanzarGrateful();
    }

    private String getFormattedDateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        return sdf.format(new Date());
    }

    /* PRUEBA SIN BBDD
    private void logScore() {
        String formattedDateTime = getFormattedDateTime();
        Log.d("prueba", ("Su voto: " + voto +" | Date and Time: " + formattedDateTime));
    }
    */

    private void lanzarGrateful() {
        Intent intent = new Intent(MainActivity.this, grateful_activity.class);
        intent.putExtra("servicio", servicio);
        intent.putExtra("puntuacion", voto);
        //Toast.makeText(this, "Ha seleccionado " + servicio + " con puntuación de " + voto, Toast.LENGTH_SHORT).show();
        startActivity(intent);
        finish();
    }

    private void guardarBBDD(String fecha, String servicio, int valoracion) {
        BaseDatos admin = new BaseDatos(this, "bd", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        ContentValues reg = new ContentValues();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String fechaActual = dateFormat.format(new Date());

        // Insertar los datos en la base de datos
        reg.put("FECHA", fechaActual);
        reg.put("SERVICIO", servicio);
        reg.put("VALORACION", valoracion);

        // Insertar el registro en la tabla
        bd.insert("Valoraciones", null, reg);
        bd.close();
    }
}




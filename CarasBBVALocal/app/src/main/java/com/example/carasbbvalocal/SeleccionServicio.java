package com.example.carasbbvalocal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class SeleccionServicio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccion_servicio);
        // Establecer la orientación en horizontal
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    }

    public void onReconocimientoClick(View view) {
        //Toast.makeText(this, "Ha seleccionado reconocimiento médico", Toast.LENGTH_SHORT).show();
        lanzarMain("reconocimiento");
    }

    public void onConsultaClick(View view) {
        //Toast.makeText(this, "Ha seleccionado consulta médica", Toast.LENGTH_SHORT).show();
        lanzarMain("consulta");
    }

    public void onEnfermeriaClick(View view) {
        //Toast.makeText(this, "Ha seleccionado consulta de enfermeria", Toast.LENGTH_SHORT).show();
        lanzarMain("enfermeria");
    }

    private void lanzarMain(String servicio) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("servicio", servicio);
        startActivity(intent);
        finish();
    }
}
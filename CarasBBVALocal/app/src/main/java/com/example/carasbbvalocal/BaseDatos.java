package com.example.carasbbvalocal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BaseDatos extends SQLiteOpenHelper {

    private static final String tablaValoraciones = "CREATE TABLE Valoraciones" +
            "(ID INTEGER PRIMARY KEY AUTOINCREMENT," +
            "FECHA DATE," +
            "SERVICIO TEXT," +
            "VALORACION INT)";

    public BaseDatos(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(tablaValoraciones);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Código para actualizar la base de datos cuando cambie la versión
    }
}
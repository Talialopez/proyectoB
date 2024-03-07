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
        // Aquí puedes escribir el código para actualizar la base de datos cuando cambie la versión
        // Por ejemplo, puedes eliminar las tablas existentes y crearlas de nuevo o modificarlas según sea necesario
    }
}

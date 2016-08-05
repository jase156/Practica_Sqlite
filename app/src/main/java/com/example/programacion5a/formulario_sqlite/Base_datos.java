package com.example.programacion5a.formulario_sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by programacion5a on 02/08/16.
 */
public class Base_datos extends SQLiteOpenHelper{
    public Base_datos(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("create table persona(id auto_increment primary key, Nombre text, apellido text, direccion text, correo text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}

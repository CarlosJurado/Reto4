package com.example.reto4.Modelo.BaseDatos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MotorBaseDatosSQLite extends SQLiteOpenHelper {

    public MotorBaseDatosSQLite(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        /* ====================================================================================================== */
        //TABLA FAVORITOS
        db.execSQL("CREATE TABLE favoritos (id INT, titulo TEXT,descripcion TEXT)");

        /* ====================================================================================================== */
        //TABLA PRODUCTOS
        db.execSQL("CREATE TABLE productos (imagen INT, titulo TEXT,descripcion TEXT)");
        //---- Registros
        db.execSQL("INSERT INTO productos VALUES ( 0, 'Desayunos','Desayuno Especial y Continental')");
        db.execSQL("INSERT INTO productos VALUES ( 1, 'Almuerzos','Almuerzos Ejecutivos y Asados')");
        db.execSQL("INSERT INTO productos VALUES ( 2, 'Tortas','Exquisitas Tortas')");
        db.execSQL("INSERT INTO productos VALUES ( 3, 'Bebidas','Las Mejores Bebidas')");

        /* ====================================================================================================== */
        //TABLA SERVICIOS
        db.execSQL("CREATE TABLE servicios (imagen INT, titulo TEXT,descripcion TEXT)");
        //---- Registros
        db.execSQL("INSERT INTO servicios VALUES (0, 'Cumpleaños','Decoramos sus cumpleaños.')");
        db.execSQL("INSERT INTO servicios VALUES (1, 'Bodas','Planeamos sus bodas.')");
        db.execSQL("INSERT INTO servicios VALUES (2, 'Empresariales','Organizamos sus eventos empresariales.')");
        db.execSQL("INSERT INTO servicios VALUES (3, 'Musica','Ambientamos con la mejor música.')");
        /* ====================================================================================================== */
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE favoritos");
        db.execSQL("DROP TABLE productos");
        db.execSQL("DROP TABLE servicios");
        onCreate(db);

    }
}

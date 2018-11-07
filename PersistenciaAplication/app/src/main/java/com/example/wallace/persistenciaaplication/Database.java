package com.example.wallace.persistenciaaplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "my_database";
    public static final String TABLE_NAME = "usarios_tbl";


    public Database(Context context){
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE "+ TABLE_NAME +" ("
                +"id_usuario INTEGER PRIMARY KEY autoincrement,"
                +" usuario varchar(45) NOT NULL ,"
                +" senha varchar(45) NOT NULL,"
                +" nome_completo varchar(45) NOT NULL"
                + ");");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}

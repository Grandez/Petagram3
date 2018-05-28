package com.android.jgg.petagram3.db;

import android.content.ContentValues;

import com.android.jgg.petagram3.R;
import com.android.jgg.petagram3.model.Mascota;

import java.util.ArrayList;
import java.util.List;

public final class DBConfig {
    public static final String DB_NAME = "Mascotas";
    public static final int DB_VERSION = 1;

    public static final String TB_MASCOTAS = "Mascotas";
    public static final String TB_FOTOS = "Fotos";

    public static final String FLD_ID_MASCOTAS = "idMascota";
    public static final String FLD_NOMBRE = "nombre";
    public static final String FLD_ID_FOTO = "idFoto";
    public static final String FLD_LIKES = "likes";

    public static final String DDL_MASCOTAS =
            TB_MASCOTAS + "("
                    + FLD_ID_MASCOTAS + " INTEGER PRIMARY KEY AUTOINCREMENT"
                    + "," + FLD_NOMBRE + " TEXT"
                    + "," + FLD_ID_FOTO + " INTEGER"
                    + "," + FLD_LIKES + " INTEGER"
                    + ")";

    public static final String DDL_FOTOS =
            TB_FOTOS + "("
                     +       FLD_ID_MASCOTAS  + " INTEGER "
                     + "," + FLD_ID_FOTO + " INTEGER PRIMARY KEY AUTOINCREMENT "
                     + "," + FLD_LIKES + " INTEGER "
                     + "FOREIGN KEY (" + FLD_ID_MASCOTAS + ") "
                     + "REFERENCES " +  TB_MASCOTAS + "(" + FLD_ID_MASCOTAS + ") "
                    + ")";


    public static final String[] TABLES_NAME = {
             TB_MASCOTAS
            ,TB_FOTOS
    };

    public static final String[] TABLES_DDL = {
             DDL_MASCOTAS
            ,DDL_FOTOS
    };

    public final static String QRY_MASCOTA =
           "SELECT " + FLD_ID_MASCOTAS
                     + ", " + FLD_ID_FOTO
                     + ", " + FLD_LIKES
                     + ", " + FLD_NOMBRE
                     + " FROM " + TB_MASCOTAS;

    public final static String QRY_FOTOS =
            "SELECT " +        FLD_ID_MASCOTAS
                      + ", " + FLD_ID_FOTO
                      + ", " + FLD_LIKES
                    + " FROM " + TB_FOTOS;

    /////////////////////////////////////////////////////////////////////////////////////////
    // DATOS DE CARGA
    ////////////////////////////////////////////////////////////////////////////////////////

    public static List<ContentValues> getDefaultData() {
        int[] ids =
                {R.drawable.caracol, R.drawable.conejo, R.drawable.dalmata,
                        R.drawable.gatito, R.drawable.gorila, R.drawable.gusano, R.drawable.perrito};

        String[] imgs =
                {"caracol", "conejo", "dalmata", "gatito", "gorila", "gusano", "perrito"};
        String[] nombres =
                {"Caracol", "Roger",  "Perrita", "Gatito", "Chita",  "Gus",    "Perrito"};

        ArrayList<ContentValues> data = new ArrayList<ContentValues>();

        for (int i = 0; i < nombres.length; i++) {
            ContentValues c = new ContentValues();
            c.put(FLD_ID_MASCOTAS, i + 1);
            c.put(FLD_NOMBRE, nombres[i]);
            c.put(FLD_ID_FOTO, ids[i]);
            c.put(FLD_LIKES, 0);
            data.add(c);
        }
        return data;
    }

}

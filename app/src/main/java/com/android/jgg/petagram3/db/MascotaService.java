package com.android.jgg.petagram3.db;

import android.content.ContentValues;
import android.database.Cursor;

import com.android.jgg.petagram3.model.Mascota;

import java.util.ArrayList;
import java.util.List;

public class MascotaService {

    private static MascotaService inst = null;
    private DB db = null;
    private Mascota current = null;

    private MascotaService() {
        db = DB.getInstance();
        if (db.qryScalar("SELECT COUNT(*) FROM " + DBConfig.TB_MASCOTAS, null) == 0) {
            db.initDB();
        }
    }

    public static MascotaService getInstance() {
        if (inst == null) inst = new MascotaService();
        return inst;
    }

    public Mascota getMascotaById(Integer id) {
        Mascota mascota = null;
        String sql = DBConfig.QRY_MASCOTA + " WHERE idMascota = ?";
        ArrayList<Mascota> lista = new ArrayList<Mascota>();
        /*
        Cursor data = db.rawQuery(Config.QRY_MASCOTA, null);
        while (data.moveToNext()) {
            Mascota m = new Mascota();
            m.setIdMascota(data.getInt(0));
            m.setIdFoto(data.getInt(1));
            m.setLikes(data.getInt(2));
            m.setNombre(data.getString(3));
            lista.add(m);
        }
        return lista;
*/
        return mascota;
    }

    public int getNumberOfMascotas() {
        return db.qryScalar("SELECT COUNT(*) FROM " + DBConfig.TB_MASCOTAS, null);
    }

    public Mascota getMascota() {
        return current;
    }

    public void setMascota(Mascota mascota) {
        current = mascota;
    }

    private void updateLikes(Mascota mascota) {
        String qry = "UPDATE " + DBConfig.TB_MASCOTAS + " SET likes = ? WHERE idMascota = ?";


    }
    public List<Mascota> getMascotas() {
        ArrayList<Mascota> lista = new ArrayList<Mascota>();
        Cursor data = db.getReadableDatabase().rawQuery(DBConfig.QRY_MASCOTA, null);
        while (data.moveToNext()) {
            Mascota m = new Mascota();
            m.setIdMascota(data.getInt(0));
            m.setIdFoto(data.getInt(1));
            m.setLikes(data.getInt(2));
            m.setNombre(data.getString(3));
            lista.add(m);
        }
        if (lista.size() > 0) current = lista.get(0);
        return lista;
    }

    public List<Mascota> getMascotasByRating(int max) {
        return getMascotas();
        /*
        ArrayList<Mascota> m = new ArrayList<Mascota>(mascotas);
        ArrayList<Mascota> res = new ArrayList<Mascota>();
        Collections.sort(m);

        for (int idx = 0; idx < max; idx++) {
            if (idx == m.size()) break;
            res.add(m.get(idx));
        }
        return res;
        */
    }

    public boolean addMascota(ContentValues values) {
        Mascota mascota = null;
        String sql = DBConfig.QRY_MASCOTA + " WHERE idMascota = ?";
        ArrayList<Mascota> lista = new ArrayList<Mascota>();
        /*
        Cursor data = db.rawQuery(Config.QRY_MASCOTA, null);
        while (data.moveToNext()) {
            Mascota m = new Mascota();
            m.setIdMascota(data.getInt(0));
            m.setIdFoto(data.getInt(1));
            m.setLikes(data.getInt(2));
            m.setNombre(data.getString(3));
            lista.add(m);
        }
        return lista;
*/
        return true;
    }

    public void incRating(Integer id) {
        Mascota mascota = getMascotaById(id);
        mascota.setLikes(mascota.getLikes() + 1);
        updateLikes(mascota);
    }
}

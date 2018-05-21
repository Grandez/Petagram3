package com.android.jgg.petagram2.data;

import com.android.jgg.petagram2.pojo.Mascota;
import com.android.jgg.petagram2.R;

import java.util.ArrayList;
import java.util.Collections;

public class MascotaService {

    private static MascotaService mascotaSrv = null;
    private ArrayList<Mascota> mascotas = null;

    private int active = 0;  // Mascota activa

    private int[] ids =
            {R.drawable.caracol, R.drawable.conejo, R.drawable.dalmata,
             R.drawable.gatito, R.drawable.gorila, R.drawable.gusano, R.drawable.perrito};

    private String[] imgs =
            {"caracol", "conejo", "dalmata", "gatito", "gorila", "gusano", "perrito"};
    private String[] nombres =
            {"Caracol", "Roger",  "Perrita", "Gatito", "Chita",  "Gus",    "Perrito"};

    public static MascotaService getInstance() {
        if (mascotaSrv == null) mascotaSrv = new MascotaService();
        return mascotaSrv;
    }

    public ArrayList<Mascota> getMascotas() {
        return mascotas;
    }

    public ArrayList<Mascota> getMascotasByRating(int max) {
        ArrayList<Mascota> m = new ArrayList<Mascota>(mascotas);
        ArrayList<Mascota> res = new ArrayList<Mascota>();
        Collections.sort(m);

        for (int idx = 0; idx < max; idx++) {
            if (idx == m.size()) break;
            res.add(m.get(idx));
        }
        return res;
    }

    public void setMascota(int idx) {
      active = idx;
    }

    public Mascota getMascota() {
        return mascotas.get(active);
    }

    public Mascota getMascota(int idx) {
        return mascotas.get(idx);
    }

    public void incRating(int id) {
        for (Mascota m : mascotas) {
            if (m.getId() == id) {
                m.incRating();
                break;
            }
        }
    }
    private MascotaService() {
        loadMascotas();
    }

    private void loadMascotas() {
        mascotas = new ArrayList<Mascota>();

        for (int i = 0; i < nombres.length; i++) {
            Mascota m = new Mascota();
            m.setId(i);
            m.setNombre(nombres[i]);
            m.setImg(ids[i]);
            m.setRating(i);
            mascotas.add(m);
        }
    }
}

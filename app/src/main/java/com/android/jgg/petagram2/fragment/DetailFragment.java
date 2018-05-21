package com.android.jgg.petagram2.fragment;


import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.jgg.petagram2.R;
import com.android.jgg.petagram2.adapter.DetailAdapter;
import com.android.jgg.petagram2.data.MascotaService;
import com.android.jgg.petagram2.interfaces.Updatable;
import com.android.jgg.petagram2.pojo.Detalle;
import com.android.jgg.petagram2.pojo.Mascota;
import com.mikhaellopez.circularimageview.CircularImageView;

import android.support.v4.app.Fragment;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment implements Updatable {

    private static DetailFragment current = null;
    private View v = null;

    private int currentImg = -1;
    private MascotaService srv = MascotaService.getInstance();
    public DetailFragment() {
        // Required empty public constructor
    }

    public static DetailFragment newInstance() {
        current = new DetailFragment();
        return current;
    }


    public static DetailFragment getInstance() {
        return current;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_detail, container, false);
        v = inflater.inflate(R.layout.fragment_detail, container, false);

        update();

        return v;
    }

    public void update() {
        MascotaService service = MascotaService.getInstance();
        Mascota mascota = service.getMascota();

        CircularImageView civ = (CircularImageView) v.findViewById(R.id.detail_img);
        civ.setImageResource(mascota.getImg());
        RecyclerView recyclerView = (RecyclerView) v.findViewById(R.id.mascota_detail);
        recyclerView.setLayoutManager(new GridLayoutManager(v.getContext(), 2));


        DetailAdapter adapter = new DetailAdapter(this, populate(v, mascota));
        recyclerView.setAdapter(adapter);

    }
    private ArrayList<Detalle> populate(View v, Mascota mascota) {

        ArrayList<Detalle> lista = new ArrayList<Detalle>();

        int pics = ThreadLocalRandom.current().nextInt(1, 20 + 1);

        for (int idx = 0; idx < pics; idx++) {
            Detalle d = new Detalle();
            d.setImg(mascota.getImg());
            d.setRating(ThreadLocalRandom.current().nextInt(1, 20 + 1));
            lista.add(d);
        }
        return lista;
    }
}

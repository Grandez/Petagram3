package com.android.jgg.petagram2.fragment;

import android.os.Bundle;
import android.support.annotation.*;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;

import com.android.jgg.petagram2.R;
import com.android.jgg.petagram2.adapter.MascotaAdapter;
import com.android.jgg.petagram2.data.MascotaService;
import com.android.jgg.petagram2.pojo.Mascota;

import java.util.ArrayList;

public class RecyclerviewFragment extends Fragment  {

    private ArrayList<Mascota> mascotas;
    private RecyclerView lstMascotas;

    public RecyclerviewFragment() {

    }

    public static RecyclerviewFragment newInstance() {
        RecyclerviewFragment fragment = new RecyclerviewFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_recyclerview, container, false);

        MascotaService mascotaSrv = MascotaService.getInstance();
        mascotas = mascotaSrv.getMascotas();

        lstMascotas = (RecyclerView) v.findViewById(R.id.rv_mascotas);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        lstMascotas.setLayoutManager(llm);

        MascotaAdapter adapter = new MascotaAdapter(mascotas, this);
        lstMascotas.setAdapter(adapter);

        return v;
    }
}


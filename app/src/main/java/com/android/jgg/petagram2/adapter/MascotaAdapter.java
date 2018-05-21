package com.android.jgg.petagram2.adapter;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import com.android.jgg.petagram2.pojo.Mascota;
import com.android.jgg.petagram2.data.MascotaService;
import com.android.jgg.petagram2.R;

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class MascotaAdapter extends RecyclerView.Adapter<MascotaAdapter.MascotaViewHolder> {

    private ArrayList<Mascota> mascotas;
    private Fragment activity;

    public MascotaAdapter(ArrayList<Mascota> mascotas, Fragment activity) {
        this.mascotas = mascotas;
        this.activity = activity;
    }

       @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.tarjeta, parent, false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder( MascotaViewHolder holder, int position) {


        final Mascota mascota = mascotas.get(position);

        holder.mFoto.setImageResource(mascota.getImg());
        holder.mNombre.setText(mascota.getNombre());
        holder.mRating.setText(mascota.getRatingAsString());

        MascotaViewHolder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MascotaService service = MascotaService.getInstance();
                service.setMascota(mascota.getId());
                Toast.makeText(activity.getContext(), mascota.getNombre(), Toast.LENGTH_LONG).show();
/*
                Fragment frg = getFragmentManager().findFragmentByTag("fragment_detail");
                final FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.detach(frg);
                ft.attach(frg);
                ft.commit();
                */
                View main = v.getRootView();
                TabLayout tabLayout = (TabLayout) main.findViewById(R.id.tab_layout);
                TabLayout.Tab tab = tabLayout.getTabAt(1);
                tab.select();

            }
        });

        MascotaViewHolder.mLike.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                MascotaService srv = MascotaService.getInstance();
                Toast.makeText(v.getContext(), "Diste like a " + mascota.getNombre(),
                        Toast.LENGTH_SHORT).show();
                srv.incRating(mascota.getId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {
        static CardView cv;
        TextView mNombre;
        TextView mRating;
        ImageView mFoto;
        static ImageButton mLike;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            // cv = (CardView) findViewById(R.id.cv_mascota);
            mNombre = itemView.findViewById(R.id.mNombre);
            mRating = itemView.findViewById(R.id.mRating);
            mFoto   = (ImageView) itemView.findViewById(R.id.mFoto);
            mLike = (ImageButton) itemView.findViewById(R.id.btnLike);
            cv = (CardView) itemView.findViewById(R.id.cv_mascota);

        }
    }
}

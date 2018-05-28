package com.android.jgg.petagram3.adapter;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.jgg.petagram3.R;
import com.android.jgg.petagram3.model.Detalle;

import java.util.ArrayList;

public class DetailAdapter extends RecyclerView.Adapter<DetailAdapter.DetailViewHolder> {

    private ArrayList<Detalle> detalles;
    private Fragment activity;

    public DetailAdapter(Fragment activity, ArrayList<Detalle> detalles) {
        this.detalles = detalles;
        this.activity = activity;
    }

    @Override
    public DetailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_detail, parent, false);
        return new DetailViewHolder(v);
    }

    @Override
    public void onBindViewHolder(DetailAdapter.DetailViewHolder holder, int position) {


        Detalle det = detalles.get(position);

        holder.mFoto.setImageResource(det.getImg());
        holder.mRating.setText(det.getRatingAsString());

    }


    @Override
    public int getItemCount() {
        return detalles.size();
    }

    public static class DetailViewHolder extends RecyclerView.ViewHolder {
        TextView mRating;
        ImageView mFoto;

        public DetailViewHolder(View itemView) {
            super(itemView);
            mRating = itemView.findViewById(R.id.mRating);
            mFoto   = (ImageView) itemView.findViewById(R.id.mFoto);

        }

    }


}


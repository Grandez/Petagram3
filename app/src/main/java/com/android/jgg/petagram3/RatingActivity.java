package com.android.jgg.petagram3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.android.jgg.petagram3.db.MascotaService;
import com.android.jgg.petagram3.model.Mascota;

import java.util.ArrayList;
import java.util.List;

public class RatingActivity extends AppCompatActivity {

    private List<Mascota> mascotas;
    private RecyclerView lstMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);

        MascotaService mascotaSrv = MascotaService.getInstance();
        mascotas = mascotaSrv.getMascotasByRating(5);


        lstMascotas = (RecyclerView) findViewById(R.id.rv_rating);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        lstMascotas.setLayoutManager(llm);

//        MascotaAdapter adapter = new MascotaAdapter(mascotas);
//        lstMascotas.setAdapter(adapter);

    }

    public void btnBack_onClick(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}

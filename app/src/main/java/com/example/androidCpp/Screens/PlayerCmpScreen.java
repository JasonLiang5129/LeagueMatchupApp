package com.example.androidCpp.Screens;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidCpp.Adapters.CmpAdapter;
import com.example.androidCpp.MainActivity;
import com.example.androidcpp.R;

public class PlayerCmpScreen extends AppCompatActivity {
    //TODO fill with the actual champ icons


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player_cmp_screen);
        setupRecyclerView();
    }

    private void setupRecyclerView() {
        RecyclerView playerChampionRecyclerview = findViewById(R.id.player_champion_recyclerview);
        CmpAdapter playerChampionAdapter = new CmpAdapter(this, MainActivity.championsList);
        playerChampionRecyclerview.setAdapter(playerChampionAdapter);
        playerChampionRecyclerview.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
    }

}
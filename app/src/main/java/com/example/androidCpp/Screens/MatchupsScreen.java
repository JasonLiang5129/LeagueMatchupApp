package com.example.androidCpp.Screens;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidCpp.Adapters.CmpAdapter;
import com.example.androidCpp.Classes.Cmp;
import com.example.androidcpp.R;

import java.util.ArrayList;

public class MatchupsScreen extends AppCompatActivity {
    //TODO fill with the actual champ icons
    int[] championIcons = {R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background, R.drawable.ic_launcher_background};
    ArrayList<Cmp> championsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.matchups_screen);

        setupChampsList();
        setupRecyclerView();
    }

    private void setupChampsList() {
        String[] championNames = getResources().getStringArray(R.array.champion_names);

        for (int i = 0; i < championNames.length; i++) {
            championsList.add(new Cmp(championIcons[i], championNames[i]));
        }
    }

    private void setupRecyclerView() {
        RecyclerView playerChampionRecyclerview = findViewById(R.id.player_champion_recyclerview);
        CmpAdapter playerChampionAdapter = new CmpAdapter(this, championsList);
        playerChampionRecyclerview.setAdapter(playerChampionAdapter);
        playerChampionRecyclerview.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
    }


}
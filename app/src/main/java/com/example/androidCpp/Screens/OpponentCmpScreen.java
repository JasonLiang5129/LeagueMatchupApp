package com.example.androidCpp.Screens;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidCpp.Adapters.CmpAdapter;
import com.example.androidCpp.Classes.Cmp;
import com.example.androidCpp.MainActivity;
import com.example.androidcpp.R;

import java.util.ArrayList;

public class OpponentCmpScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.opponent_cmp_screen);

        TextView playerCurrentChamp = findViewById(R.id.player_current_champ);
        playerCurrentChamp.setText(MainActivity.getPlayerCmp().getCmpName());

        ArrayList<Cmp> opponentChampionsList = new ArrayList<>(MainActivity.championsList); // copies the full champion list without making a pointer to it
        opponentChampionsList.remove(MainActivity.getPlayerCmp()); // opponent cannot be using the same champ as the player so remove it from the list
        setupRecyclerView(opponentChampionsList);
    }

    private void setupRecyclerView(ArrayList<Cmp> opponentChampionsList) {
        RecyclerView opponentChampionRecyclerview = findViewById(R.id.opponent_champion_recyclerview);
        CmpAdapter opponentChampionAdapter = new CmpAdapter(this, opponentChampionsList); // uses the updated champion list that the opponent picked from (aka not the player champ)
        opponentChampionRecyclerview.setAdapter(opponentChampionAdapter);
        opponentChampionRecyclerview.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
    }

}
package com.example.androidCpp.Screens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.androidCpp.Classes.Cmp;
import com.example.androidCpp.MainActivity;
import com.example.androidcpp.R;

public class StartScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_screen);

        Button champMatchupButton = findViewById(R.id.champ_matchup_button);

        setupChampsList();
        champMatchupButton.setOnClickListener(v -> openRolesScreen());
    }

    private void setupChampsList() {
        String[] championNames = getResources().getStringArray(R.array.champion_names);
        for (int i = 0; i < championNames.length; i++) {
            MainActivity.championsList.add(new Cmp(MainActivity.championIcons[i], championNames[i]));
        }
    }

    private void openRolesScreen() {
        Intent intent = new Intent(this, RolesScreen.class);
        startActivity(intent);
    }
}
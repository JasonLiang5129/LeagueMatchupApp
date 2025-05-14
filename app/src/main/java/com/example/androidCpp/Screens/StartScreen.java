package com.example.androidCpp.Screens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.androidcpp.R;

public class StartScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_screen);

        Button champMatchupButton = findViewById(R.id.champ_matchup_button);

        champMatchupButton.setOnClickListener(v -> openMatchupsScreen());
    }

    private void openMatchupsScreen() {
        Intent intent = new Intent(this, MatchupsScreen.class);
        startActivity(intent);
    }
}
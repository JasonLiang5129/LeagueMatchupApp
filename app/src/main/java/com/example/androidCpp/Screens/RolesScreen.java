package com.example.androidCpp.Screens;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.androidCpp.MainActivity;
import com.example.androidcpp.R;

public class RolesScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.roles_screen);

        Button topButton = findViewById(R.id.top_role);
        Button jglButton = findViewById(R.id.jungle_role);
        Button midButton = findViewById(R.id.mid_role);
        Button botButton = findViewById(R.id.bottom_role);
        Button supButton = findViewById(R.id.support_role);

        topButton.setOnClickListener(v -> {
            MainActivity.setPlayerRole("top");
            openMatchupsScreen();

            Toast toast = Toast.makeText(this, "top", Toast.LENGTH_SHORT);
            toast.show();
        });

        jglButton.setOnClickListener(v -> {
            MainActivity.setPlayerRole("jgl");
            openMatchupsScreen();

            Toast toast = Toast.makeText(this, "jgl", Toast.LENGTH_SHORT);
            toast.show();
        });

        midButton.setOnClickListener(v -> {
            MainActivity.setPlayerRole("mid");
            openMatchupsScreen();

            Toast toast = Toast.makeText(this, "mid", Toast.LENGTH_SHORT);
            toast.show();
        });

        botButton.setOnClickListener(v -> {
            MainActivity.setPlayerRole("bot");
            openMatchupsScreen();

            Toast toast = Toast.makeText(this, "bot", Toast.LENGTH_SHORT);
            toast.show();
        });

        supButton.setOnClickListener(v -> {
            MainActivity.setPlayerRole("sup");
            openMatchupsScreen();

            Toast toast = Toast.makeText(this, "sup", Toast.LENGTH_SHORT);
            toast.show();
        });
    }

    private void openMatchupsScreen() {
        Intent intent = new Intent(this, MatchupsScreen.class);
        startActivity(intent);
    }
}
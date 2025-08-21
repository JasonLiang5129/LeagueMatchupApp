package com.example.androidCpp.Screens;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.androidCpp.Classes.MatchupGuide;
import com.example.androidCpp.DatabaseHelper;
import com.example.androidCpp.MainActivity;
import com.example.androidcpp.R;

public class GuideSearchScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guide_search_screen);

        Button guideCreateButton = findViewById(R.id.guide_create_button);

        guideCreateButton.setOnClickListener(v -> {
            MatchupGuide newMatchupGuide;
            try {
                newMatchupGuide = new MatchupGuide(-1, -1, "", "");
                newMatchupGuide.setGuidePatchVersion(MainActivity.getCurrentPatchVersion());
                Toast.makeText(GuideSearchScreen.this, newMatchupGuide.toString(), Toast.LENGTH_SHORT).show();
            }
            catch (Exception e) {
                Toast.makeText(GuideSearchScreen.this, "error adding guide to database", Toast.LENGTH_SHORT).show();
                newMatchupGuide = new MatchupGuide(-1, -1, "error", "error");
            }

            DatabaseHelper databaseHelper = new DatabaseHelper(GuideSearchScreen.this);
            boolean result = databaseHelper.addOne(newMatchupGuide);
            String dbPath = getDatabasePath("matchupGuides.db").getAbsolutePath();
            System.out.println(dbPath);
            Toast.makeText(GuideSearchScreen.this, "Insert success = " + result, Toast.LENGTH_SHORT).show();
        });
    }
}
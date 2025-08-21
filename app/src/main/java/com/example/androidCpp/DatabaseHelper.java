package com.example.androidCpp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.androidCpp.Classes.MatchupGuide;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String GTABLE = "gTable";
    public static final String GID = "gId";

    public DatabaseHelper(@Nullable Context context) {
        super(context, "matchupGuides.db", null, 1);
    }

    // called the first time the db is accessed i.e. code that creates the new db
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = "CREATE TABLE " + GTABLE + " (" + GID + " INTEGER PRIMARY KEY AUTOINCREMENT, gPatchVersion FLOAT, gTitle TEXT, gText TEXT)";
        db.execSQL(createTableStatement);
    }

    // called if the db version changes and updates the schema of old version dbs on user devices into the new version
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    // adds the given matchup guide to the database
    public boolean addOne(MatchupGuide matchupGuide) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("gPatchVersion", matchupGuide.getGuidePatchVersion());
        cv.put("gTitle", matchupGuide.getGuideTitle());
        cv.put("gText", matchupGuide.getGuideText());

        long insert = db.insert(GTABLE, null, cv);
        return insert != -1;
    }
}

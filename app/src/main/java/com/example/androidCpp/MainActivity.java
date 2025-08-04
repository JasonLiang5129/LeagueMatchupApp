package com.example.androidCpp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.androidCpp.Classes.Cmp;
import com.example.androidcpp.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static String playerRole;
    public static Cmp playerCmp;
    public static Cmp opponentCmp;

    public static final int[] championIcons = {R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background};
    public static final ArrayList<Cmp> championsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        // Example of a call to a native method
//        TextView tv = binding.sampleText;
//        tv.setText(stringFromJNI());
    }

    public static String getPlayerRole() {
        return playerRole;
    }

    public static void setPlayerRole(String playerRole) {
        MainActivity.playerRole = playerRole;
    }

    public static Cmp getPlayerCmp() {
        return playerCmp;
    }

    public static void setPlayerCmp(Cmp playerCmp) {
        MainActivity.playerCmp = playerCmp;
    }

    public static Cmp getOpponentCmp() {
        return opponentCmp;
    }

    public static void setOpponentCmp(Cmp opponentCmp) {
        MainActivity.opponentCmp = opponentCmp;
    }

    // Used to load the 'androidCpp' library on application startup.
    static {
        System.loadLibrary("androidCpp");
    }

    /**
     * A native method that is implemented by the 'androidCpp' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}
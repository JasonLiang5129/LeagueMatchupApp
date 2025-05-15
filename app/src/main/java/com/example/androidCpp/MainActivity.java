package com.example.androidCpp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static String playerRole;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        // Example of a call to a native method
//        TextView tv = binding.sampleText;
//        tv.setText(stringFromJNI());
    }

    // Used to load the 'androidCpp' library on application startup.
    static {
        System.loadLibrary("androidCpp");
    }

    public static String getPlayerRole() {
        return playerRole;
    }

    public static void setPlayerRole(String playerRole) {
        MainActivity.playerRole = playerRole;
    }

    /**
     * A native method that is implemented by the 'androidCpp' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}
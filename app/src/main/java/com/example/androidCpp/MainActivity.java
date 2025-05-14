package com.example.androidCpp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.androidcpp.databinding.StartScreenBinding;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'androidCpp' library on application startup.
    static {
        System.loadLibrary("androidCpp");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        StartScreenBinding binding = StartScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Example of a call to a native method
        TextView tv = binding.sampleText;
        tv.setText(stringFromJNI());
    }

    /**
     * A native method that is implemented by the 'androidCpp' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}
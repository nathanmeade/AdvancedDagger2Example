package com.meadetechnologies.advanceddagger2example.ui.main;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.meadetechnologies.advanceddagger2example.BaseActivity;
import com.meadetechnologies.advanceddagger2example.R;

public class MainActivity extends BaseActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(this, "mainactivity", Toast.LENGTH_SHORT).show();
    }
}

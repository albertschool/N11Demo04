package com.example.n11demo04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private Intent si;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void customClickFruit(View view) {
        si = new Intent(this, CustomFruit.class);
        startActivity(si);
    }

    public void customClick(View view) {
        si = new Intent(this, CustomListView.class);
        startActivity(si);
    }

    public void objectClick(View view) {
        si = new Intent(this, StateListView.class);
        startActivity(si);
    }
}
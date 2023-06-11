package com.example.n11demo04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.n11demo04.Adapters.CustomAdapter;

public class CustomFruit extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ListView lVfruit;
    private String[] fruits;
    private int[] imgs;
    private CustomAdapter customAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_fruit);

        initAll();

        customAdapter = new CustomAdapter(this, imgs, fruits);
        lVfruit.setAdapter(customAdapter);
        lVfruit.setOnItemClickListener(this);
    }

    private void initAll() {
        lVfruit = findViewById(R.id.lVfruit);

        imgs = new int[]
                {
                        R.drawable.apple,R.drawable.apricot,R.drawable.banana, R.drawable.cherry,
                        R.drawable.coconut,R.drawable.grapes,R.drawable.kiwi,R.drawable.mango,
                        R.drawable.melon, R.drawable.orange,R.drawable.peach,R.drawable.pear,
                        R.drawable.pineapple,R.drawable.strawberry,R.drawable.watermelon
                };
        fruits = new String[]
                {
                        "apple","apricot","banana","cherry","coconut","grapes","kiwi","mango",
                        "melon","orange","peach","pear","pineapple","strawberry","watermelon"
                };
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "The fruit is "+ fruits[position], Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
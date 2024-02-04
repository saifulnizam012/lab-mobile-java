package com.example.myrecycleview_a179830;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class FruitDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruit_detail);

        Intent intent = getIntent();

        TextView tvName = findViewById(R.id.tv_fruit_name_detail);
        tvName.setText(intent.getStringExtra("fruitName"));
    }
}
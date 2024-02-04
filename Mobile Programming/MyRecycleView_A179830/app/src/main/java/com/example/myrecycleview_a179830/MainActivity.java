package com.example.myrecycleview_a179830;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.myrecycleview_a179830.adapter.FruitRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    LinearLayoutManager linearLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        linearLayoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(linearLayoutManager);

        List<Fruit> allFruitInfor = getAllFruitInfor();
        FruitRecyclerViewAdapter fruitRecyclerViewAdapter = new FruitRecyclerViewAdapter(MainActivity.this,allFruitInfor);
        recyclerView.setAdapter(fruitRecyclerViewAdapter);
    }

    private List<Fruit> getAllFruitInfor(){
        List<Fruit> allFruit = new ArrayList<Fruit>();

        allFruit.add(new Fruit("Apple",R.drawable.apple));
        allFruit.add(new Fruit("Banana",R.drawable.banana));
        allFruit.add(new Fruit("Dragon fruit",R.drawable.dragonfruit));
        allFruit.add(new Fruit("Grape",R.drawable.grape));
        allFruit.add(new Fruit("Guava",R.drawable.guava));

        allFruit.add(new Fruit("Honeydew",R.drawable.honeydew));
        allFruit.add(new Fruit("Kiwi",R.drawable.kiwi));
        allFruit.add(new Fruit("Mango",R.drawable.mango));
        allFruit.add(new Fruit("Orange",R.drawable.orange));
        allFruit.add(new Fruit("Papaya",R.drawable.papaya));

        allFruit.add(new Fruit("Pineapple",R.drawable.pineapple));
        allFruit.add(new Fruit("Rockmelon",R.drawable.rockmelon));
        allFruit.add(new Fruit("Watermelon",R.drawable.watermelon));


        return allFruit;
    }
}
package com.example.myroom_a179830;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.myroom_a179830.dao.FruitDao;
import com.example.myroom_a179830.entities.Fruit;

@Database(entities = {Fruit.class},version=1)
public abstract class MyFruitDB extends RoomDatabase {

    public abstract FruitDao fruitDao();
}

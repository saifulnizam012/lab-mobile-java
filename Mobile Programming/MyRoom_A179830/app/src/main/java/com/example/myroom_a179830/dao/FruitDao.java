package com.example.myroom_a179830.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.myroom_a179830.entities.Fruit;

import java.util.List;


@Dao
public interface FruitDao {
    @Insert
    void insertFruit(Fruit fruit);

    @Update
    void updateFruit(Fruit fruit);

    @Delete
    void deleteFruit(Fruit fruit);

    @Query("Select * from fruits")
    List<Fruit> getAllFruits();


}

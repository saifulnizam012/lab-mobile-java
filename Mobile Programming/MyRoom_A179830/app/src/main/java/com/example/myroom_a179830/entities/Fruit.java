package com.example.myroom_a179830.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "fruits")
public class Fruit {

    @NonNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="fruit_id")
    int fruitID;

    @NonNull
    @ColumnInfo(name="fruit_name")
    String fruitName;

    @NonNull
    @ColumnInfo(name="fruit_price")
    float fruitPrice;

    public Fruit(int fruitID) {
        this.fruitID = fruitID;
    }

    public Fruit(@NonNull String fruitName, float fruitPrice) {
        this.fruitName = fruitName;
        this.fruitPrice = fruitPrice;
    }

    public Fruit(int fruitID, @NonNull String fruitName, float fruitPrice) {
        this.fruitID = fruitID;
        this.fruitName = fruitName;
        this.fruitPrice = fruitPrice;
    }

    public Fruit() {
    }

    public int getFruitID() {
        return fruitID;
    }

    public void setFruitID(int fruitID) {
        this.fruitID = fruitID;
    }

    @NonNull
    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(@NonNull String fruitName) {
        this.fruitName = fruitName;
    }

    public float getFruitPrice() {
        return fruitPrice;
    }

    public void setFruitPrice(float fruitPrice) {
        this.fruitPrice = fruitPrice;
    }
}

package com.example.allaboutcoffee.Coffee;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Pair;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.example.allaboutcoffee.CoffeeDatabase.EstimatedUsageTypeConverter;

import java.io.Serializable;

@Entity(tableName = "coffee")
public class Coffee implements Serializable {

    @PrimaryKey(autoGenerate = true)
    @NonNull()
    private int uuid;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "AmountWater")
    private int waterAmount;
    @ColumnInfo(name = "AmountCoffee")
    private int coffeeAmount;

    @ColumnInfo(name = "best_Use")
    @TypeConverters(EstimatedUsageTypeConverter.class)
    private EstimatedUsage usage;


    public Coffee(String name, int waterAmount, int coffeeAmount, EstimatedUsage usage){
        this.name = name;
        this.coffeeAmount = coffeeAmount;
        this.waterAmount = waterAmount;
        this.usage = usage;
    }

    @Ignore()
    public Coffee(String name, int waterAmount, int coffeeAmount){
        this.name = name;
        this.coffeeAmount = coffeeAmount;
        this.waterAmount = waterAmount;
        this.usage = EstimatedUsage.UNKNOWN;
    }

    public int getUuid() {
        return uuid;
    }

    public void setUuid(int uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWaterAmount() {
        return waterAmount;
    }

    public int getCoffeeAmount() {
        return coffeeAmount;
    }

    public void setWaterAmount(int waterAmount) {
        this.waterAmount = waterAmount;
    }

    public void setCoffeeAmount(int coffeeAmount) {
        this.coffeeAmount = coffeeAmount;
    }

    public EstimatedUsage getUsage() {
        return usage;
    }

    public void setUsage(EstimatedUsage usage) {
        this.usage = usage;
    }


}

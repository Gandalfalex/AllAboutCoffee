package com.example.allaboutcoffee.CoffeeDatabase;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Ignore;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.allaboutcoffee.Coffee.Coffee;

import java.util.List;

@Dao
public interface CDao {



    @Query("Select * From Coffee Where uuid =:id")
    Coffee findById(int id);

    @Query("Select * From Coffee")
    LiveData<List<Coffee>> findAll();

    @Insert()
    void insert(Coffee Coffee);

    @Update()
    void update(Coffee coffee);

    @Delete()
    void delete(Coffee coffee);

    @Query("Delete From coffee")
    void deleteAll();
}

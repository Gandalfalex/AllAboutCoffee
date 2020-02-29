package com.example.allaboutcoffee.CoffeeDatabase;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.allaboutcoffee.Coffee.Coffee;
import com.example.allaboutcoffee.Coffee.EstimatedUsage;

import java.util.ArrayList;


@Database(entities = {Coffee.class}, version = 1, exportSchema = false)
public abstract class CDatabase extends RoomDatabase {

    public abstract CDao coffeeDao();
    private static CDatabase INSTANCE;


    static CDatabase getDatabase(final Context context){
        if(INSTANCE == null){
            synchronized (CDatabase.class){
                if (INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), CDatabase.class, "CoffeDataBase")
                            .fallbackToDestructiveMigration()
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }


    private static RoomDatabase.Callback sRoomDatabaseCallback =
            new RoomDatabase.Callback(){

                @Override
                public void onOpen (@NonNull SupportSQLiteDatabase db){
                    super.onOpen(db);
                    new PopulateDBAsync(INSTANCE).execute();
                }
            };



    private static class PopulateDBAsync extends AsyncTask<Void,Void,Void>{

        private final CDao cDao;
        private ArrayList<Coffee> coffees = new ArrayList<>();

        public PopulateDBAsync(CDatabase db){
            this.cDao = db.coffeeDao();

            coffees.add(new Coffee("Buna Lima", 100,34, EstimatedUsage.DRIPPER));
            coffees.add(new Coffee("Yigra", 100, 243, EstimatedUsage.AERO_PRESS));

        }

        @Override
        protected Void doInBackground(Void... voids) {

            cDao.deleteAll();

            for (Coffee coffee: coffees){
                cDao.insert(coffee);
            }
            return null;
        }
    }

}

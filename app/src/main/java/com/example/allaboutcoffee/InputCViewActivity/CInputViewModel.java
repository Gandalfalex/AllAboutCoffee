package com.example.allaboutcoffee.InputCViewActivity;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.allaboutcoffee.Coffee.Coffee;
import com.example.allaboutcoffee.CoffeeDatabase.CRepository;

public class CInputViewModel extends AndroidViewModel {

    private CRepository cRepository;


    public CInputViewModel(@NonNull Application application) {
        super(application);
        cRepository = new CRepository(application);
    }





    public void insert(Coffee coffee){
        cRepository.insert(coffee);
    }
}

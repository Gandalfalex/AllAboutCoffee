package com.example.allaboutcoffee.ShowAllCoffees;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.allaboutcoffee.Coffee.Coffee;
import com.example.allaboutcoffee.CoffeeDatabase.CRepository;

import java.util.List;

public class CRecyclerViewModel extends AndroidViewModel {

    private CRepository cRepository;
    private LiveData<List<Coffee>> listLiveData;

    public CRecyclerViewModel(@NonNull Application application) {
        super(application);
        cRepository = new CRepository(application);
        listLiveData = cRepository.getListLiveData();
    }

    public LiveData<List<Coffee>> getListLiveData() {
        return listLiveData;
    }

    public void insert(Coffee coffee){
        cRepository.insert(coffee);
    }

    public void upadte(Coffee coffee){
        cRepository.update(coffee);
    }

    public void delete(Coffee coffee){
        cRepository.delete(coffee);
    }

    public Coffee findById(int id){
        return cRepository.findById(id);
    }

}

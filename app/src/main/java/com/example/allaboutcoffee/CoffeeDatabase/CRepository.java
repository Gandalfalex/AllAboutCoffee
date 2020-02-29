package com.example.allaboutcoffee.CoffeeDatabase;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.allaboutcoffee.Coffee.Coffee;

import java.util.List;

public class CRepository {

    private CDao cdao;
    private LiveData<List<Coffee>> listLiveData;

    public CRepository(Application application){
       CDatabase cb =  CDatabase.getDatabase(application);
       cdao = cb.coffeeDao();
       listLiveData = cdao.findAll();
    }


    public LiveData<List<Coffee>> getListLiveData(){
        return this.listLiveData;
    }

    public void insert(Coffee coffee){
        new InsertAsyncTask(cdao).execute(coffee);
    }

    public void update(Coffee coffee){
        new UpdateAsyncTask(cdao).execute(coffee);
    }

    public void delete(Coffee coffee){
        new DeleteAsyncTask(cdao).execute(coffee);
    }

    public Coffee findById(int id){
        return cdao.findById(id);
    }





    public static class InsertAsyncTask extends AsyncTask<Coffee, Void, Void>{

        private CDao cDao;
        public InsertAsyncTask(CDao cDao){
            this.cDao = cDao;
        }

        @Override
        protected Void doInBackground(Coffee... coffees) {
            cDao.insert(coffees[0]);
            return null;
        }
    }

    public static class UpdateAsyncTask extends AsyncTask<Coffee, Void, Void>{

        private CDao cDao;
        public UpdateAsyncTask(CDao cDao){
            this.cDao = cDao;
        }

        @Override
        protected Void doInBackground(Coffee... coffees) {
            cDao.update(coffees[0]);
            return null;
        }
    }

    public static class DeleteAsyncTask extends AsyncTask<Coffee, Void, Void>{

        private CDao cDao;
        public DeleteAsyncTask(CDao cDao){
            this.cDao = cDao;
        }

        @Override
        protected Void doInBackground(Coffee... coffees) {
            cDao.delete(coffees[0]);
            return null;
        }
    }




}

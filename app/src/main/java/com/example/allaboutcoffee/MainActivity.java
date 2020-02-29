package com.example.allaboutcoffee;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.allaboutcoffee.InputCViewActivity.CViewInputActivity;
import com.example.allaboutcoffee.Coffee.Coffee;
import com.example.allaboutcoffee.ShowAllCoffees.CListAdapter;
import com.example.allaboutcoffee.ShowAllCoffees.CRecyclerViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    private CRecyclerViewModel cViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final CListAdapter adapter = new CListAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        cViewModel = ViewModelProviders.of(this).get(CRecyclerViewModel.class);
        cViewModel.getListLiveData().observe(this, new Observer<List<Coffee>>() {
            @Override
            public void onChanged(List<Coffee> coffees) {
                adapter.setText(coffees);
            }
        });



        FloatingActionButton fab = findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                Intent intent = new Intent(view.getContext(), CViewInputActivity.class);
                startActivity(intent);
            }
        });


    }
}

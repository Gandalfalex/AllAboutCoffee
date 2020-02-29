package com.example.allaboutcoffee.ShowItemCoffee;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;


import com.example.allaboutcoffee.Coffee.Coffee;
import com.example.allaboutcoffee.Coffee.EstimatedUsage;
import com.example.allaboutcoffee.R;

public class CView_Activity extends AppCompatActivity {

    private CViewCoffeeModel cViewCoffeeModel;
    private TextView coffeeNameTextView;
    private TextView calculatedCoffeeAmountTextView;
    private EditText calculatedCoffeeAmountEditText;
    private Button startTimerButton;
    private AnimationDrawable coffeeDripper;
    private ImageView mainImageView;


    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        coffeeDripper.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_coffee_direkt);
        cViewCoffeeModel = ViewModelProviders.of(this).get(CViewCoffeeModel.class);
        Intent intent = getIntent();
        Coffee coffee = (Coffee) intent.getSerializableExtra("coffeeObj");
        setGUIItems(coffee);
    }





    //später durch else if für standart Ersetzen
    public void setGUIItems(final Coffee coffee){
        mainImageView = findViewById(R.id.animationImageView);
        if (coffee.getUsage().equals(EstimatedUsage.AERO_PRESS)){
            mainImageView.setBackgroundResource(R.drawable.aero_press_animation);
        }
        else{ //if(coffee.getUsage().equals(EstimatedUsage.DRIPPER){
            mainImageView.setBackgroundResource(R.drawable.dripper_animation);
        }

        coffeeDripper = (AnimationDrawable) mainImageView.getBackground();

        coffeeNameTextView = findViewById(R.id.nameTextView);
        coffeeNameTextView.setText(coffee.getName());
        calculatedCoffeeAmountTextView = findViewById(R.id.neededAmountTextView);
        calculatedCoffeeAmountTextView.setText("000");
        calculatedCoffeeAmountEditText = findViewById(R.id.coffeeWantedAmount);

        cViewCoffeeModel.setTexts(calculatedCoffeeAmountTextView, calculatedCoffeeAmountEditText, coffee);



    }
}

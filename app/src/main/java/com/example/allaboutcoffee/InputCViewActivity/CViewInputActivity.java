package com.example.allaboutcoffee.InputCViewActivity;

import android.media.Image;
import android.os.Bundle;
import android.os.Message;
import android.provider.ContactsContract;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.example.allaboutcoffee.Coffee.Coffee;
import com.example.allaboutcoffee.Coffee.EstimatedUsage;
import com.example.allaboutcoffee.R;
import com.google.android.material.snackbar.Snackbar;

public class CViewInputActivity  extends AppCompatActivity {


    private HorizontalScrollView horizontalScrollView;
    private LinearLayout usageView;
    private Button insertCoffeeBtn;
    private EditText nameInputText;
    private EditText ratioInputText;
    private CInputViewModel cInputViewModel;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.add_item);
        cInputViewModel = ViewModelProviders.of(this).get(CInputViewModel.class);

        nameInputText = findViewById(R.id.inputNameText);
        insertCoffeeBtn = findViewById(R.id.insertCoffeeBtn);
        horizontalScrollView = findViewById(R.id.horizontalScollView);
        usageView = findViewById(R.id.usageContentView);
        ratioInputText = findViewById(R.id.ratioEditText);

        LayoutInflater inflater = LayoutInflater.from(this);
        for (EstimatedUsage usage: EstimatedUsage.values()){
            View view = inflater.inflate(R.layout.scrollview_layout, usageView, false);
            ImageView imageView = view.findViewById(R.id.EstimatedUsageImageView);
            imageView.setImageResource(getIdForUsage(usage));
            usageView.addView(view);

        }


        insertCoffeeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cInputViewModel.insert(createCoffee());
                //Snackbar.make(view, R.string.sucsessfull_input, Snackbar.LENGTH_LONG).setAction("Action", null).show();
                finish();
            }
        });
    }


    public Coffee createCoffee(){
        EstimatedUsage usage = EstimatedUsage.UNKNOWN;
        String name = nameInputText.getText().toString();
        int ratio = Integer.parseInt(ratioInputText.getText().toString());
        return new Coffee(name,100,ratio,usage);
    }



    protected int getIdForUsage(EstimatedUsage usage){
        if (usage.equals(EstimatedUsage.AERO_PRESS)){
            return R.drawable.ic_aero_press;
        }
        else if(usage.equals(EstimatedUsage.UNKNOWN)){
            return R.drawable.ic_normal_coffee;
        }
        else if(usage.equals(EstimatedUsage.DRIPPER)){
            return R.drawable.ic_dripper;
        }
        else return R.drawable.ic_french_press;
    }
}

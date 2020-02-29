package com.example.allaboutcoffee.ShowItemCoffee;

import android.app.Application;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.allaboutcoffee.Coffee.Coffee;

public class CViewCoffeeModel extends AndroidViewModel {

    private Coffee coffee;

    public CViewCoffeeModel(@NonNull Application application) {
        super(application);
    }

    public String getName(){
        return this.coffee.getName();
    }

 //wont return the correct value at the moment
    public int calculateAmount(int waterAmount, Coffee coffee){

        return (int) (waterAmount*1.0/coffee.getWaterAmount()*1.0) * coffee.getCoffeeAmount();
    }







    public void setTexts(final TextView textView, final EditText editText, final Coffee coffee){
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                System.out.println(charSequence.toString() + " the i`s   : " +  i + "   " + i1 + "   " + i2);
                int input = 404;
                try {
                    input = calculateAmount(Integer.parseInt(charSequence.toString()), coffee);
                }
                catch (NumberFormatException e){}

                String ab = Integer.toString(input);
                textView.setText(ab);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }


}

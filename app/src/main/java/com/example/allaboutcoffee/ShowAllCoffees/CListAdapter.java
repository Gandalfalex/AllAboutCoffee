package com.example.allaboutcoffee.ShowAllCoffees;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.allaboutcoffee.ShowItemCoffee.CView_Activity;
import com.example.allaboutcoffee.Coffee.Coffee;
import com.example.allaboutcoffee.Coffee.EstimatedUsage;
import com.example.allaboutcoffee.R;

import java.io.Serializable;
import java.util.List;

public class CListAdapter extends RecyclerView.Adapter<CListAdapter.CViewHolder> {

    private LayoutInflater layoutInflater;
    private List<Coffee> coffees;
    private Context context;

    public CListAdapter(Context context){
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public CViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new CViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CViewHolder holder, final int position) {
        if(coffees == null){
            holder.textView.setText("Some Error");
        }
        else {
            Coffee coffee = coffees.get(position);
            holder.textView.setText(coffee.getName());
            holder.ratioTextView.setText(coffee.getWaterAmount() + "/" + coffee.getCoffeeAmount());
            holder.usageTextView.setText(coffee.getUsage().toString());
            if(coffee.getUsage().equals(EstimatedUsage.AERO_PRESS)) holder.imageView.setBackgroundResource(R.drawable.ic_aero_press);
            else if(coffee.getUsage().equals(EstimatedUsage.DRIPPER)) holder.imageView.setBackgroundResource(R.drawable.dripperfourthtphase);
            else holder.imageView.setBackgroundResource(R.drawable.ic_normal_coffee);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startNewActivity(view, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (coffees != null)
            return coffees.size();
        return 0;
    }

    public void setText(List<Coffee> coffeeList){
        coffees = coffeeList;
        notifyDataSetChanged();
    }

    public class CViewHolder extends RecyclerView.ViewHolder{

        private final TextView textView;
        private final TextView ratioTextView;
        private final TextView usageTextView;
        private final ImageView imageView;

        public CViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.mainTextView);
            ratioTextView = itemView.findViewById(R.id.ratioTextView);
            usageTextView = itemView.findViewById(R.id.usageTextView);
            imageView = itemView.findViewById(R.id.usageImageView);
        }
    }


    private void startNewActivity(View view, int pos){
        Intent intent = new Intent(view.getContext(), CView_Activity.class);
        Coffee coffee = coffees.get(pos);
        intent.putExtra("coffeeObj", (Serializable) coffee);
        context.startActivity(intent);

    }


}

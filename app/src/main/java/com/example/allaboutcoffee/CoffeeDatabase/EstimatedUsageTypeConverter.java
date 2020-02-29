package com.example.allaboutcoffee.CoffeeDatabase;

import androidx.room.TypeConverter;

import com.example.allaboutcoffee.Coffee.EstimatedUsage;


public class EstimatedUsageTypeConverter {

    @TypeConverter()
    public static int toInt(EstimatedUsage estimatedUsage){
        if(estimatedUsage.equals(EstimatedUsage.AERO_PRESS)) return 0;
        else if(estimatedUsage.equals(EstimatedUsage.DRIPPER)) return 1;
        else if(estimatedUsage.equals(EstimatedUsage.FRENCH_PRESS)) return 2;
        else return 3;
    }

    @TypeConverter()
    public static EstimatedUsage toEstimatedUsage(int i){
        if (i == 0) return EstimatedUsage.AERO_PRESS;
        else if(i == 1) return EstimatedUsage.DRIPPER;
        else if(i == 2) return EstimatedUsage.FRENCH_PRESS;
        else return EstimatedUsage.UNKNOWN;
    }
}

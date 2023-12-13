package com.example.conversiondevise;

import java.text.DecimalFormat;

public class Conversion {
    private double argent=0;
    DecimalFormat df = new DecimalFormat("#.##");


    public double FR_CA(double argent){

        return (double)(argent*1.49);

    }
    public double FR_US(double argent){

        return (double)(argent*1.11);

    }

    public double CA_FR(double argent){

        return (double)(argent/1.49);

    }
    public double CA_US(double argent){

        return (double)(argent/1.37);

    }

    public double US_FR(double argent){

        return (double)(argent/1.11);

    }
    public double US_CA(double argent){

        return (double)(argent*1.37);

    }






}

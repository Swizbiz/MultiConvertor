package com.swizbiz.multiconvertor.model;

import androidx.annotation.StringRes;

import com.swizbiz.multiconvertor.R;

public enum Unit {
    METER(R.string.meter, 1.0, 1.0),
    CENTIMETRE(R.string.centimetre, 0.01, 100.0),
    MILE(R.string.mile, 1609.344, 0.0006213),
    KILOMETRE(R.string.kilometre, 1000.0, 0.001),


    SQ_METER(R.string.sq_meter, 1.0, 1.0),
    SQ_CENTIMETRE(R.string.sq_centimetre, 0.0001, 100000.0),
    SQ_KILOMETRE(R.string.sq_kilometre, 1000000.0, 0.000001);

    @StringRes
    public final int label;
    public final double conversionToBase;
    public final double conversionFromBase;


    Unit(int label, double conversionToBase, double conversionFromBase) {
        this.label = label;
        this.conversionToBase = conversionToBase;
        this.conversionFromBase = conversionFromBase;
    }

}

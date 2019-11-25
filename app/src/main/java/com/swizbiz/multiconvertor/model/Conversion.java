package com.swizbiz.multiconvertor.model;

import androidx.annotation.StringRes;

import com.swizbiz.multiconvertor.R;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.swizbiz.multiconvertor.model.Unit.*;

public enum Conversion {
    SQUARE(R.string.square, Arrays.asList(SQ_METER, SQ_KILOMETRE, SQ_CENTIMETRE)),
    LENGTH(R.string.length, Arrays.asList(METER, CENTIMETRE, KILOMETRE, MILE)),
    CURRENCY(R.string.currency, Collections.emptyList()),
    SPEED(R.string.speed, Collections.EMPTY_LIST);

    @StringRes
    public int label;
    public List<Unit> units;


    Conversion(@StringRes int label, List<Unit> units) {
        this.label = label;
        this.units = units;
    }
}

package com.swizbiz.multiconvertor;

import androidx.annotation.NonNull;

import com.swizbiz.multiconvertor.model.Conversion;

public interface MainItemClickListener {
    void onMainItemClick(@NonNull Conversion conversion);
}

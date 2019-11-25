package com.swizbiz.multiconvertor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.swizbiz.multiconvertor.adapters.ConversionAdapter;
import com.swizbiz.multiconvertor.model.Conversion;

import java.util.Arrays;

public class MainActivity extends Activity implements MainItemClickListener {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setAdapter(new ConversionAdapter(Arrays.asList(Conversion.values()), this));
    }

    @Override
    public void onMainItemClick(@NonNull Conversion conversion) {
        final Intent intent = ConverterActivity.getStartIntent(this, conversion);
        startActivity(intent);
    }
}

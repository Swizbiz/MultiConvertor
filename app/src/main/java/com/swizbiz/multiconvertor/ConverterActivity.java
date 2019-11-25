package com.swizbiz.multiconvertor;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.swizbiz.multiconvertor.adapters.UnitSpinnerAdapter;
import com.swizbiz.multiconvertor.model.Conversion;
import com.swizbiz.multiconvertor.model.Unit;

public class ConverterActivity extends AppCompatActivity {
    private final static String EXTRA_CONVERSION = "EXTRA_CONVERSION";
    private EditText conversionFrom;
    private EditText conversionTo;
    private Spinner spinnerFrom;
    private Spinner spinnerTo;
    private Conversion conversion;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.converter_activity);

        conversion = (Conversion) getIntent().getSerializableExtra(EXTRA_CONVERSION);
        if (conversion != null) {
            setTitle(conversion.label);
        }
        conversionFrom = findViewById(R.id.conversion_from);
        conversionTo = findViewById(R.id.conversion_to);

        spinnerFrom = findViewById(R.id.conversion_from_spinner);
        spinnerTo = findViewById(R.id.conversion_to_spinner);
        UnitSpinnerAdapter unitSpinnerAdapter = new UnitSpinnerAdapter(conversion.units);
        spinnerFrom.setAdapter(unitSpinnerAdapter);
        spinnerTo.setAdapter(unitSpinnerAdapter);
        spinnerFrom.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String fromText = conversionFrom.getText().toString();
                if (!fromText.isEmpty())
                    recountFrom(Double.parseDouble(fromText));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        spinnerTo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String toText = conversionTo.getText().toString();
                if (!toText.isEmpty())
                    recountTo(Double.parseDouble(toText));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        conversionFrom.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (conversionFrom.hasFocus()) {
                    if (s.length() != 0) {
                        try {
                            recountFrom(Double.parseDouble(s.toString()));
                        } catch (NumberFormatException e) {
                            Toast.makeText(ConverterActivity.this, R.string.only_digits, Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        conversionTo.setText("");
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        conversionTo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (conversionTo.hasFocus()) {
                    if (s.length() != 0) {
                        try {
                            recountTo(Double.parseDouble(s.toString()));
                        } catch (NumberFormatException e) {
                            Toast.makeText(ConverterActivity.this, R.string.only_digits, Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        conversionFrom.setText("");
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    public static Intent getStartIntent(@NonNull Context context, Conversion conversion) {
        Intent intent = new Intent(context, ConverterActivity.class);
        intent.putExtra(EXTRA_CONVERSION, conversion);
        return intent;
    }

    private void recountFrom(double value) {
        conversionTo.setText(String.valueOf(value
                * ((Unit) spinnerFrom.getSelectedItem()).conversionToBase
                * ((Unit) spinnerTo.getSelectedItem()).conversionFromBase));
    }

    private void recountTo(double value) {
        conversionFrom.setText(String.valueOf(value
                * ((Unit) spinnerTo.getSelectedItem()).conversionToBase
                * ((Unit) spinnerFrom.getSelectedItem()).conversionFromBase));
    }
}

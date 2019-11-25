package com.swizbiz.multiconvertor.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.swizbiz.multiconvertor.model.Unit;

import java.util.List;

public class UnitSpinnerAdapter extends BaseAdapter {
    private List<Unit> units;

    public UnitSpinnerAdapter(@NonNull List<Unit> units) {
        this.units = units;
    }

    @Override
    public int getCount() {
        return units.size();
    }

    @Override
    public Unit getItem(int position) {
        return units.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext())
                    .inflate(android.R.layout.simple_list_item_1, parent, false);
            convertView.setTag(new UnitHolder(convertView));
        }
        UnitHolder holder = (UnitHolder) convertView.getTag();
        int titleResourceId = getItem(position).label;
        holder.label.setText(titleResourceId);
        return convertView;
    }

    private class UnitHolder {
        private final TextView label;

        private UnitHolder(View root) {
            label = root.findViewById(android.R.id.text1);
        }
    }
}

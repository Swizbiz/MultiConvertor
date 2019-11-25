package com.swizbiz.multiconvertor.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.swizbiz.multiconvertor.MainItemClickListener;
import com.swizbiz.multiconvertor.R;
import com.swizbiz.multiconvertor.model.Conversion;

import java.util.List;

public class ConversionAdapter extends RecyclerView.Adapter<ConversionAdapter.ConversionViewHolder> {

    private final List<Conversion> conversions;
    private final MainItemClickListener mainItemClickListener;

    public ConversionAdapter(@NonNull List<Conversion> conversions, @NonNull MainItemClickListener mainItemClickListener) {
        this.conversions = conversions;
        this.mainItemClickListener = mainItemClickListener;
    }

    @NonNull
    @Override
    public ConversionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.conversion, parent, false);
        return new ConversionViewHolder(view, mainItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ConversionViewHolder holder, int position) {
        holder.bindView(conversions.get(position));
    }

    @Override
    public int getItemCount() {
        return conversions.size();
    }

    static class ConversionViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;
        private final MainItemClickListener mainItemClickListener;

        ConversionViewHolder(@NonNull View itemView, MainItemClickListener mainItemClickListener) {
            super(itemView);
            textView = itemView.findViewById(R.id.conversion);
            this.mainItemClickListener =  mainItemClickListener;
        }

        void bindView(final Conversion conversion) {
            textView.setText(conversion.label);
            itemView.setOnClickListener(v -> mainItemClickListener.onMainItemClick(conversion));
        }
    }
}

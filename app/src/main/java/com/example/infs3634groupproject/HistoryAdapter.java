package com.example.infs3634groupproject;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.infs3634groupproject.Model.History;

import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder> {
    private List<History> historyToAdapt;

    public void setData (List<History> historyToAdapt) {
        this.historyToAdapt = historyToAdapt;
    }


    @NonNull
    @Override
    public HistoryAdapter.HistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.history, parent, false);

        HistoryViewHolder historyViewHolder = new HistoryViewHolder(view);
        return historyViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryAdapter.HistoryViewHolder holder, int position) {
        final History historyAtPosition = historyToAdapt.get(position);
        holder.exerciseNameTV.setText(historyAtPosition.getExerciseName());
        holder.historyDateTV.setText(historyAtPosition.getDate());
        holder.history1RMTV.setText(String.valueOf(historyAtPosition.getOneRM())+ "kg");
        holder.historyWeightTV.setText(String.valueOf(historyAtPosition.getWeight())+ "kg");
        holder.historyRepsTV.setText(String.valueOf(historyAtPosition.getReps()));


    }

    @Override
    public int getItemCount() {
        return historyToAdapt.size();
    }

    public static class HistoryViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public TextView historyDateTV;
        public TextView exerciseNameTV;
        public TextView historyWeightTV;
        public TextView history1RMTV;
        public TextView historyRepsTV;

        public HistoryViewHolder (View v) {
            super(v);
            view = v;
            historyDateTV= v.findViewById(R.id.historyDate);
            exerciseNameTV = v.findViewById(R.id.histExerciseName);
            historyWeightTV=v.findViewById(R.id.historyWeight);
            history1RMTV = v.findViewById(R.id.history1RM);
            historyRepsTV = v.findViewById(R.id.historyReps);

        }



    }
 }

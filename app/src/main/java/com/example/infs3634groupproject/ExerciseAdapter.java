package com.example.infs3634groupproject;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.infs3634groupproject.Activity.ExerciseDetailActivity;
import com.example.infs3634groupproject.Model.Exercise;

import java.util.List;

public class ExerciseAdapter extends RecyclerView.Adapter<ExerciseAdapter.ExerciseViewHolder> {

    private List<Exercise> exercisesToAdapt;

    public void setData (List<Exercise> exercisesToAdapt) {
        this.exercisesToAdapt = exercisesToAdapt;

    }

    @NonNull
    @Override
    public ExerciseViewHolder onCreateViewHolder (@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.exercise, parent,false);


        ExerciseViewHolder exerciseViewHolder = new ExerciseViewHolder(view);
        return exerciseViewHolder;
    }

    @Override
    public void onBindViewHolder (@NonNull ExerciseViewHolder holder, int position) {

        final Exercise exerciseAtPosition = exercisesToAdapt.get(position);
        if(position %2 == 1)
        {
            holder.itemView.setBackgroundColor(Color.parseColor("#687AEDF8"));
            //  holder.imageView.setBackgroundColor(Color.parseColor("#FFFFFF"));
        }
        else
        {
            holder.itemView.setBackgroundColor(Color.parseColor("#FFFFFF"));
            //  holder.imageView.setBackgroundColor(Color.parseColor("#FFFAF8FD"));
        }


        holder.exerciseName.setText(exerciseAtPosition.getExerciseName());

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent (context, ExerciseDetailActivity.class);
                intent.putExtra("exerciseID", exerciseAtPosition.getExerciseID());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return exercisesToAdapt.size();
    }


    public static class ExerciseViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public TextView exerciseName;


        public ExerciseViewHolder ( View v) {
            super(v);
            view = v;
            exerciseName = v.findViewById(R.id.histExerciseName);

        }





    }
}

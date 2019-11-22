package com.example.infs3634groupproject.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.infs3634groupproject.Database.AppDatabase;
import com.example.infs3634groupproject.ExerciseAdapter;
import com.example.infs3634groupproject.Model.Exercise;
import com.example.infs3634groupproject.R;

import java.util.ArrayList;
import java.util.List;

public class ExerciseFragment extends Fragment {

    private RecyclerView recyclerViewMain;
    private RecyclerView recyclerViewAdd;
    public ExerciseFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_exercise1, container, false);

        //Populate Main rv
        recyclerViewMain = view.findViewById(R.id.rvMainExercise);
        ArrayList<Exercise> exerciseMainArrayList = new ArrayList<>();

        AppDatabase db = AppDatabase.getInstance(getContext());

        exerciseMainArrayList.add(db.exerciseDao().findExerciseByID(111));
        exerciseMainArrayList.add(db.exerciseDao().findExerciseByID(192));
        exerciseMainArrayList.add(db.exerciseDao().findExerciseByID(105));
        exerciseMainArrayList.add(db.exerciseDao().findExerciseByID(229));

        List<Exercise> exerciseList = exerciseMainArrayList;
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        recyclerViewMain.setLayoutManager(layoutManager);

        final ExerciseAdapter exerciseAdapter = new ExerciseAdapter();




        exerciseAdapter.setData(exerciseList);
        recyclerViewMain.setAdapter(exerciseAdapter);
        Toast.makeText(getContext(), "Response Received", Toast.LENGTH_SHORT).show();


        //populate add rv
        recyclerViewAdd = view.findViewById(R.id.rvAddExercises);
        List<Exercise> exerciseAddArrayList = db.exerciseDao().getAddExercises();
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(view.getContext());
        recyclerViewAdd.setLayoutManager(layoutManager1);
        final ExerciseAdapter exerciseAdapter1 = new ExerciseAdapter();
        exerciseAdapter1.setData(exerciseAddArrayList);
        recyclerViewAdd.setAdapter(exerciseAdapter1);







        return view;
    }
}

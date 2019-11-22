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
import com.example.infs3634groupproject.HistoryAdapter;
import com.example.infs3634groupproject.Model.History;
import com.example.infs3634groupproject.R;

import java.util.ArrayList;
import java.util.List;

public class HistoryFragment extends Fragment {

    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_history, container, false);
        recyclerView = view.findViewById(R.id.rvMainExercise);
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);
        final HistoryAdapter historyAdapter = new HistoryAdapter();

        AppDatabase db = AppDatabase.getInstance(getContext());

        List<History> historyList =  db.historyDao().getAll();
        ArrayList<History> historyArrayList = new ArrayList<>(historyList);
        historyAdapter.setData(historyArrayList);
        recyclerView.setAdapter(historyAdapter);

        return view;
    }
}

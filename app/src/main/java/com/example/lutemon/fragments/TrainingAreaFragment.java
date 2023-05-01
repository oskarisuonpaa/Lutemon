package com.example.lutemon.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.lutemon.MainActivity;
import com.example.lutemon.R;
import com.example.lutemon.lutemon.Lutemon;
import com.example.lutemon.misc.HomeAdapter;
import com.example.lutemon.misc.TrainingAreaAdapter;
import com.example.lutemon.storage.Home;
import com.example.lutemon.storage.TrainingArea;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class TrainingAreaFragment extends Fragment {

    private  View view;
    private  MainActivity activity;
    private  Spinner spinner;
    private  Home home;
    private  TrainingArea trainingArea;
    private HashMap<Integer, Lutemon> trainingAreaLutemons, homeLutemons;
    private  HashMap<String,Integer> lutemons;
    private  ArrayList<String> valuesList;
    private  RecyclerView recyclerView;
    private TrainingAreaAdapter adapter;
    private static TrainingAreaFragment instance;

    public TrainingAreaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_training_area, container, false);

        instance = this;

        activity = (MainActivity) getActivity();

        trainingArea = activity.getTrainingArea();
        trainingAreaLutemons = trainingArea.getLutemons();

        home = activity.getHome();
        homeLutemons = home.getLutemons();

        recyclerView = view.findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        adapter = new TrainingAreaAdapter(view.getContext(), trainingArea.getLutemonIDs(), trainingArea.getLutemons(), home);
        recyclerView.setAdapter(adapter);

        spinner = view.findViewById(R.id.spinner);

        populateSpinner();

        Button button = view.findViewById(R.id.button);
        button.setOnClickListener(view1 -> {
            if (spinner.getSelectedItem() != null){
                int index = lutemons.get(spinner.getSelectedItem().toString());
                Lutemon lutemon = home.getLutemon(index);
                trainingArea.addLutemon(lutemon);
                home.removeLutemon(index);
                updateView();
                populateSpinner();
            }
        });

        trainingArea.train();

        return view;
    }

    public void populateSpinner() {
        lutemons = new HashMap<>();
        valuesList = new ArrayList<>();

        for (Map.Entry<Integer, Lutemon> entry : homeLutemons.entrySet()){
            lutemons.put(entry.getValue().getName(), entry.getKey());
            valuesList.add(entry.getValue().getName());
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(view.getContext(),android.R.layout.simple_list_item_1, valuesList);
        spinner.setAdapter(arrayAdapter);
    }

    public void updateView(){
        adapter = new TrainingAreaAdapter(view.getContext(), activity.getTrainingArea().getLutemonIDs(), activity.getTrainingArea().getLutemons(), home);
        recyclerView.setAdapter(adapter);
    }

    public static TrainingAreaFragment getInstance() {
        return instance;
    }
}
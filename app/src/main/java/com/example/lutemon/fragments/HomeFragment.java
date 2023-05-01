package com.example.lutemon.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.lutemon.MainActivity;
import com.example.lutemon.R;
import com.example.lutemon.lutemon.Black;
import com.example.lutemon.lutemon.Green;
import com.example.lutemon.lutemon.Lutemon;
import com.example.lutemon.lutemon.Orange;
import com.example.lutemon.lutemon.Pink;
import com.example.lutemon.lutemon.White;
import com.example.lutemon.misc.HomeAdapter;
import com.example.lutemon.storage.Home;


public class HomeFragment extends Fragment {

    View view;
    RecyclerView recyclerView;
    MainActivity activity;
    HomeAdapter adapter;
    EditText editText;
    Spinner spinner;
    Button button;
    HomeFragment instance;
    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home, container, false);

        instance = this;

        activity = (MainActivity) getActivity();

        recyclerView = view.findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        adapter = new HomeAdapter(view.getContext(), activity.getHome().getLutemons(), activity.getHome().getLutemonIDs());
        recyclerView.setAdapter(adapter);

        editText = view.findViewById(R.id.editText);
        spinner = view.findViewById(R.id.spinner);

        button = view.findViewById(R.id.button);
        button.setOnClickListener(view1 -> {
            String lutemonName = editText.getText().toString();
            int lutemonColor = spinner.getSelectedItemPosition();
            Lutemon lutemon;

            switch (lutemonColor){
                case 0:
                    lutemon = new White(lutemonName);
                    break;
                case 1:
                    lutemon = new Green(lutemonName);
                    break;
                case 2:
                    lutemon = new Pink(lutemonName);
                    break;
                case 3:
                    lutemon = new Orange(lutemonName);
                    break;
                case 4:
                    lutemon = new Black(lutemonName);
                    break;
                default:
                    lutemon = new White(lutemonName);
            }

            Home home = activity.getHome();
            home.addLutemon(lutemon);
            updateView();
        });

        return view;
    }
    private void updateView(){
        adapter = new HomeAdapter(view.getContext(), activity.getHome().getLutemons(), activity.getHome().getLutemonIDs());
        recyclerView.setAdapter(adapter);
    }

    public HomeFragment getInstance() {
        return instance;
    }
}
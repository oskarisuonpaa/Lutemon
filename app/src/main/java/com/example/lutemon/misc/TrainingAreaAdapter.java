package com.example.lutemon.misc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lutemon.R;
import com.example.lutemon.fragments.TrainingAreaFragment;
import com.example.lutemon.lutemon.Lutemon;
import com.example.lutemon.storage.Home;

import java.util.HashMap;
import java.util.List;

public class TrainingAreaAdapter extends RecyclerView.Adapter<TrainingAreaViewHolder> {

    Context context;
    List<Integer> lutemonIDS;
    HashMap<Integer, Lutemon> lutemons;
    Home home;


    public TrainingAreaAdapter(Context context, List<Integer> lutemonIDS, HashMap<Integer, Lutemon> lutemons, Home home) {
        this.context = context;
        this.lutemonIDS = lutemonIDS;
        this.lutemons = lutemons;
        this.home = home;
    }

    @NonNull
    @Override
    public TrainingAreaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TrainingAreaViewHolder(LayoutInflater.from(context).inflate(R.layout.training_area_lutemon_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull TrainingAreaViewHolder holder, int position) {
        Lutemon lutemon = lutemons.get(lutemonIDS.get(position));

        holder.name.setText(lutemon.getName() + " (" + lutemon.getColor() +")");
        holder.level.setText("Level: " + lutemon.getLevel());
        holder.attack.setText("Attack: " + lutemon.getAttack());
        holder.defense.setText("Defense: " + lutemon.getDefense());
        holder.speed.setText("Speed: " + lutemon.getSpeed());
        holder.health.setText("Health: " + lutemon.getHealth() + "/" + lutemon.getMaxHealth());
        holder.experience.setText("Experience: " + lutemon.getExperience() + "/" + lutemon.getExperienceCap());
        holder.button.setOnClickListener(view -> {
            lutemons.remove(lutemonIDS.get(position));
            lutemonIDS.remove(position);
            home.addLutemon(lutemon);
            TrainingAreaFragment.getInstance().populateSpinner();
            notifyItemRemoved(position);
        });
    }

    @Override
    public int getItemCount() {
        return lutemonIDS.size();
    }
}

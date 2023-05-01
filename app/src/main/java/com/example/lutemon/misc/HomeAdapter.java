package com.example.lutemon.misc;

import android.content.Context;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lutemon.R;
import com.example.lutemon.lutemon.Lutemon;


import java.util.HashMap;
import java.util.List;


public class HomeAdapter extends RecyclerView.Adapter<HomeViewHolder> {
    
    Context context;
    HashMap<Integer, Lutemon> lutemons;
    List<Integer> lutemonIDS;

    public HomeAdapter(Context context, HashMap<Integer, Lutemon> lutemons, List<Integer> lutemonIDS) {
        this.context = context;
        this.lutemons = lutemons;
        this.lutemonIDS = lutemonIDS;
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HomeViewHolder(LayoutInflater.from(context).inflate(R.layout.home_lutemon_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {
        int id = lutemonIDS.get(position);
        Lutemon lutemon = lutemons.get(id);

        holder.name.setText(lutemon.getName() + " (" + lutemon.getColor() +")");
        holder.type.setText("Type: " + lutemon.getTypeString());
        holder.level.setText("Level: " + lutemon.getLevel());
        holder.attack.setText("Attack: " + lutemon.getAttack());
        holder.defense.setText("Defense: " + lutemon.getDefense());
        holder.speed.setText("Speed: " + lutemon.getSpeed());
        holder.health.setText("Health: " + lutemon.getHealth() + "/" + lutemon.getMaxHealth());
        holder.experience.setText("Experience: " + lutemon.getExperience() + "/" + lutemon.getExperienceCap());
    }

    @Override
    public int getItemCount() {
        return lutemons.size();
    }
}

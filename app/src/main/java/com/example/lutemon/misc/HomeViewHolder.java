package com.example.lutemon.misc;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lutemon.R;

public class HomeViewHolder extends RecyclerView.ViewHolder {

    TextView name, type, level, attack, defense, speed, health, experience;

    public HomeViewHolder(@NonNull View itemView) {
        super(itemView);

        name = itemView.findViewById(R.id.textViewName);
        level = itemView.findViewById(R.id.textViewLevel);
        attack = itemView.findViewById(R.id.textViewAttack);
        defense = itemView.findViewById(R.id.textViewDefense);
        speed = itemView.findViewById(R.id.textViewSpeed);
        health = itemView.findViewById(R.id.textViewHealth);
        experience = itemView.findViewById(R.id.textViewExperience);
        type = itemView.findViewById(R.id.textViewType);
    }
}

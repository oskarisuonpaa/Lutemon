package com.example.lutemon.storage;

import android.util.Log;

import com.example.lutemon.lutemon.Lutemon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Storage {
    protected String name;
    protected HashMap<Integer, Lutemon> lutemons;

    public Storage(String name) {
        this.name = name;
        this.lutemons = new HashMap<Integer,Lutemon>();
    }

    public Lutemon getLutemon(int id) {
        return lutemons.get(id);
    }

    public HashMap<Integer, Lutemon> getLutemons() {
        return lutemons;
    }

    public List<Integer> getLutemonIDs() {
        List<Integer> ids = new ArrayList<>();
        for (Map.Entry<Integer, Lutemon> entry: lutemons.entrySet()
             ) {
            ids.add(entry.getKey());
        }
        return ids;
    }

    public void addLutemon(Lutemon lutemon) {
        lutemons.put(lutemon.getId(), lutemon);
    }

    public void removeLutemon(int id) {
        lutemons.remove(id);
    }
}

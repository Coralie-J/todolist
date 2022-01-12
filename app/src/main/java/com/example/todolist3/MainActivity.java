package com.example.todolist3;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.todolist3.list.TodoListAdapter;
import com.example.todolist3.ui.main.SectionsPagerAdapter;
import com.example.todolist3.databinding.ActivityMainBinding;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private ArrayList<Task> tasks;
    private TodoListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = binding.viewPager;
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = binding.tabs;
        tabs.setupWithViewPager(viewPager);
        binding.fab.hide();

        restoreTasks();
        this.adapter = new TodoListAdapter(tasks);

    }

    @SuppressLint("NotifyDataSetChanged")
    public void addToArrayList(String nom_tache, String details, String date, String heure_debut, String heure_fin){
        Task new_task = new Task(nom_tache, details, date, heure_debut, heure_fin);
        this.tasks.add(new_task);
        this.adapter.notifyDataSetChanged();
    }

    public TodoListAdapter getAdapter() {
        return adapter;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("TEST", "Application stoppée");
        SharedPreferences sharedPreferences = getSharedPreferences("todolist", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String tasks_string = gson.toJson(tasks);
        editor.putString("tasks", tasks_string);
        editor.apply();
    }

    public void restoreTasks(){
        SharedPreferences sharedPreferences = getSharedPreferences("todolist", MODE_PRIVATE);
        String tasks_json = sharedPreferences.getString("tasks", null);
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Task>>(){}.getType();
        this.tasks = gson.fromJson(tasks_json, type);

        if (this.tasks == null)
            this.tasks = new ArrayList<>();
    }
}
package com.example.todolist3;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.todolist3.list.TodoListAdapter;
import com.example.todolist3.ui.main.SectionsPagerAdapter;
import com.example.todolist3.databinding.ActivityMainBinding;

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

        this.tasks = new ArrayList<>();
        this.adapter = new TodoListAdapter(tasks);

    }

    @SuppressLint("NotifyDataSetChanged")
    public void addToArrayList(String nom_tache, String details, String date){
        Task new_task = new Task(nom_tache, details, date);
        this.tasks.add(new_task);
        this.adapter.notifyDataSetChanged();
    }

    public TodoListAdapter getAdapter() {
        return adapter;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }
}
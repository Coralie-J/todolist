package com.example.todolist3.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.todolist3.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListTaskFragment} factory method to
 * create an instance of this fragment.
 */
public class ListTaskFragment extends Fragment {

    public ListTaskFragment() {
        super();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_task, container, false);
    }
}
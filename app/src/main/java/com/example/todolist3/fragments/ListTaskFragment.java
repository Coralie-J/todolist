package com.example.todolist3.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.todolist3.MainActivity;
import com.example.todolist3.R;
import com.example.todolist3.list.TodoListAdapter;

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_list_task, container, false);
        RecyclerView recyclerView = layout.findViewById(R.id.recyclerview);

        RecyclerView.LayoutManager manager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(manager);

        MainActivity mainActivity = (MainActivity) getActivity();
        recyclerView.setAdapter(mainActivity.getAdapter());

        return layout;
    }
}
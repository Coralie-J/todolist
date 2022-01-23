package com.example.todolist3.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.todolist3.MainActivity;
import com.example.todolist3.R;
import com.example.todolist3.Task;
import com.example.todolist3.list.TodoListAdapter;

import java.util.Iterator;
import java.util.Objects;

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
        Button bouton_supprimer = layout.findViewById(R.id.btn_supprimer);

        RecyclerView.LayoutManager manager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(manager);

        MainActivity mainActivity = (MainActivity) getActivity();
        recyclerView.setAdapter(mainActivity.getAdapter());

        bouton_supprimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                for (int i=0; i < recyclerView.getChildCount(); i++){
                    View viewItem = recyclerView.findViewHolderForLayoutPosition(i).itemView;
                    CheckBox checkBox_task = viewItem.findViewById(R.id.check_item);
                    String nom_task = ((TextView) viewItem.findViewById(R.id.tv_nom_task)).getText().toString();
                    String date = ((TextView) viewItem.findViewById(R.id.tv_date_task)).getText().toString();

                    if (checkBox_task.isChecked()){
                        Iterator itr = mainActivity.getTasks().iterator();

                        while (itr.hasNext()){
                            Task task = (Task) itr.next();
                            if (task.getNom().equals(nom_task) && task.getDate().equals(date)){
                                itr.remove();
                                Log.i("RECYCLER Supprimé", task.toString());
                            }
                        }

                        mainActivity.getAdapter().notifyDataSetChanged();
                        // mainActivity.getAdapter().notifyItemRemoved(i);
                    }
                }

                for (int i=0; i < recyclerView.getChildCount(); i++){
                    View viewItem = recyclerView.findViewHolderForLayoutPosition(i).itemView;
                    CheckBox checkBox_task = viewItem.findViewById(R.id.check_item);
                    checkBox_task.setChecked(false);
                }
            }
        });

        return layout;
    }
}
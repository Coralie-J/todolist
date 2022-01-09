package com.example.todolist3.list;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.todolist3.R;
import com.example.todolist3.Task;

import java.util.ArrayList;

public class TodoListAdapter extends RecyclerView.Adapter {

    private class ItemView extends RecyclerView.ViewHolder{

        private TextView date;
        private TextView nom_tache;
        private TextView details;
        private TextView heures;
        private Button bouton_supprimer;

        public ItemView(View itemView){
            super(itemView);
            this.date = itemView.findViewById(R.id.tv_date_task);
            this.details = itemView.findViewById(R.id.tv_details);
            this.nom_tache = itemView.findViewById(R.id.tv_nom_task);
            this.heures = itemView.findViewById(R.id.tv_heure_task);
            this.bouton_supprimer = itemView.findViewById(R.id.btn_suppr_task);
        }
    }

    private ArrayList<Task> tasks;

    public TodoListAdapter(ArrayList<Task> datas){
        this.tasks = datas;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View layout = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.todolist_item, viewGroup, false);
        return new ItemView(layout);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        Task current_task = this.tasks.get(i);

        ((ItemView) viewHolder).nom_tache.setText(current_task.getNom());
        ((ItemView) viewHolder).date.setText(current_task.getDate());
        ((ItemView) viewHolder).heures.setText(String.format("De %s à %s", current_task.getHeureDebut(), current_task.getHeureFin()));
        ((ItemView) viewHolder).details.setText(current_task.getDescription());

        ((ItemView) viewHolder).bouton_supprimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TodoListAdapter.this.tasks.remove(current_task);
                TodoListAdapter.this.notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

}

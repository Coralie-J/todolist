package com.example.todolist3.list;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.todolist3.R;

public class ItemView extends RecyclerView.ViewHolder {

    private TextView date;
    private TextView nom_tache;
    private TextView details;
    private Button bouton_supprimer;

    public ItemView(@NonNull View itemView) {
        super(itemView);
        this.date = (TextView) itemView.findViewById(R.id.tv_date_task);
        this.nom_tache = (TextView) itemView.findViewById(R.id.tv_nom_task);
        this.details = (TextView) itemView.findViewById(R.id.tv_details);
        this.bouton_supprimer = (Button) itemView.findViewById(R.id.btn_suppr_task);
    }
}

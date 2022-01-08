package com.example.todolist3.fragments;

import android.app.DatePickerDialog;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.example.todolist3.MainActivity;
import com.example.todolist3.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * A simple {@link Fragment} subclass.
 */

public class TaskFragment extends Fragment {


    public TaskFragment() {
        // Required empty public constructor
        super();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.fragment_task, container, false);

        Button bouton_date = layout.findViewById(R.id.btn_select_date);
        Button bouton_add = layout.findViewById(R.id.btn_add_task);
        EditText edit_date = layout.findViewById(R.id.edit_date);
        EditText edit_nom_task = layout.findViewById(R.id.edit_nom_task);
        EditText edit_details = layout.findViewById(R.id.edit_details);

        bouton_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getActivity().getClass() == MainActivity.class){
                    MainActivity parent = (MainActivity) getActivity();
                    parent.addToArrayList(
                            edit_nom_task.getText().toString(),
                            edit_details.getText().toString(),
                            edit_date.getText().toString()
                    );
                }
            }
        });

        this.setDateDialogPicker(edit_date, bouton_date);

        return layout;
    }

    public void setDateDialogPicker(EditText edit_date, Button bouton_date){

        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                edit_date.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
            }
        };

        bouton_date.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        v.getContext(),
                        android.R.style.Theme_Holo_Light_Dialog_NoActionBar,
                        dateSetListener, 2021, 5, 21
                );

                datePickerDialog.show();
            }
        });

    }

}
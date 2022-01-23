package com.example.todolist3.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.applandeo.materialcalendarview.CalendarView;
import com.applandeo.materialcalendarview.EventDay;
import com.example.todolist3.MainActivity;
import com.example.todolist3.R;
import com.example.todolist3.Task;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 */

public class CalendrierFragment extends Fragment {

    public CalendrierFragment() {
        // Required empty public constructor
        super();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_calendrier, container, false);
        CalendarView calendarView = layout.findViewById(R.id.calendar);

        MainActivity mainActivity = (MainActivity) getActivity();

        ArrayList<Task> tasks = mainActivity.getTasks();
        List<EventDay> eventDays = new ArrayList<>();

        for (Task task : tasks){
            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.FRANCE);
            try {
                calendar.setTime(Objects.requireNonNull(simpleDateFormat.parse(task.getDate())));
                EventDay eventDay = new EventDay(calendar, R.drawable.cloche);
                eventDays.add(eventDay);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        calendarView.setEvents(eventDays);

        return layout;
    }
}
package com.example.todolist3.fragments;

import android.app.AlertDialog;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.applandeo.materialcalendarview.CalendarView;
import com.applandeo.materialcalendarview.EventDay;
import com.applandeo.materialcalendarview.listeners.OnDayClickListener;
import com.example.todolist3.MainActivity;
import com.example.todolist3.R;
import com.example.todolist3.Task;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 */

public class CalendrierFragment extends Fragment implements OnDayClickListener {

    private CalendarView calendarView;
    private List<EventDay> eventDays;


    public CalendrierFragment() {
        super();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_calendrier, container, false);
        this.calendarView = layout.findViewById(R.id.calendar);
        this.eventDays = new ArrayList<>();
        initTaskDay();
        calendarView.setEvents(eventDays);
        calendarView.setOnDayClickListener(this);

        return layout;
    }

    @Override
    public void onDayClick(EventDay eventDay) {
        Date date = eventDay.getCalendar().getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.FRANCE);
        String date_string = simpleDateFormat.format(date).toUpperCase();
        String tasklist = "";
        MainActivity mainActivity = (MainActivity) getActivity();

        for (Task task: mainActivity.getTasks()){
            try {
                Date d = new SimpleDateFormat("dd/MM/yyyy", Locale.FRANCE).parse(task.getDate());
                if (d.compareTo(date) == 0)
                    tasklist += "- " + task.getNom() + "\n ";
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        if (! tasklist.isEmpty()){
            AlertDialog.Builder builder = new AlertDialog.Builder(mainActivity);
            builder.setMessage(tasklist);
            builder.setNeutralButton("Ok", null);
            AlertDialog popup = builder.create();
            popup.show();
        }
    }

    public void initTaskDay(){
        MainActivity mainActivity = (MainActivity) getActivity();
        ArrayList<Task> tasks = mainActivity.getTasks();

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
    }

}
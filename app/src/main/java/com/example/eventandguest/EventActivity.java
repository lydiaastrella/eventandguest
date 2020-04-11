package com.example.eventandguest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class EventActivity extends AppCompatActivity {

    RecyclerView rv;
    private ArrayList<Event> list;
    final String STATE_LIST = "state_list";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        rv = findViewById(R.id.rv_category);
        rv.setHasFixedSize(true);

        list = new ArrayList<>();

        if(savedInstanceState == null){
            list.addAll(EventData.getListData());
        }else{
            ArrayList<Event> stateList = savedInstanceState.getParcelableArrayList(STATE_LIST);
            list.addAll(stateList);
        }

        rv.setLayoutManager(new LinearLayoutManager(this));
        ListEventAdapter listEventAdapter = new ListEventAdapter(this);
        listEventAdapter.setListPresident(list);
        rv.setAdapter(listEventAdapter);
    }
}

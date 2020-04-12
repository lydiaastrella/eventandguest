package com.example.eventandguest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class GuestActivity extends AppCompatActivity {

    RecyclerView rv;
    private GuestViewModel guestViewModel;
    private GridGuestAdapter gridGuestAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest);

        rv = findViewById(R.id.rv_guest);
        rv.setHasFixedSize(true);

        rv.setLayoutManager(new GridLayoutManager(this, 2));
        gridGuestAdapter = new GridGuestAdapter();
        gridGuestAdapter.notifyDataSetChanged();
        guestViewModel = ViewModelProviders.of(this).get(GuestViewModel.class);
        guestViewModel.setGuest();
        guestViewModel.getGuests().observe(this, getGuest);

        rv.setAdapter(gridGuestAdapter);

        gridGuestAdapter.setOnItemClickCallback(new GridGuestAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Guest data) {
                showSelectedGuest(data);
            }
        });
    }

    private Observer<ArrayList<Guest>> getGuest = new Observer<ArrayList<Guest>>() {
        @Override
        public void onChanged(ArrayList<Guest> guestItems) {
            if (guestItems != null) {
                gridGuestAdapter.setData(guestItems);
            }
        }
    };

    private void showSelectedGuest(Guest guest){
        Toast toast = Toast.makeText(this, guest.getFirst_name(), Toast.LENGTH_SHORT);
        toast.show();
    }

}

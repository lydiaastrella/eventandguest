package com.example.eventandguest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Debug;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener{

    public static final String EXTRA_NAME = "extra_name";

    TextView tvName;
    Button btnEvent, btnGuest;

    private int REQUEST_EVENT = 100;
    private int REQUEST_GUEST = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tvName = findViewById(R.id.tv_name);
        btnEvent = findViewById(R.id.btn_event);
        btnGuest = findViewById(R.id.btn_guest);
        btnEvent.setOnClickListener(this);
        btnGuest.setOnClickListener(this);

        String name = getIntent().getStringExtra(EXTRA_NAME);
        String text = "Name : "+ name;
        tvName.setText(text);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btn_event:
                Toast eventToast = Toast.makeText(SecondActivity.this, "Event", Toast.LENGTH_SHORT);
                eventToast.show();
                Intent moveToEvent = new Intent(SecondActivity.this, EventActivity.class);
                startActivityForResult(moveToEvent, REQUEST_EVENT);
                break;
            case R.id.btn_guest:
                Toast guestToast = Toast.makeText(SecondActivity.this, "Guest", Toast.LENGTH_SHORT);
                guestToast.show();
                Intent moveToGuest = new Intent(SecondActivity.this, GuestActivity.class);
                startActivityForResult(moveToGuest, REQUEST_GUEST);
                break;
        }
    }
}

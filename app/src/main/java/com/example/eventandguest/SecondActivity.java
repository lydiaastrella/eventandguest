package com.example.eventandguest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener{

    public static final String EXTRA_NAME = "extra_name";

    TextView tvName;
    Button btnEvent, btnGuest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tvName = findViewById(R.id.tv_name);
        btnEvent = findViewById(R.id.btn_event);
        btnGuest = findViewById(R.id.btn_guest);

        String name = getIntent().getStringExtra(EXTRA_NAME);
        String text = "Name : "+ name;
        tvName.setText(text);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            
        }
    }
}

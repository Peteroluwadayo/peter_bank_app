package com.example.petersapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.SwitchCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class OnePass extends AppCompatActivity {
    private View viewButton,viewLogo;
    private EditText onepassidEditText;
    private AppCompatButton signupButton;
    private SwitchCompat switch1;
    private TextView newuseridTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.one_pass);

        inItView();
        inItlistner();
    }
    public void inItView(){
        viewButton = findViewById(R.id.viewbutton);
        viewLogo = findViewById(R.id.viewlogo);
        onepassidEditText = findViewById(R.id.et_onepassid);
        signupButton = findViewById(R.id.btn_signupbutton);
        switch1 = findViewById(R.id.switch1);
        newuseridTextView = findViewById(R.id.btn_newuserid);
    }
    public void inItlistner(){
        viewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OnePass.this,Login.class);
                startActivity(intent);
            }
        });
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OnePass.this,Login.class);
                startActivity(intent);
            }
        });

    }


}
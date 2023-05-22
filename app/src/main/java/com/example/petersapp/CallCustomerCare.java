package com.example.petersapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class CallCustomerCare extends AppCompatActivity {
    private ImageView imageButton;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.call_customer_care);

        inItview();
        inItlistner();
    }
    public void inItview(){
        imageButton = findViewById(R.id.imagebutton);
        textView = findViewById(R.id.btn_textview);
    }

    public void inItlistner(){
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CallCustomerCare.this,MyBankApp.class);
                startActivity(intent);
            }
        });
    }
}
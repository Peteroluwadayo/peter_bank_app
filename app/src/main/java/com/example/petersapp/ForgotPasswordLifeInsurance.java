package com.example.petersapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ForgotPasswordLifeInsurance extends AppCompatActivity {
    private EditText emailEditText;
    private AppCompatButton signupButton;
    private TextView backtologinTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgot_password_life_insurance);

        inItview();
        inItlistner();
    }
    public void inItview(){
        emailEditText= findViewById(R.id.et_email);
        signupButton = findViewById(R.id.btn_signupbutton);
        backtologinTextView = findViewById(R.id.btn_backtologin);
    }
    public void inItlistner(){
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ForgotPasswordLifeInsurance.this,LifeInsurancePage.class);
                startActivity(intent);
            }
        });
    }
}
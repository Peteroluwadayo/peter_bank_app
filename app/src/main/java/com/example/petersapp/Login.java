package com.example.petersapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Login extends AppCompatActivity {
    private TextView bankButton;
    private TextView mutualButton;
    private TextView pensionButton;
    private TextView easeButton;
    private TextView insuranceButton;
    private TextView stockButton;
    private TextView lifeButton;
    private TextView onePassButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        inItView();
        inItListener();
    }
    public  void inItView(){
        bankButton = findViewById(R.id.btn_bank);
        mutualButton = findViewById(R.id.btn_mutualfund);
        pensionButton = findViewById(R.id.btn_pension);
        easeButton = findViewById(R.id.btn_ease);
        insuranceButton = findViewById(R.id.btn_insurance);
        stockButton = findViewById(R.id.btn_stock);
        lifeButton = findViewById(R.id.btn_life_insurance);
        onePassButton = findViewById(R.id.btn_onepass);


    }
    public void inItListener(){
        bankButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, MyBankApp.class);
                startActivity(intent);
            }
        });
        mutualButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, MutualFund.class);
                startActivity(intent);

            }
        });
        pensionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this,Pension.class);
                startActivity(intent);
            }
        });
        easeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this,Ease.class);
                startActivity(intent);

            }
        });
        insuranceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this,Insurance.class);
                startActivity(intent);
            }
        });
        lifeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent = new Intent(Login.this,LifeInsurancePage.class);
                    startActivity(intent);
            }
        });
        onePassButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this,OnePass.class);
                startActivity(intent);
            }
        });


    }

}
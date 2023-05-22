package com.example.petersapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DashBoardMyBankApp extends AppCompatActivity {
    private AppCompatButton submitButton;
    private AppCompatButton skipButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dash_board_my_bank_app);

        inItView();
        inItlistner();

    }
   public void inItView(){
        submitButton = findViewById(R.id.btn_submitButton);
        skipButton = findViewById(R.id.btn_skipButton);
   }
   public void inItlistner(){
        skipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashBoardMyBankApp.this,SkipDashBoardPage.class);
                startActivity(intent);
            }
        });
   }
}
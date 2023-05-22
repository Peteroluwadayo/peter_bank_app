package com.example.petersapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;

public class ForgetPasscode extends AppCompatActivity {
    private Button signupButton;
    private EditText phoneEdittext,emailEdittex,nameEdittext;
    private CheckBox box;
    private View imageButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forget_passcode);
        inItView();
        inItlistner();

    }
    public void inItView(){
        signupButton = findViewById(R.id.btn_signupbutton);

        emailEdittex = findViewById(R.id.et2);
        nameEdittext = findViewById(R.id.et1);
        imageButton = findViewById(R.id.imageview);
    }
    public void inItlistner(){
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ForgetPasscode.this,Pension.class);
                startActivity(intent);
            }
        });
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ForgetPasscode.this,Pension.class);
                startActivity(intent);
            }
        });
    }

}
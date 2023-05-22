package com.example.petersapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class GetPasscodeInsurance extends AppCompatActivity {

    private EditText emailAddressEditText;
    private ImageView image2;
    private AppCompatButton logIn;


    public String emailAddress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.get_passcode);

        inItView();
        inItListener();
    }
    public void inItView(){

        emailAddressEditText = findViewById(R.id.et_email);
        image2 = findViewById(R.id.image2);
        logIn = findViewById(R.id.btn_passcode);
    }

    public void inItListener(){
        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GetPasscodeInsurance.this,Insurance.class);
                startActivity(intent);
            }
        });

        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validateemailAddress()){
                    Intent intent = new Intent(GetPasscodeInsurance.this,Insurance.class);
                    saveData();
                    startActivity(intent);
                }
                else{
                    Toast.makeText(GetPasscodeInsurance.this, "Provide correct pin", Toast.LENGTH_SHORT).show();
                }
            }
        });
        loadData();
        updateData();

    }
    public void saveData(){
        SharedPreferences peterSharedPreference = getSharedPreferences(getString(R.string.my_preferences), Context.MODE_PRIVATE);
        SharedPreferences.Editor myEditor = peterSharedPreference.edit();
        myEditor.putString(AppConstantNew.emailAddress, emailAddressEditText.getText().toString());
        myEditor.apply();
    }
    public void loadData() {
        SharedPreferences peterSharedPreference = getSharedPreferences(getString(R.string.my_preferences), Context.MODE_PRIVATE);
        emailAddress = peterSharedPreference.getString(AppConstantNew.emailAddress, " ");

    }

    public void updateData(){

            emailAddressEditText.setText(emailAddress);

        }
    private boolean validateemailAddress() {
        String phoneNumberInput = emailAddressEditText.getText().toString().trim();
        String acceptableNumber = "^([a-zA-Z@$+._\\d]*)$";

        if(phoneNumberInput.isEmpty()){
            emailAddressEditText.setError("field cant be empty");
            return false;
        }
        if(phoneNumberInput.length()<11){
            emailAddressEditText.setError("invalid number");
            return false;
        }
        if(!phoneNumberInput.matches(acceptableNumber)){
            emailAddressEditText.setError("incorrect input typed");
            return false;
        }
        return true;
    }


}


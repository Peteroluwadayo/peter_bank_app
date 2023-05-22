package com.example.petersapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ForgetPasswordEase extends AppCompatActivity {
    private View arrowView;
    private EditText phonenumberEditText;
    private AppCompatButton signupButton;

    public String phoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forget_password_ease);

        inItView();
        inItlistner();
    }
    public void inItView(){
        arrowView = findViewById(R.id.arrow);
        phonenumberEditText = findViewById(R.id.et_phoneNumber);
        signupButton = findViewById(R.id.btn_signupbutton);
    }
    public void inItlistner() {
        arrowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ForgetPasswordEase.this,Ease.class);
                startActivity(intent);
            }
        });
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ValidatephoneNumber()){
                    Intent intent = new Intent(ForgetPasswordEase.this,Ease.class);
                    savaData();
                    Toast.makeText(ForgetPasswordEase.this, "Save data", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }else{
                    Toast.makeText(ForgetPasswordEase.this, "Provide correct pin", Toast.LENGTH_SHORT).show();

                }
            }
        });
        loadData();
        updateData();
    }
    public void savaData(){
        SharedPreferences peterSharedPreference = getSharedPreferences(getString(R.string.my_preferences), Context.MODE_PRIVATE);
        SharedPreferences.Editor myEditor = peterSharedPreference.edit();
        myEditor.putString(AppConstantNew.phoneNumber,phonenumberEditText.getText().toString());
        myEditor.apply();
    }
    public void loadData(){
        SharedPreferences peterSharedPreference = getSharedPreferences(getString(R.string.my_preferences), Context.MODE_PRIVATE);
        phoneNumber = peterSharedPreference.getString(AppConstantNew.phoneNumber, "");
    }
    public void updateData(){
        phonenumberEditText.setText(phoneNumber);
    }
    private boolean ValidatephoneNumber() {
        String phoneNumberInput = phonenumberEditText.getText().toString().trim();
        String acceptableNumber = "^([0-9]*)$";

        if (phoneNumberInput.isEmpty()) {
            phonenumberEditText.setError("field cant be empty");
            return false;
        }
        if (phoneNumberInput.length() < 11) {
            phonenumberEditText.setError("invalid number");
            return false;
        }
        if (!phoneNumberInput.matches(acceptableNumber)) {
            phonenumberEditText.setError("incorrect input typed");
            return false;
        }
        return true;
    }

}
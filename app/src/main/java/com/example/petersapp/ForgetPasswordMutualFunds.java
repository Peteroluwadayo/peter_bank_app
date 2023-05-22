package com.example.petersapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ForgetPasswordMutualFunds extends AppCompatActivity {
    private ImageView imageButton;
    private EditText emailAddressEdittext;
    private TextView phoneNumberEditText;
    private Button nextButton;

    public String emailAddress,phoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forget_password_mutual_funds);

        inItView();
        inItlistner();
    }
    public void inItView(){
        imageButton = findViewById(R.id.imagebutton);
        emailAddressEdittext = findViewById(R.id.et_email);
        phoneNumberEditText = findViewById(R.id.et_phoneNumber1);
        nextButton = findViewById(R.id.btn_signUpButton);

    }
    public void inItlistner(){
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ForgetPasswordMutualFunds.this,MutualFund.class);
                startActivity(intent);
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(ValidateemailAddress() & validatephoneNumber()){
                   Intent intent = new Intent(ForgetPasswordMutualFunds.this,MutualFund.class);
                   savaData();
                   Toast.makeText(ForgetPasswordMutualFunds.this, "save data", Toast.LENGTH_SHORT).show();
                   startActivity(intent);

               }else{
                   Toast.makeText(ForgetPasswordMutualFunds.this, "Provide correct pin", Toast.LENGTH_SHORT).show();
               }
            }
        });

        loadData();
        updateData();
    }

    public void savaData(){
        SharedPreferences peterSharedPreference = getSharedPreferences(getString(R.string.my_preferences), Context.MODE_PRIVATE);
        SharedPreferences.Editor myEditor = peterSharedPreference.edit();
        myEditor.putString(AppConstantNew.emailAddress,emailAddressEdittext.getText().toString());
        myEditor.putString(AppConstantNew.phoneNumber,phoneNumberEditText.getText().toString());
        myEditor.apply();
    }

    public void loadData(){
        SharedPreferences peterSharedPreference = getSharedPreferences(getString(R.string.my_preferences), Context.MODE_PRIVATE);
        emailAddress = peterSharedPreference.getString(AppConstantNew.emailAddress, "");
        phoneNumber = peterSharedPreference.getString(AppConstantNew.phoneNumber,"");
    }

    public void updateData(){

        emailAddressEdittext.setText(emailAddress);
        phoneNumberEditText.setText(phoneNumber);
    }

    private boolean validatephoneNumber() {
        String phoneNumberInput = phoneNumberEditText.getText().toString().trim();
        String acceptableNumber = "^([a-zA-Z@$+._\\d]*)$";

        if (phoneNumberInput.isEmpty()) {
            phoneNumberEditText.setError("field cant be empty");
            return false;
        }
        if (phoneNumberInput.length() < 11) {
            phoneNumberEditText.setError("invalid number");
            return false;
        }
        if (!phoneNumberInput.matches(acceptableNumber)) {
            phoneNumberEditText.setError("incorrect input typed");
            return false;
        }
        return true;
    }

    private boolean ValidateemailAddress() {
        String phoneNumberInput = emailAddressEdittext.getText().toString().trim();
        String acceptableNumber =  "^([a-zA-Z@$+._\\d]*)$";

        if (phoneNumberInput.isEmpty()) {
            emailAddressEdittext.setError("field cant be empty");
            return false;
        }
        if (phoneNumberInput.length() < 11) {
            emailAddressEdittext.setError("invalid number");
            return false;
        }
        if (!phoneNumberInput.matches(acceptableNumber)) {
            emailAddressEdittext.setError("incorrect input typed");
            return false;
        }
        return true;
    }
}
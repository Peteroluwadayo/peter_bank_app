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

public class ForgetPasswordLifeInsurancePage extends AppCompatActivity {

    private EditText emailAddressEditText;
    private AppCompatButton logIn;

    public String emailAddress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forget_password_life_insurance_page);

        inItView();
        inItlistner();

    }
    public void inItView(){
        emailAddressEditText = findViewById(R.id.et_email);
        logIn = findViewById(R.id.btn_reset_Password);
    }
    public void inItlistner(){
        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validateemailAddress()){
                    saveData();
                    Intent intent = new Intent(ForgetPasswordLifeInsurancePage.this,LifeInsurancePage.class);
                    Toast.makeText(ForgetPasswordLifeInsurancePage.this, "save data", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }
                else{
                    Toast.makeText(ForgetPasswordLifeInsurancePage.this, "Provide correct email address", Toast.LENGTH_SHORT).show();
                }
            }
        });
        loadData();
        updateData();
    }
    public void saveData(){

            SharedPreferences peterSharedPreference = getSharedPreferences(getString(R.string.my_preferences), Context.MODE_PRIVATE);
            SharedPreferences.Editor myEditor = peterSharedPreference.edit();
            myEditor.putString(AppConstantNew.emailAddress,emailAddressEditText.getText().toString());
            myEditor.apply();

        }
        public void loadData(){
            SharedPreferences peterSharedPreference = getSharedPreferences(getString(R.string.my_preferences), Context.MODE_PRIVATE);
            emailAddress = peterSharedPreference.getString(AppConstantNew.emailAddress, "");

        }
        public void updateData(){
            emailAddressEditText.setText(emailAddress);
        }

        private boolean validateemailAddress() {
        String phoneNumberInput = emailAddressEditText.getText().toString().trim();
        String acceptableNumber = "^([a-zA-Z@$+._\\d]*)$";

        if (phoneNumberInput.isEmpty()) {
            emailAddressEditText.setError("field cant be empty");
            return false;
        }
        if (phoneNumberInput.length() < 11) {
            emailAddressEditText.setError("invalid number");
            return false;
        }
        if (!phoneNumberInput.matches(acceptableNumber)) {
            emailAddressEditText.setError("incorrect input typed");
            return false;
        }
        return true;
    }

}
package com.example.petersapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ForgetPasswordMyBankApp extends AppCompatActivity {
    private View arrowView;
    private EditText internetBankingEdittext,accountNumberEdittext;
    private Button signupButton;

    public String internetBanking,accountNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forget_password_mybankapp);


        inItView();
        inItListener();

    }
    public void inItView(){
        arrowView = findViewById(R.id.arrow);
        internetBankingEdittext = findViewById(R.id.et_internetbanking);
        accountNumberEdittext = findViewById(R.id.et_accountnumber);
        signupButton = findViewById(R.id.btn_signupbutton);
    }
    public void inItListener(){
        arrowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ForgetPasswordMyBankApp.this,MyBankApp.class);
                startActivity(intent);
            }
        });
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ValidateInternetBanking() & validateAccountNumber()){
                    Intent intent = new Intent(ForgetPasswordMyBankApp.this,MyBankApp.class);
                    saveData();
                    Toast.makeText(ForgetPasswordMyBankApp.this, "Save data", Toast.LENGTH_SHORT).show();
                    startActivity(intent);

                }else{
                    Toast.makeText(ForgetPasswordMyBankApp.this, "Provide correct pin", Toast.LENGTH_SHORT).show();
                }
            }
        });
        loadData();
        updateData();

    }
    public void saveData(){
        SharedPreferences peterSharedPreference = getSharedPreferences(getString(R.string.my_preferences), Context.MODE_PRIVATE);
        SharedPreferences.Editor myEditor = peterSharedPreference.edit();
        myEditor.putString(AppConstantNew.internetBanking,internetBankingEdittext.getText().toString());
        myEditor.putString(AppConstantNew.accountNumber,accountNumberEdittext.getText().toString());
        myEditor.apply();

    }
    public void loadData(){

            SharedPreferences peterSharedPreference = getSharedPreferences(getString(R.string.my_preferences), Context.MODE_PRIVATE);
            internetBanking = peterSharedPreference.getString(AppConstantNew.internetBanking, "");
            accountNumber = peterSharedPreference.getString(AppConstantNew.accountNumber,"");
    }
    public void updateData(){
        internetBankingEdittext.setText(internetBanking);
        accountNumberEdittext.setText(accountNumber);
    }
    private boolean ValidateInternetBanking() {
        String phoneNumberInput = internetBankingEdittext.getText().toString().trim();
        String acceptableNumber = "^([0-9]*)$";

        if (phoneNumberInput.isEmpty()) {
            internetBankingEdittext.setError("field cant be empty");
            return false;
        }
        if (phoneNumberInput.length() < 11) {
            internetBankingEdittext.setError("invalid number");
            return false;
        }
        if (!phoneNumberInput.matches(acceptableNumber)) {
            internetBankingEdittext.setError("incorrect input typed");
            return false;
        }
        return true;
    }
    private boolean validateAccountNumber() {
        String phoneNumberInput = accountNumberEdittext.getText().toString().trim();
        String acceptableNumber = "^([0-9]*)$";

        if (phoneNumberInput.isEmpty()) {
            accountNumberEdittext.setError("field cant be empty");
            return false;
        }
        if (phoneNumberInput.length() < 11) {
            accountNumberEdittext.setError("invalid number");
            return false;
        }
        if (!phoneNumberInput.matches(acceptableNumber)) {
            accountNumberEdittext.setError("incorrect input typed");
            return false;
        }
        return true;
    }
}
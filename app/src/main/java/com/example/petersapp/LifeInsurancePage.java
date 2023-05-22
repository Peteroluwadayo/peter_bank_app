package com.example.petersapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LifeInsurancePage extends AppCompatActivity {
    private EditText phoneNumberEditText;
    private EditText passWordEditText;
    private AppCompatButton signUpButton;
    private TextView forgetPassWord;
    private TextView requestAQuota;


    public String phoneNumber,passWord;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.life_insurance_page);


        inItView();
        inItListener();

    }
    public void inItView(){
        phoneNumberEditText = findViewById(R.id.et_phoneNumber);
        passWordEditText = findViewById(R.id.btn_password);
        signUpButton = findViewById(R.id.btn_signupbutton);
        forgetPassWord = findViewById(R.id.btn_forgotpassword);
        requestAQuota = findViewById(R.id.btn_qoute);



    }
     public void inItListener(){
        forgetPassWord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LifeInsurancePage.this,ForgetPasswordLifeInsurancePage.class);
                startActivity(intent);
            }
        });
        requestAQuota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LifeInsurancePage.this,RequestAQuotaLifeInsurancePage.class);
                startActivity(intent);
            }
        });
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validatephoneNumber() & validatePassword()){
                    Intent intent = new Intent(LifeInsurancePage.this,Login.class);
                    saveData();
                    Toast.makeText(LifeInsurancePage.this, "save data", Toast.LENGTH_SHORT).show();

                    startActivity(intent);

                }
                else{
                    Toast.makeText(LifeInsurancePage.this, "Provide correct pin", Toast.LENGTH_SHORT).show();
                }
            }
        });
        loadData();
        updateData();

     }
     public void saveData(){
         SharedPreferences peterSharedPreference = getSharedPreferences(getString(R.string.my_preferences), Context.MODE_PRIVATE);
         SharedPreferences.Editor myEditor = peterSharedPreference.edit();
         myEditor.putString(AppConstantNew.phoneNumber,phoneNumberEditText.getText().toString());
         myEditor.putString(AppConstantNew.password,passWordEditText.getText().toString());
         myEditor.apply();

     }
     public void loadData(){
         SharedPreferences peterSharedPreference = getSharedPreferences(getString(R.string.my_preferences), Context.MODE_PRIVATE);
         phoneNumber = peterSharedPreference.getString(AppConstantNew.phoneNumber, "");
         passWord = peterSharedPreference.getString(AppConstantNew.password,"");
     }

    public void updateData() {
        phoneNumberEditText.setText(phoneNumber);
        passWordEditText.setText(passWord);

    }

    private boolean validatephoneNumber() {
        String phoneNumberInput = phoneNumberEditText.getText().toString().trim();
        String acceptableNumber = "^([0-9]*)$";

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

    private boolean validatePassword() {
        String phoneNumberInput = passWordEditText.getText().toString().trim();
        String acceptableNumber = "^([a-zA-Z@$+._\\d]*)$";

        if (phoneNumberInput.isEmpty()) {
            passWordEditText.setError("field cant be empty");
            return false;
        }
        if (phoneNumberInput.length() < 11) {
            passWordEditText.setError("invalid number");
            return false;
        }
        if (!phoneNumberInput.matches(acceptableNumber)) {
            passWordEditText.setError("incorrect input typed");
            return false;
        }
        return true;
    }
}

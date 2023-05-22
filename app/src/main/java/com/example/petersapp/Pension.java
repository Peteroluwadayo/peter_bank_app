package com.example.petersapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.SwitchCompat;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Pension extends AppCompatActivity {
    private EditText pinPhoneEditText;
    private EditText passwordEditText;
    private View arrowView;
    private SwitchCompat switch2;
    private AppCompatButton signUpButton;
    private TextView forgotPasswordTextView;


    public String pinPhone, password;
    public boolean switchOnOf;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pension);
        initView();
        inItListener();
    }

    public void initView() {
        pinPhoneEditText = findViewById(R.id.et_pin_phone);
        passwordEditText = findViewById(R.id.et_my_password);
        arrowView = findViewById(R.id.arrow);
        switch2 = findViewById(R.id.switch2);
        signUpButton = findViewById(R.id.btn_signUpButton);
        forgotPasswordTextView = findViewById(R.id.btn_forgotpassword);
    }

    public void inItListener(){
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ValidatePhoneNumber() & validatePassword()){
                    Intent intent = new Intent(Pension.this, Login.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(Pension.this, "Provide correct Input", Toast.LENGTH_SHORT).show();
                }
            }
        });
        arrowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Pension.this,Login.class);
                startActivity(intent);
            }
        });

        forgotPasswordTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Pension.this,ForgotPasswordPensionPage.class);
                startActivity(intent);
            }
        });

        switch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                saveData();
                Toast.makeText(Pension.this, "data saved", Toast.LENGTH_SHORT).show();
            }
        });
        loadData();
        updateData();

    }

    public void saveData() {
        SharedPreferences peterSharedPreference = getSharedPreferences(getString(R.string.my_preferences), Context.MODE_PRIVATE);
        SharedPreferences.Editor myEditor = peterSharedPreference.edit();
        myEditor.putString(AppConstantNew.pinPhone, pinPhoneEditText.getText().toString());
        myEditor.putBoolean(AppConstantNew.switcher, switch2.isChecked());
        myEditor.putString(AppConstantNew.password, passwordEditText.getText().toString());
        myEditor.apply();

    }

    public void loadData() {
        SharedPreferences peterSharedPreference = getSharedPreferences(getString(R.string.my_preferences), Context.MODE_PRIVATE);
        pinPhone = peterSharedPreference.getString(AppConstantNew.pinPhone, "");
        password = peterSharedPreference.getString(AppConstantNew.password, " ");
        switchOnOf = peterSharedPreference.getBoolean(AppConstantNew.switcher, false);
    }

    public void updateData() {
        pinPhoneEditText.setText(pinPhone);
        switch2.setChecked(switchOnOf);
        passwordEditText.setText(password);


    }

    private boolean ValidatePhoneNumber() {
        String phoneNumberInput = pinPhoneEditText.getText().toString().trim();
        String acceptableNumber = "^([0-9]*)$";

        if (phoneNumberInput.isEmpty()) {
            pinPhoneEditText.setError("field cant be empty");
            return false;
        }
        if (phoneNumberInput.length() < 11) {
            pinPhoneEditText.setError("invalid number");
            return false;
        }
        if (!phoneNumberInput.matches(acceptableNumber)) {
            pinPhoneEditText.setError("incorrect input typed");
            return false;
        }
        return true;
    }

    private boolean validatePassword() {
        String passwordInput = passwordEditText.getText().toString().trim();
        String acceptablePassword = "^([a-zA-Z&$+._\\d]*)$";
        if (passwordInput.isEmpty()) {
            passwordEditText.setError("field cant be empty");
            return false;
        }
        if (passwordInput.length() < 6) {
            passwordEditText.setError("invalid password");
            return false;
        }
        if (!passwordInput.matches(acceptablePassword)) {
            passwordEditText.setError("incorrect input typed");
            return false;
        }
        return true;
    }
}



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
import android.widget.QuickContactBadge;
import android.widget.TextView;
import android.widget.Toast;

public class Insurance extends AppCompatActivity {
    private  EditText emailAddressEditText;
    private EditText passCodeEditText;
    private View arrow;
    private Button logIn;
    private TextView getPasscodeTextView;
    private SwitchCompat switch3;

    public String emailAddress,passCode;
    public  boolean switchOnOf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.insurance);

        inItView();
        inItListener();

    }
    public void inItView(){
        emailAddressEditText = findViewById(R.id.et_email);
        passCodeEditText = findViewById(R.id.et_passcode);
        arrow = findViewById(R.id.arrow);
        logIn = findViewById(R.id.btn_signUpButton);
        getPasscodeTextView = findViewById(R.id.btn_forgotpassword);
        switch3 = findViewById(R.id.switch1);
    }

    public void inItListener(){
        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validateemailAddress() & validatepassCode()){
                    Intent intent = new Intent(Insurance.this,Login.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(Insurance.this, "Provide correct pin", Toast.LENGTH_SHORT).show();
                }

            }
        });
        arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Insurance.this,Login.class);
                startActivity(intent);
            }
        });
        getPasscodeTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Insurance.this,GetPasscodeInsurance.class);
                startActivity(intent);
            }
        });
        switch3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                saveData();
                Toast.makeText(Insurance.this, "Save data", Toast.LENGTH_SHORT).show();
            }
        });
        loadData();
        updateData();
    }
    public void saveData(){
        SharedPreferences peterSharedPreference = getSharedPreferences(getString(R.string.my_preferences), Context.MODE_PRIVATE);
        SharedPreferences.Editor myEditor = peterSharedPreference.edit();
        myEditor.putString(AppConstantNew.emailAddress, emailAddressEditText.getText().toString());
        myEditor.putString(AppConstantNew.passCode, passCodeEditText.getText().toString());
        myEditor.putBoolean(AppConstantNew.switcher, switch3.isChecked());
        myEditor.apply();
    }
    public void loadData(){
        SharedPreferences peterSharedPreference = getSharedPreferences(getString(R.string.my_preferences), Context.MODE_PRIVATE);
        emailAddress = peterSharedPreference.getString(AppConstantNew.emailAddress, " ");
        passCode = peterSharedPreference.getString(AppConstantNew.passCode, " ");
        switchOnOf = peterSharedPreference.getBoolean(AppConstantNew.switcher, false);

    }
    public void updateData(){
        emailAddressEditText.setText(emailAddress);
        passCodeEditText.setText(passCode);
        switch3.setChecked(switchOnOf);
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

    private boolean validatepassCode() {
        String phoneNumberInput = passCodeEditText.getText().toString().trim();
        String acceptableNumber = "^([a-zA-Z@$+._\\d]*)$";

        if(phoneNumberInput.isEmpty()){
            passCodeEditText.setError("field cant be empty");
            return false;
        }
        if(phoneNumberInput.length()<11){
            passCodeEditText.setError("invalid number");
            return false;
        }
        if(!phoneNumberInput.matches(acceptableNumber)){
            passCodeEditText.setError("incorrect input typed");
            return false;
        }
        return true;
    }

}
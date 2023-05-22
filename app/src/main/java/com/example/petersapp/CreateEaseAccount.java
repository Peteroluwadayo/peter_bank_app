package com.example.petersapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class CreateEaseAccount extends AppCompatActivity {
    private EditText firstNameEditText, lastNameEditText, phoneNumberEditText, fullAddressEditText;
    private AppCompatButton logIn;
    private ImageView arrow;


   public String firstName,lastName,phoneNumber,fullAddress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_ease_account);


        initView();
        initListner();
    }
    public void initView(){
        firstNameEditText = findViewById(R.id.et_first_name);
        lastNameEditText = findViewById(R.id.et_lastname);
        phoneNumberEditText = findViewById(R.id.et_phonenumber);
        fullAddressEditText = findViewById(R.id.et_full_address);
        logIn = findViewById(R.id.btn_login);
        arrow = findViewById(R.id.imageview);
    }
    public void  initListner(){
        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ValidatephoneNumber() & validatefirstName() & validatelastName() & valiatefullAddress()){
                    Intent intent = new Intent(CreateEaseAccount.this,Ease.class);
                    saveData();
                    Toast.makeText(CreateEaseAccount.this, "Save data", Toast.LENGTH_SHORT).show();

                    startActivity(intent);
                }else{
                    Toast.makeText(CreateEaseAccount.this, "Provide correct pin", Toast.LENGTH_SHORT).show();
                }
            }
        });
        arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CreateEaseAccount.this,Ease.class);
                startActivity(intent);
            }
        });
        loadData();
        updateData();
    }
    public void saveData(){
        SharedPreferences peterSharedPreference = getSharedPreferences(getString(R.string.my_preferences), Context.MODE_PRIVATE);
        SharedPreferences.Editor myEditor = peterSharedPreference.edit();
        myEditor.putString(AppConstantNew.firstName,firstNameEditText.getText().toString());
        myEditor.putString(AppConstantNew.lastName,lastNameEditText.getText().toString());
        myEditor.putString(AppConstantNew.phoneNumber,phoneNumberEditText.getText().toString());
        myEditor.putString(AppConstantNew.fullAddress,fullAddressEditText.getText().toString());
        myEditor.apply();

    }
    public void loadData(){
        SharedPreferences peterSharedPreference = getSharedPreferences(getString(R.string.my_preferences), Context.MODE_PRIVATE);
        firstName = peterSharedPreference.getString(AppConstantNew.firstName,"");
        lastName = peterSharedPreference.getString(AppConstantNew.lastName,"");
        phoneNumber = peterSharedPreference.getString(AppConstantNew.phoneNumber,"");
        fullAddress = peterSharedPreference.getString(AppConstantNew.fullAddress,"");
    }
    public void updateData(){
        firstNameEditText.setText(firstName);
        lastNameEditText.setText(lastName);
        phoneNumberEditText.setText(phoneNumber);
        fullAddressEditText.setText(fullAddress);
    }
    private boolean ValidatephoneNumber() {
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
    private boolean validatefirstName() {
        String phoneNumberInput = firstNameEditText.getText().toString().trim();
        String acceptableNumber =  "^([a-zA-Z@$+._\\d]*)$";

        if (phoneNumberInput.isEmpty()) {
            firstNameEditText.setError("field cant be empty");
            return false;
        }
        if (phoneNumberInput.length() < 11) {
            firstNameEditText.setError("invalid number");
            return false;
        }
        if (!phoneNumberInput.matches(acceptableNumber)) {
            firstNameEditText.setError("incorrect input typed");
            return false;
        }
        return true;
    }
    private boolean validatelastName() {
        String phoneNumberInput = lastNameEditText.getText().toString().trim();
        String acceptableNumber =  "^([a-zA-Z@$+._\\d]*)$";

        if (phoneNumberInput.isEmpty()) {
            lastNameEditText.setError("field cant be empty");
            return false;
        }
        if (phoneNumberInput.length() < 11) {
            lastNameEditText.setError("invalid number");
            return false;
        }
        if (!phoneNumberInput.matches(acceptableNumber)) {
            lastNameEditText.setError("incorrect input typed");
            return false;
        }
        return true;
    }
    private boolean valiatefullAddress() {
        String phoneNumberInput = fullAddressEditText.getText().toString().trim();
        String acceptableNumber =  "^([a-zA-Z@$+._\\d]*)$";

        if (phoneNumberInput.isEmpty()) {
            fullAddressEditText.setError("field cant be empty");
            return false;
        }
        if (phoneNumberInput.length() < 11) {
            fullAddressEditText.setError("invalid number");
            return false;
        }
        if (!phoneNumberInput.matches(acceptableNumber)) {
            fullAddressEditText.setError("incorrect input typed");
            return false;
        }
        return true;
    }


}

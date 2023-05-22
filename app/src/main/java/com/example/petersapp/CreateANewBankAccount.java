package com.example.petersapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CreateANewBankAccount extends AppCompatActivity {
    private  View arrowView;
    private EditText bvnNumberEditTextView,phoneNumberEditText,firstNameEditText,lastNameEditText,dateOfBirthEditText;
    private Button signUpButton;



    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_a_new_bank_account);

        inItView();
        inItlistner();

    }
    public void inItView(){
        arrowView = findViewById(R.id.arrow);
        bvnNumberEditTextView = findViewById(R.id.et_bvnnumber);
        phoneNumberEditText = findViewById(R.id.et_yourbvn);
        firstNameEditText = findViewById(R.id.et_firstname);
        lastNameEditText = findViewById(R.id.et_lastname);
        dateOfBirthEditText = findViewById(R.id.et_dateofbirth);
        signUpButton = findViewById(R.id.btn_next);
    }
    public void inItlistner() {
        arrowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CreateANewBankAccount.this,MyBankApp.class);
                startActivity(intent);
            }

        });
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ValidatebvnNumber() & validatephoneNumber() & validatefirstName() & validatelastName() & validatedateOfBirth()){
                    Intent intent = new Intent(new Intent(CreateANewBankAccount.this,MyBankApp.class));

                    Toast.makeText(CreateANewBankAccount.this, "Save data", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }else{
                    Toast.makeText(CreateANewBankAccount.this, "Provide correct pin", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    private boolean ValidatebvnNumber() {
        String phoneNumberInput = bvnNumberEditTextView.getText().toString().trim();
        String acceptableNumber = "^([0-9]*)$";

        if (phoneNumberInput.isEmpty()) {
            bvnNumberEditTextView.setError("field cant be empty");
            return false;
        }
        if (phoneNumberInput.length() < 11) {
            bvnNumberEditTextView.setError("invalid number");
            return false;
        }
        if (!phoneNumberInput.matches(acceptableNumber)) {
            bvnNumberEditTextView.setError("incorrect input typed");
            return false;
        }
        return true;
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
    private boolean validatefirstName() {
        String phoneNumberInput = firstNameEditText.getText().toString().trim();
        String acceptableNumber = "^([0-9]*)$";

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
        String acceptableNumber = "^([0-9]*)$";

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
    private boolean validatedateOfBirth() {
        String phoneNumberInput = dateOfBirthEditText.getText().toString().trim();
        String acceptableNumber = "^([0-9]*)$";

        if (phoneNumberInput.isEmpty()) {
            dateOfBirthEditText.setError("field cant be empty");
            return false;
        }
        if (phoneNumberInput.length() < 11) {
            dateOfBirthEditText.setError("invalid number");
            return false;
        }
        if (!phoneNumberInput.matches(acceptableNumber)) {
            dateOfBirthEditText.setError("incorrect input typed");
            return false;
        }
        return true;
    }

}
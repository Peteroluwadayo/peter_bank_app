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

public class ForgotPasswordPensionPage extends AppCompatActivity {
    private View forgotPasswordPensionArrow;
    private EditText emailPhoneNumberEditText;
    private AppCompatButton nextButton;

    public String emailphonenumber, next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgot_pawword_pension_page);

        initView();
        initListner();
    }

    public void initView() {
        forgotPasswordPensionArrow = findViewById(R.id.forgotpasswordpension_arrow);
        emailPhoneNumberEditText = findViewById(R.id.et_email_phonenumber);
        nextButton = findViewById(R.id.btn_nextbutton);
    }

    public void initListner() {
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Validateemailphonenumber()) {
                    Intent intent = new Intent(ForgotPasswordPensionPage.this, Pension.class);
                    saveData();
                    Toast.makeText(ForgotPasswordPensionPage.this, "Sava data", Toast.LENGTH_SHORT).show();

                    startActivity(intent);
                } else {
                    Toast.makeText(ForgotPasswordPensionPage.this, "Provide Correct Input", Toast.LENGTH_SHORT).show();
                }
            }
        });

        loadData();
        updateData();
    }
    public void saveData(){
        SharedPreferences peterSharedPreference = getSharedPreferences(getString(R.string.my_preferences), Context.MODE_PRIVATE);
        SharedPreferences.Editor myEditor = peterSharedPreference.edit();
        myEditor.putString(AppConstantNew.emailAddress,emailPhoneNumberEditText.getText().toString());
        myEditor.apply();

    }

    public void loadData() {
        SharedPreferences peterSharedPreference = getSharedPreferences(getString(R.string.my_preferences), Context.MODE_PRIVATE);
        emailphonenumber = peterSharedPreference.getString(AppConstantNew.emailAddress, "");

    }

    public void updateData() {
        emailPhoneNumberEditText.setText(emailphonenumber);

    }

    private boolean Validateemailphonenumber() {
        String phoneNumberInput = emailPhoneNumberEditText.getText().toString().trim();
        String acceptableNumber =  "^([a-zA-Z@$+._\\d]*)$";

        if (phoneNumberInput.isEmpty()) {
            emailPhoneNumberEditText.setError("field cant be empty");
            return false;
        }
        if (phoneNumberInput.length() < 11) {
            emailPhoneNumberEditText.setError("invalid number");
            return false;
        }
        if (!phoneNumberInput.matches(acceptableNumber)) {
            emailPhoneNumberEditText.setError("incorrect input typed");
            return false;
        }
        return true;
    }
}
package com.example.petersapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.app.PictureInPictureParams;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MutualFund extends AppCompatActivity {
    private View viewButton;
    private EditText emailAddressEditText, passWordEditText, phoneNumberEditText;
    private TextView forgetPassword, createAnInstantAccountTextView;
    private Button mutualButton;
    private SwitchCompat switch3;

    public String emailAddress, phoneNumber, passWord;
    private boolean switchOnOf;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mutual_fund);

        inItView();
        inItlistner();

    }

    public void inItView() {
        viewButton = findViewById(R.id.viewbutton);
        emailAddressEditText = findViewById(R.id.et_emailaddress);
        passWordEditText = findViewById(R.id.et_password1);
        phoneNumberEditText = findViewById(R.id.et_lastdigit);
        forgetPassword = findViewById(R.id.btn_forgotmutualbutton);
        mutualButton = findViewById(R.id.btn_mutualbutton);
        switch3 = findViewById(R.id.switch1);
        createAnInstantAccountTextView = findViewById(R.id.btn_instantaccount);

    }

    public void inItlistner() {
        mutualButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateemailAddress() & validatephoneNumber() & validatepassWord()) {
                    Intent intent = new Intent(MutualFund.this, Login.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(MutualFund.this, "Provide correct pin", Toast.LENGTH_SHORT).show();
                }
            }
        });
        viewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MutualFund.this, Login.class);
                startActivity(intent);
            }
        });
        forgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MutualFund.this, ForgetPasswordMutualFunds.class);
                startActivity(intent);
            }
        });
        createAnInstantAccountTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MutualFund.this, CreateAnInstantAccount.class);
                startActivity(intent);
            }
        });
        switch3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                saveData();
                Toast.makeText(MutualFund.this, "Save data", Toast.LENGTH_SHORT).show();
            }
        });
        loadData();
        updateData();

    }

    public void saveData() {
        SharedPreferences peterSharedPreference = getSharedPreferences(getString(R.string.my_preferences), Context.MODE_PRIVATE);
        SharedPreferences.Editor myEditor = peterSharedPreference.edit();
        myEditor.putString(AppConstantNew.emailAddress, emailAddressEditText.getText().toString());
        myEditor.putString(AppConstantNew.phoneNumber, phoneNumberEditText.getText().toString());
        myEditor.putString(AppConstantNew.password, passWordEditText.getText().toString());
        myEditor.putBoolean(AppConstantNew.switcher, switch3.isChecked());
        myEditor.apply();
    }

    public void loadData() {
        SharedPreferences peterSharedPreference = getSharedPreferences(getString(R.string.my_preferences), Context.MODE_PRIVATE);
        emailAddress = peterSharedPreference.getString(AppConstantNew.emailAddress, " ");
        phoneNumber = peterSharedPreference.getString(AppConstantNew.phoneNumber, "");
        passWord = peterSharedPreference.getString(AppConstantNew.password, "");
        switchOnOf = peterSharedPreference.getBoolean(AppConstantNew.switcher, false);
    }

    public void updateData() {
        emailAddressEditText.setText(emailAddress);
        phoneNumberEditText.setText(phoneNumber);
        passWordEditText.setText(passWord);
        switch3.setChecked(switchOnOf);
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

    private boolean validatephoneNumber() {
        String phoneNumberInput = phoneNumberEditText.getText().toString().trim();
        String acceptableNumber = "^([0-9]*)$";


        if (phoneNumberInput.isEmpty()) {
            phoneNumberEditText.setError("field cant be empty");
            return false;
        }
        if (phoneNumberInput.length() < 11) {
            passWordEditText.setError("invalid number");
            return false;
        }
        if (!phoneNumberInput.matches(acceptableNumber)) {
            phoneNumberEditText.setError("incorrect input typed");
            return false;
        }
        return true;

    }

    private boolean validatepassWord() {
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
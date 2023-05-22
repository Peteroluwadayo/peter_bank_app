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
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Ease extends AppCompatActivity {
    private View easeArrow;
    private EditText phoneEditText;
    private EditText transactionPinEditText;
    private SwitchCompat switch2;
    private AppCompatButton signUpButton;
    private TextView forgetPasswordTextView;
    private TextView instantAccountTextView;

    public String phoneNumber, transactionPin;
    public boolean switchOnOf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ease);

        inItView();
        inItListener();

    }

    public void inItView() {
        // we get the ids of the views in the xml and asign to the new variable
        easeArrow = findViewById(R.id.arrow);
        phoneEditText = findViewById(R.id.et_phone);
        transactionPinEditText = findViewById(R.id.et_transaction);
        switch2 = findViewById(R.id.switch1);
        signUpButton = findViewById(R.id.btn_signUpButton);
        forgetPasswordTextView = findViewById(R.id.btn_forgotpassword);
        instantAccountTextView = findViewById(R.id.btn_instantaccount);

    }

    public void inItListener() {
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ValidatephoneNumber() & validatetransactionPin()) {
                    Intent intent = new Intent(Ease.this, Login.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(Ease.this, "Provide correct pin", Toast.LENGTH_SHORT).show();
                }
            }
        });


        easeArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Ease.this, Login.class);
                startActivity(intent);
            }
        });
        forgetPasswordTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Ease.this, ForgetPasswordEase.class);
                startActivity(intent);
            }
        });

        instantAccountTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Ease.this,CreateEaseAccount.class);
                startActivity(intent);
            }
        });






        switch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                savaData();
                Toast.makeText(Ease.this, "Save data", Toast.LENGTH_SHORT).show();
            }
        });
        loadData();
        updateData();


    }

    public void savaData() {
        SharedPreferences peterSharedPreference = getSharedPreferences(getString(R.string.my_preferences), Context.MODE_PRIVATE);
        SharedPreferences.Editor myEditor = peterSharedPreference.edit();
        myEditor.putString(AppConstantNew.phoneNumber, phoneEditText.getText().toString());
        myEditor.putString(AppConstantNew.transactionPin, transactionPinEditText.getText().toString());
        myEditor.putBoolean(AppConstantNew.switcher, switch2.isChecked());
        myEditor.apply();
    }

    public void loadData() {
        SharedPreferences peterSharedPreference = getSharedPreferences(getString(R.string.my_preferences), Context.MODE_PRIVATE);
        phoneNumber = peterSharedPreference.getString(AppConstantNew.phoneNumber, "");
        transactionPin = peterSharedPreference.getString(AppConstantNew.transactionPin, "");
        switchOnOf = peterSharedPreference.getBoolean(AppConstantNew.switcher, false);
    }

    public void updateData() {
        phoneEditText.setText(phoneNumber);
        transactionPinEditText.setText(transactionPin);
        switch2.setChecked(switchOnOf);
    }

    private boolean ValidatephoneNumber() {
        String phoneNumberInput = phoneEditText.getText().toString().trim();
        String acceptableNumber = "^([0-9]*)$";

        if (phoneNumberInput.isEmpty()) {
            phoneEditText.setError("field cant be empty");
            return false;
        }
        if (phoneNumberInput.length() < 11) {
            phoneEditText.setError("invalid number");
            return false;
        }
        if (!phoneNumberInput.matches(acceptableNumber)) {
            phoneEditText.setError("incorrect input typed");
            return false;
        }
        return true;

    }

    private boolean validatetransactionPin() {
        String passwordInput = transactionPinEditText.getText().toString().trim();
        String acceptablePassword = "^([a-zA-Z&$+._\\d]*)$";
        if (passwordInput.isEmpty()) {
            transactionPinEditText.setError("field cant be empty");
            return false;
        }
        if (passwordInput.length() < 6) {
            transactionPinEditText.setError("invalid password");
            return false;
        }
        if (!passwordInput.matches(acceptablePassword)) {
            transactionPinEditText.setError("incorrect input typed");
            return false;
        }
        return true;
    }
}


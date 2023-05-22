package com.example.petersapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MyBankApp extends AppCompatActivity {


    private EditText passwordEditText, phoneNumberEditText;
    private SwitchCompat switch1;
    private Button logIn;
    private TextView forgetPassword, createNewTextView;
    private View arrow, phone;


    public String phoneNumber, password;
    public boolean switchOnOf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_bank_app);

        initView();
        initListener();
    }

    public void initView() {
        // we get the ids of the views in the xml and asign to the new variable

        phoneNumberEditText = findViewById(R.id.et_phoneNumber);
        passwordEditText = findViewById(R.id.et_password);
        switch1 = findViewById(R.id.switch1);
        logIn = findViewById(R.id.btn_button);
        forgetPassword = findViewById(R.id.btn_forgotpassword);
        createNewTextView = findViewById(R.id.btn_create_a_new);
        phone = findViewById(R.id.phone);
        arrow = findViewById(R.id.arrow);

    }

    public void initListener() {

        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(MyBankApp.this);
                builder.setTitle("Go to dashboard");
                builder.setMessage("Do you want to go to dashboard");
                builder.setCancelable(false);
                builder.setPositiveButton("Yes", (DialogInterface.OnClickListener) (dialog, which) -> {
                    if(ValidatePhoneNumber() & validatePassword()){
                        Toast.makeText(MyBankApp.this, "provide correct pin", Toast.LENGTH_SHORT).show();
                    }
                        finish();


                    Intent myIntent = new Intent(MyBankApp. this, DashBoardMyBankApp. class);
                    startActivity(myIntent);

                });
                builder.setNegativeButton("No", (DialogInterface.OnClickListener) (dialog, which) -> {
                    dialog.cancel();
                });

                AlertDialog alertDialog = builder.create();
                alertDialog.show();




            }


        });
        arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyBankApp.this, Login.class);
                startActivity(intent);
            }
        });
        forgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyBankApp.this, ForgetPasswordMyBankApp.class);
                startActivity(intent);

            }
        });
        createNewTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyBankApp.this, CreateANewBankAccount.class);
                startActivity(intent);
            }
        });
        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyBankApp.this, CallCustomerCare.class);
                startActivity(intent);
            }
        });


        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                saveData();
                Toast.makeText(MyBankApp.this, "data saved", Toast.LENGTH_SHORT).show();
            }
        });
        loadData();
        updateData();


    }

    public void saveData() {
        SharedPreferences peterSharedPreference = getSharedPreferences(getString(R.string.my_preferences), Context.MODE_PRIVATE);
        SharedPreferences.Editor myEditor = peterSharedPreference.edit();
        myEditor.putString(AppConstantNew.phoneNumber, phoneNumberEditText.getText().toString());
        myEditor.putString(AppConstantNew.password, passwordEditText.getText().toString());
        myEditor.putBoolean(AppConstantNew.switcher, switch1.isChecked());
        myEditor.apply();
    }

    public void loadData() {
        SharedPreferences peterSharedPreference = getSharedPreferences(getString(R.string.my_preferences), Context.MODE_PRIVATE);
        phoneNumber = peterSharedPreference.getString(AppConstantNew.phoneNumber, " ");
        password = peterSharedPreference.getString(AppConstantNew.password, " ");
        switchOnOf = peterSharedPreference.getBoolean(AppConstantNew.switcher, false);


    }

    public void updateData() {
        phoneNumberEditText.setText(phoneNumber);
        passwordEditText.setText(password);
        switch1.setChecked(switchOnOf);
    }


    private boolean ValidatePhoneNumber() {
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








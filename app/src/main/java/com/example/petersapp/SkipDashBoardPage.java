package com.example.petersapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SkipDashBoardPage extends AppCompatActivity {

    private TextView showAccountTextView,loanTextView,dollarTextView,showBalanceDollarTextView,nairaTextView,showBalanceNairaTextView;
    private TextView homeTextView,transferTextView,paymentTextView,profileTextView,moreTextView;
    private LinearLayout linearArrow;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.skip_dash_board_page);

        inItView();
        inItlistener();
    }
    public void inItView(){
        showAccountTextView = findViewById(R.id.btn_show_id);
        loanTextView = findViewById(R.id.btn_view_availableloan);
        dollarTextView = findViewById(R.id.btn_xxxdollar);
        showBalanceDollarTextView = findViewById(R.id.btn_show_balance);
        nairaTextView = findViewById(R.id.btn_xxx_naira);
        showBalanceNairaTextView = findViewById(R.id.btn_show_naira_balance);
        linearArrow = findViewById(R.id.linear_arrow);
        homeTextView = findViewById(R.id.btn_home);
        transferTextView = findViewById(R.id.btn_transfer);
        paymentTextView = findViewById(R.id.btn_payment);
        profileTextView = findViewById(R.id.btn_profile);
        moreTextView = findViewById(R.id.btn_more);

    }

    public void inItlistener(){
        transferTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SkipDashBoardPage.this,TransferPage.class);
                startActivity(intent);
            }
        });
        paymentTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SkipDashBoardPage.this,PaymentPage.class);
                startActivity(intent);
            }
        });
        profileTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SkipDashBoardPage.this,ProfilePage.class);
                startActivity(intent);
            }
        });
        moreTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SkipDashBoardPage.this,MorePage.class);
                startActivity(intent);
            }
        });
        linearArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SkipDashBoardPage.this,LinearPage.class);
                startActivity(intent);
            }
        });

    }
}
package com.activity.alertobulakenyo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Verification extends AppCompatActivity {

    EditText etCode1, etCode2, etCode3, etCode4;
    Button btnVerify, btnBack;
    TextView tvNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION); //enable full screen

        setContentView(R.layout.activity_verification);

        etCode1 = (EditText) findViewById (R.id.etCode1);
        etCode2 = (EditText) findViewById (R.id.etCode1);
        etCode3 = (EditText) findViewById (R.id.etCode1);
        etCode4 = (EditText) findViewById (R.id.etCode1);

        btnVerify = (Button) findViewById (R.id.btnVerify);
        btnBack = (Button) findViewById (R.id.btnBack);
        tvNote = (TextView) findViewById (R.id.tvNote);

        etCode1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (etCode1.getText().toString().length() == 1)
                {
                    etCode2.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        etCode2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (etCode2.getText().toString().length() == 1)
                {
                    etCode3.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        etCode3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (etCode3.getText().toString().length() == 1)
                {
                    etCode4.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        btnVerify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(etCode1.getText().toString()))
                {
                    tvNote.setText("There is an error in the verification code.");
                    return;
                }
                if (TextUtils.isEmpty(etCode2.getText().toString()))
                {
                    tvNote.setText("There is an error in the verification code.");
                    return;
                }
                if (TextUtils.isEmpty(etCode3.getText().toString()))
                {
                    tvNote.setText("There is an error in the verification code.");
                    return;
                }
                if (TextUtils.isEmpty(etCode3.getText().toString()))
                {
                    tvNote.setText("There is an error in the verification code.");
                    return;
                }

                Intent intent = new Intent(Verification.this, ResetPass.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right,
                        R.anim.slide_out_left);
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Verification.this, login.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left,
                        R.anim.slide_out_right);
            }
        });

    }

    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left,
                R.anim.slide_out_right);
    }
}
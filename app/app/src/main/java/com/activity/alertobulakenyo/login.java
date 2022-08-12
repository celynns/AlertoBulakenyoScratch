package com.activity.alertobulakenyo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class login extends AppCompatActivity {

    EditText etLoginEmail, etLoginPass;
    Button btnLogin;
    TextView tvForgotPass, tvSignup;
    ImageButton btnGoogle, btnFB, btnTwt;
    boolean passwordVisible;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION); //enable full screen

        setContentView(R.layout.activity_login);

        etLoginEmail = (EditText) findViewById (R.id.etLoginEmail);
        etLoginPass = (EditText) findViewById (R.id.etLoginPass);

        btnLogin = (Button) findViewById (R.id.btnLogin);

        tvForgotPass = (TextView) findViewById (R.id.tvForgotPass);
        tvSignup = (TextView) findViewById (R.id.tvSignup);

        btnGoogle = (ImageButton) findViewById (R.id.btnGoogle);
        btnFB = (ImageButton) findViewById (R.id.btnFB);
        btnTwt = (ImageButton) findViewById (R.id.btnTwt);

        //password visibility
        etLoginPass.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final int Right=2;
                if(event.getAction()==MotionEvent.ACTION_UP){
                    if(event.getRawX()>=etLoginPass.getRight()-etLoginPass.getCompoundDrawables()[Right].getBounds().width()){
                        int selection=etLoginPass.getSelectionEnd();
                        if(passwordVisible){
                            //set drawable image here
                            etLoginPass.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.ic_baseline_visibility_off_24,0);
                            //for hide password
                            etLoginPass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            passwordVisible=false;
                        } else {
                            //set drawable image here
                            etLoginPass.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.ic_baseline_visibility_24,0);
                            //for show password
                            etLoginPass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            passwordVisible=true;
                        }
                        etLoginPass.setSelection(selection);
                        return true;
                    }
                }

                return false;
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (TextUtils.isEmpty(etLoginEmail.getText().toString()))
                {
                    etLoginEmail.setError("This cannot be empty!");
                    return;
                }
                if (TextUtils.isEmpty(etLoginPass.getText().toString()))
                {
                    etLoginPass.setError("This cannot be empty!");
                    return;
                }

                Intent intent = new Intent(login.this, completeInfo.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right,
                        R.anim.slide_out_left);
            }
        });

        tvForgotPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login.this, ForgotPass.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right,
                        R.anim.slide_out_left);
            }
        });

        btnGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnFB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnTwt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        tvSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(login.this, register.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right,
                        R.anim.slide_out_left);
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
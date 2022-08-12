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
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class register extends AppCompatActivity {

    EditText etRegFname, etRegLname, etRegUsername, etRegEmail, etRegPass, etRegConPass;
    CheckBox cbAgree1, cbAgree2;
    Button btnSignup;
    TextView tvTerms, tvPrivacy, tvLogin;
    boolean passwordVisible;
    int cb1 = 0, cb2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION); //enable full screen

        setContentView(R.layout.activity_register);

        etRegFname = (EditText) findViewById (R.id.etRegFname);
        etRegLname = (EditText) findViewById (R.id.etRegLname);
        etRegUsername = (EditText) findViewById (R.id.etRegUsername);
        etRegEmail = (EditText) findViewById (R.id.etRegEmail);
        etRegPass = (EditText) findViewById (R.id.etRegPass);
        etRegConPass = (EditText) findViewById (R.id.etRegConPass);

        cbAgree1 = (CheckBox) findViewById (R.id.cbAgree1);
        cbAgree2 = (CheckBox) findViewById (R.id.cbAgree2);
        btnSignup = (Button) findViewById (R.id.btnSignup);

        tvTerms = (TextView) findViewById (R.id.tvTerms);
        tvPrivacy = (TextView) findViewById (R.id.tvPrivacy);
        tvLogin = (TextView) findViewById (R.id.tvLogin);

        //password visibility
        etRegPass.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final int Right=2;
                if(event.getAction()==MotionEvent.ACTION_UP){
                    if(event.getRawX()>=etRegPass.getRight()-etRegPass.getCompoundDrawables()[Right].getBounds().width()){
                        int selection=etRegPass.getSelectionEnd();
                        if(passwordVisible){
                            //set drawable image here
                            etRegPass.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.ic_baseline_visibility_off_24,0);
                            //for hide password
                            etRegPass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            passwordVisible=false;
                        } else {
                            //set drawable image here
                            etRegPass.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.ic_baseline_visibility_24,0);
                            //for show password
                            etRegPass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            passwordVisible=true;
                        }
                        etRegPass.setSelection(selection);
                        return true;
                    }
                }

                return false;
            }
        });

        //confirm password visibility
        etRegConPass.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final int Right=2;
                if(event.getAction()==MotionEvent.ACTION_UP){
                    if(event.getRawX()>=etRegConPass.getRight()-etRegConPass.getCompoundDrawables()[Right].getBounds().width()){
                        int selection=etRegConPass.getSelectionEnd();
                        if(passwordVisible){
                            //set drawable image here
                            etRegConPass.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.ic_baseline_visibility_off_24,0);
                            //for hide password
                            etRegConPass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            passwordVisible=false;
                        } else {
                            //set drawable image here
                            etRegConPass.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.ic_baseline_visibility_24,0);
                            //for show password
                            etRegConPass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            passwordVisible=true;
                        }
                        etRegConPass.setSelection(selection);
                        return true;
                    }
                }

                return false;
            }
        });


        tvTerms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        tvPrivacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        cbAgree1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cbAgree1.isChecked()) {
                    cb1 = 1;
                }
                else {
                    cb1 = 0;
                }
            }
        });

        cbAgree2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cbAgree2.isChecked()) {
                    cb2 = 1;
                }
                else {
                    cb2 = 0;
                }
            }
        });

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (TextUtils.isEmpty(etRegFname.getText().toString()))
                {
                    etRegFname.setError("This cannot be empty!");
                    return;
                }
                if (TextUtils.isEmpty(etRegLname.getText().toString()))
                {
                    etRegLname.setError("This cannot be empty!");
                    return;
                }
                if (TextUtils.isEmpty(etRegUsername.getText().toString()))
                {
                    etRegUsername.setError("This cannot be empty!");
                    return;
                }
                if (TextUtils.isEmpty(etRegEmail.getText().toString()))
                {
                    etRegEmail.setError("This cannot be empty!");
                    return;
                }
                if (TextUtils.isEmpty(etRegPass.getText().toString()))
                {
                    etRegPass.setError("This cannot be empty!");
                    return;
                }
                if (TextUtils.isEmpty(etRegConPass.getText().toString()))
                {
                    etRegConPass.setError("This cannot be empty!");
                    return;
                }

                if ((cb1 == 1) && (cb2 == 1) )
                {
                    Intent intent = new Intent(register.this, login.class);
                    startActivity(intent);

                    Toast.makeText(register.this, "You have successfully registered to Alerto Bulakenyo. You can now Log in.", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(register.this, "Please read and agree to the Terms of Service and Privacy Policy.", Toast.LENGTH_LONG).show();
                }

            }
        });

        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(register.this, login.class);
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
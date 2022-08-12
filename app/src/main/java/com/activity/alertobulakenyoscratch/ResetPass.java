package com.activity.alertobulakenyoscratch;

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

import androidx.appcompat.app.AppCompatActivity;

public class ResetPass extends AppCompatActivity {

    EditText etResetNewPass, etResetConPass;
    Button btnResetPass, btnBackVer;
    boolean passwordVisible;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION); //enable full screen

        setContentView(R.layout.activity_reset_pass);

        etResetNewPass = (EditText) findViewById (R.id.etResetNewPass);
        etResetConPass = (EditText) findViewById (R.id.etResetConPass);

        btnResetPass = (Button) findViewById (R.id.btnResetPass);
        btnBackVer = (Button) findViewById (R.id.btnBackVer);

        etResetNewPass.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final int Right = 2;
                if (event.getAction() == MotionEvent.ACTION_UP){
                    if (event.getRawX() >= etResetNewPass.getRight() - etResetNewPass.getCompoundDrawables()[Right].getBounds().width()){
                        int selection = etResetNewPass.getSelectionEnd();
                        if (passwordVisible){
                            //set drawable image here
                            etResetNewPass.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.reset_baseline_visibility_off_24,0);
                            //for hide password
                            etResetNewPass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            passwordVisible = false;
                        } else {
                            //set drawable image here
                            etResetNewPass.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.reset_baseline_visibility_24,0);
                            //for show password
                            etResetNewPass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            passwordVisible = true;
                        }
                        etResetNewPass.setSelection(selection);
                        return true;
                    }
                }

                return false;
            }
        });

        etResetConPass.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final int Right = 2;
                if (event.getAction() == MotionEvent.ACTION_UP){
                    if (event.getRawX() >= etResetConPass.getRight() - etResetConPass.getCompoundDrawables()[Right].getBounds().width()){
                        int selection = etResetConPass.getSelectionEnd();
                        if (passwordVisible){
                            //set drawable image here
                            etResetConPass.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.reset_baseline_visibility_off_24,0);
                            //for hide password
                            etResetConPass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            passwordVisible = false;
                        } else {
                            //set drawable image here
                            etResetConPass.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.reset_baseline_visibility_24,0);
                            //for show password
                            etResetConPass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            passwordVisible = true;
                        }
                        etResetConPass.setSelection(selection);
                        return true;
                    }
                }

                return false;
            }
        });

        btnResetPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(etResetNewPass.getText().toString()))
                {
                    etResetNewPass.setError("This cannot be empty!");
                    return;
                }
                if (TextUtils.isEmpty(etResetConPass.getText().toString()))
                {
                    etResetConPass.setError("This cannot be empty!");
                    return;
                }

                Intent intent = new Intent(ResetPass.this, login.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right,
                        R.anim.slide_out_left);
            }
        });

        btnBackVer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResetPass.this, Verification.class);
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
        Intent intent = new Intent(ResetPass.this, Verification.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left,
                R.anim.slide_out_right);
    }
}
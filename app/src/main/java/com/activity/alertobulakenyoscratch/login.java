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
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity {

    private EditText Email,Password;
    private Button btnLogin;
    private TextView tvForgotPass, tvSignup;
    private ImageButton btnGoogle, btnFB, btnTwt;
    private Boolean passwordVisible;
    private FirebaseAuth fAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION); //enable full screen

        setContentView(R.layout.activity_login);

        fAuth = FirebaseAuth.getInstance();

        Email = (EditText) findViewById (R.id.Email);
        Password = (EditText) findViewById (R.id.Password);

        btnLogin = (Button) findViewById (R.id.btnLogin);

        tvForgotPass = (TextView) findViewById (R.id.tvForgotPass);
        tvSignup = (TextView) findViewById (R.id.tvSignup);

        btnGoogle = (ImageButton) findViewById (R.id.btnGoogle);
        btnFB = (ImageButton) findViewById (R.id.btnFB);
        btnTwt = (ImageButton) findViewById (R.id.btnTwt);



        if(fAuth.getCurrentUser() !=null){
            startActivity(new Intent (getApplicationContext(),MainActivity.class));
            finish();
        }


        //password visibility
        Password.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final int Right = 2;
                if (event.getAction() == MotionEvent.ACTION_UP){
                    if (event.getRawX() >= Password.getRight()-Password.getCompoundDrawables()[Right].getBounds().width()){
                        int selection = Password.getSelectionEnd();
                        if (passwordVisible){
                            //set drawable image here
                            Password.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.ic_baseline_visibility_off_24,0);
                            //for hide password
                            Password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            passwordVisible = false;
                        } else {
                            //set drawable image here
                            Password.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.ic_baseline_visibility_24,0);
                            //for show password
                            Password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            passwordVisible = true;
                        }
                        Password.setSelection(selection);
                        return true;
                    }
                }

                return false;
            }
        });


        fAuth.createUserWithEmailAndPassword(Email.getText().toString(),Password.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {


            if (TextUtils.isEmpty(Email.getText().toString()))
            {
                Email.setError("This cannot be empty!");
                return;
            }
                if (TextUtils.isEmpty(Password.getText().toString()))
                {
                Password.setError("This cannot be empty!");
                return;
                }
            }

        });
                Intent intent = new Intent(login.this, com.activity.alertobulakenyoscratch.completeInfo.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right,
                        R.anim.slide_out_left);



        tvForgotPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login.this, ForgotPass.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right,
                        R.anim.slide_out_left);
            }
        });


                btnGoogle.setOnClickListener(new View.OnClickListener(){
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

                Intent intent = new Intent(login.this, com.activity.alertobulakenyoscratch.register.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right,
                        R.anim.slide_out_left);
            }
        });


    }

     @Override
        public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left,
                R.anim.slide_out_right);
         }
}


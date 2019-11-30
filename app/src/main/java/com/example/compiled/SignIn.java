package com.example.compiled;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignIn extends AppCompatActivity {

    EditText user;
    EditText pass;

    Button signIn;
    Button forgotPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setContentView(R.layout.activity_sign_in);

        user = (EditText) findViewById(R.id.mailIn_);
        pass = (EditText) findViewById(R.id.passwordIn_);

        signIn = (Button) findViewById(R.id.signIn_);
        forgotPass = findViewById(R.id.forgotPass_);


        super.onCreate(savedInstanceState);


        signIn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                boolean trigger = false;
                if (user.getText().toString().isEmpty()) {
                    Toast.makeText(SignIn.this,
                            R.string.usernameIn, Toast.LENGTH_LONG).show();
                    trigger = true;
                }

                if (pass.getText().toString().isEmpty()) {
                    Toast.makeText(SignIn.this,
                            R.string.passIn, Toast.LENGTH_LONG).show();
                    trigger = true;
                }


                if (!pass.getText().toString().isEmpty() && !user.getText().toString().isEmpty()) {
                    trigger = false;
                }
                if (trigger == false) {
                    Intent goToHome = new Intent(SignIn.this, Main2Activity.class);
                    startActivity(goToHome);
                }

            }
        });

        forgotPass.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent goToForgotPass=new Intent(SignIn.this,Forgot_Password.class);
                startActivity(goToForgotPass);
            }
        });

    }
}


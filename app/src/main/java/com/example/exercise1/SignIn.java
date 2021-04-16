package com.example.exercise1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignIn extends AppCompatActivity {
    EditText edEmail, edPassword;

    Button btnSignin;

    String email, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        edEmail = findViewById(R.id.tEmail);
        edPassword = findViewById(R.id.tPassword);
        btnSignin = findViewById(R.id.btnSignin);

        btnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mail = "admin@mail.com";
                String sandi = "123456";

                email = edEmail.getText().toString();
                pass = edPassword.getText().toString();

                if(email.equals(mail) && pass.equals(sandi)){
                    Toast done = Toast.makeText(getApplicationContext(), "Sign in Success", Toast.LENGTH_SHORT);
                    done.show();
                    Intent i = new Intent(getApplicationContext(), Home.class);
                    startActivity(i);
                }
                else if(edEmail.getText().toString().length()==0 && edPassword.getText().toString().length()==0){
                    edEmail.setError("Email is Empty");
                    edPassword.setError("Password is Empty");
                }
                else if(edPassword.getText().toString().length()<6){
                    edPassword.setError("Password Have 6 Character or more");
                }
                else {
                    Toast.makeText(getApplicationContext(),
                            "Invalid Email and Password !!!!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
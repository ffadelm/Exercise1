package com.example.exercise1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class SignUp extends AppCompatActivity{

    EditText edtNama, edtAlamat, edtEmail, edtPass, edtRePass;
    Button btBack, btRegis;
    RadioButton rbLK, rbPR, rbIs, rbKat, rbKris, rbHin, rbBud, rbKong, rbLain;
    RadioGroup gender, agama1, agama2, agama3;
    String nama, alamat, email, password, repass, rdAgama, rdGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Bundle bundle = getIntent().getExtras();

        edtNama = findViewById(R.id.edtNama);
        edtAlamat = findViewById(R.id.edtAlamat);
        edtEmail = findViewById(R.id.edtEmail);
        edtPass = findViewById(R.id.edtPass);
        edtRePass = findViewById(R.id.edtRePass);

        rbLK = findViewById(R.id.rbLK);
        rbPR = findViewById(R.id.rbPR);
        rbIs = findViewById(R.id.rbIS);
        rbKat = findViewById(R.id.rbKat);
        rbKris = findViewById(R.id.rbKris);
        rbHin = findViewById(R.id.rbHin);
        rbBud = findViewById(R.id.rbBud);
        rbKong = findViewById(R.id.rbKong);
        rbLain = findViewById(R.id.rbLain);

        gender = findViewById(R.id.Gender);

        agama1 = findViewById(R.id.horizon1);

        agama2 = findViewById(R.id.horizon2);

        agama3 = findViewById(R.id.horizon3);

        btBack = findViewById(R.id.btBack);
        btRegis = findViewById(R.id.btRegis);

        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(), "Cencel Sign up...", Toast.LENGTH_LONG);
                Intent intent = new Intent(SignUp.this, MainActivity.class);
                toast.show();
                startActivity(intent);
            }
        });

        btRegis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtNama.getText().toString().length()==0){
                    edtNama.setError("Name required!");
                }

                else if(edtAlamat.getText().toString().length()==0){
                    edtAlamat.setError("Address Required!");
                }

                else if(edtEmail.getText().toString().length()==0){
                    edtEmail.setError("Email Required!");
                }

                else if(edtPass.getText().toString().length()==0){
                    edtPass.setError("Password Required!");
                }
                else if(edtPass.getText().toString().length()<6){
                    edtPass.setError("Password must be more than 6 characters");
                }

                else if(edtRePass.getText().toString().length()==0 && edtRePass.equals(edtPass)){
                    edtRePass.setError("Please Repeat the Password!");
                }

                if(!(rbLK.isChecked() || rbPR.isChecked()) && !(rbIs.isChecked() || rbKat.isChecked() || rbKris.isChecked() ||
                        rbHin.isChecked() || rbBud.isChecked() || rbKong.isChecked() || rbLain.isChecked())){
                    Toast.makeText(getApplicationContext(), "All data must be filled!!", Toast.LENGTH_LONG).show();
                }

                else if(edtPass.length() != 0 && edtAlamat.length() != 0 && edtEmail.length() != 0 && edtPass.length() !=0 && edtRePass.length() == 6 && edtRePass.getText() == edtRePass.getText()){
                    Toast.makeText(getApplicationContext(), "Registrasi Success!",
                            Toast.LENGTH_SHORT).show();
                    //ke layout Main activity
                    Intent i =  new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(i);
                }
            }
        });
    }
}
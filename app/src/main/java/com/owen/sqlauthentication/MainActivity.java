package com.owen.sqlauthentication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener {
    DatabaseHelper db;
    EditText etEmail, etPasswd, etConfirmPasswd;
    Button btnReg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DatabaseHelper(this);
        collectIDs();
        btnReg.setOnClickListener(this);

    }
    public void collectIDs(){
        etEmail = findViewById(R.id.etEmail);
        etPasswd = findViewById(R.id.etPassword);
        etConfirmPasswd = findViewById(R.id.etConfirm);
        btnReg = findViewById(R.id.btnRegister);
    }

    @Override
    public void onClick(View view) {
        if (view == btnReg){
            String email = etEmail.getText().toString();
            String password = etPasswd.getText().toString();
            String confirmPassword = etConfirmPasswd.getText().toString();
            if (email.equals("") || password.equals("") || confirmPassword.equals("")){
                Toast.makeText(getApplicationContext(),"Fields cannot be empty",Toast.LENGTH_SHORT).show();
            }
            else if(password.equals(confirmPassword)){
                Boolean chkMail = db.chMail(email);
                if (chkMail==true){
                    Boolean insert = db.insertData(email,password);
                    if (insert==true){
                        Toast.makeText(getApplicationContext(),"Registered successfully",Toast.LENGTH_SHORT).show();
                    }
                }
            }
            else {
                Toast.makeText(getApplicationContext(),"Password don't match",Toast.LENGTH_SHORT).show();
            }
        }
    }
}
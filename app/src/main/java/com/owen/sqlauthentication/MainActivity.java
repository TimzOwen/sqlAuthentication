package com.owen.sqlauthentication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener {

    EditText etEmail, etPasswd, etConfirmPasswd;
    Button btnReg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        }
    }
}
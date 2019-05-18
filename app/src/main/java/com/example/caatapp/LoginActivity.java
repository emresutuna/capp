package com.example.caatapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.androidquery.AQuery;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    AQuery aQuery;

    EditText edtUsername,edtPass;
    Button btnLogin;
    private  FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();

        edtUsername = (EditText) findViewById(R.id.mailEt);
        edtPass = (EditText) findViewById(R.id.passwordEt);
        btnLogin = (Button) findViewById(R.id.loginButton);
        aQuery=new AQuery(this);
        aQuery.id(R.id.registerButton).getTextView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });



        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!edtUsername.getText().toString().equals("") || !edtPass.getText().toString().equals("")){
                    mAuth.signInWithEmailAndPassword(edtUsername.getText().toString(),edtPass.getText().toString())
                            .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()){
                                        Intent i =new Intent(LoginActivity.this,MainActivity.class);
                                        startActivity(i);
                                    }else{
                                        Toast.makeText(LoginActivity.this, "Giriş Başarısız.", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }

            }
        });
    }
}

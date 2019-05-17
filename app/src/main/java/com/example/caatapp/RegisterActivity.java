package com.example.caatapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.androidquery.AQuery;

public class RegisterActivity extends AppCompatActivity {
AQuery aQuery;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        aQuery=new AQuery(this);
    }
    void valid(){
        if(aQuery.id(R.id.usernameEtReg).getEditText().getText().length()<0){
            Log.d("UsernameReg","Length Error");
        }
        if (aQuery.id(R.id.passwordEtReg).getEditText().getText().length()<5){
            Log.d("Password Register","Length Error");
        }else if(aQuery.id(R.id.passwordRegR).getEditText().getText().toString()!=aQuery.id(R.id.passwordEtReg).getEditText().getText().toString()){
            Log.d("Repeat Resister Pass","Password not same");
        }
        else  if(aQuery.id(R.id.ageEt).getEditText().getText().length()<0){
            Log.d("Age Register","Lenght Error");
        }
    }
}

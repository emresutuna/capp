package com.example.caatapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import com.androidquery.AQuery;

public class RegisterActivity extends AppCompatActivity {
AQuery aQuery;
public int sexStatus=-1;
String email,password;
RelativeLayout getForm,boyRel,girRel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        aQuery=new AQuery(this);
        getForm=(RelativeLayout)findViewById(R.id.registerEmail );
        boyRel=(RelativeLayout)findViewById(R.id.constraintLayout3 );
        girRel=(RelativeLayout)findViewById(R.id.constraintLayout4 );
        aQuery.id(R.id.girlButton).getImageView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sexStatus=0;
                aQuery.id(R.id.buttonCont).getButton().setVisibility(View.VISIBLE);
                aQuery.id(R.id.buttonCont).getButton().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        clickContinue();
                    }
                });
                Log.d("GirlButtonClicked", String.valueOf(sexStatus));
            }
        });
        aQuery.id(R.id.boyButton).getImageView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sexStatus=1;
                aQuery.id(R.id.buttonCont).getButton().setVisibility(View.VISIBLE);
                aQuery.id(R.id.buttonCont).getButton().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        clickContinue();
                    }
                });
                Log.d("BoyButtonClicked", String.valueOf(sexStatus));
            }
        });
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    void clickContinue(){
        aQuery.id(R.id.boyButton).getImageView().setVisibility(View.GONE);
        aQuery.id(R.id.girlButton).getImageView().setVisibility(View.GONE);
        aQuery.id(R.id.textView2).getTextView().setVisibility(View.GONE);
        aQuery.id(R.id.buttonCont).getButton().setVisibility(View.GONE);
        boyRel.setVisibility(View.GONE);
        girRel.setVisibility(View.GONE);
        getForm.setVisibility(View.VISIBLE);


    }

    /* void valid(){
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
    }*/
}

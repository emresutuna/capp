package com.example.caatapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.androidquery.AQuery;

public class SplashActivity extends AppCompatActivity {
AQuery aQuery;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();

aQuery=new AQuery(this);
aQuery.id(R.id.goLogin).getButton().setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(SplashActivity.this,LoginActivity.class);
        startActivity(intent);
    }
});
aQuery.id(R.id.goRegister).getButton().setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(SplashActivity.this,RegisterActivity.class);
        startActivity(intent);
    }
});
    }
}

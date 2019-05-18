package com.example.caatapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.androidquery.AQuery;
import com.example.caatapp.Models.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Random;

public class RegisterActivity extends AppCompatActivity {
    AQuery aQuery;
    public int sexStatus=-1;
    Button btnRegister;
    String email,password;
    LinearLayout genderStep,registerStep;
    private FirebaseFirestore db;
    EditText edtMail,edtPass,edtTryPass;
    private FirebaseAuth mAuth;
    RelativeLayout getForm,boyRel,girRel,loadingReg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();
        aQuery=new AQuery(this);
        getForm=(RelativeLayout)findViewById(R.id.registerEmail);
        genderStep=(LinearLayout)findViewById(R.id.genderStep);
        registerStep=(LinearLayout)findViewById(R.id.registerStep);
        btnRegister = (Button) findViewById(R.id.btnReg);
        loadingReg=(RelativeLayout)findViewById(R.id.loadingRegister);
        edtMail = (EditText) findViewById(R.id.usernameEtReg);
        edtPass = (EditText) findViewById(R.id.passwordEtReg);
        edtTryPass = (EditText) findViewById(R.id.passwordRegR);
        boyRel=(RelativeLayout)findViewById(R.id.constraintLayout3 );
        db = FirebaseFirestore.getInstance();
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


        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!edtMail.getText().toString().equals("") || !edtPass.getText().toString().equals("") || !edtTryPass.getText().toString().equals("") ){
                    if (edtPass.getText().toString().equals(edtTryPass.getText().toString())){
                        Random rnd = new Random();
                        final int a = rnd.nextInt(99999999);
                        getForm.setVisibility(View.GONE);
                        loadingReg.setVisibility(View.VISIBLE);
                        mAuth.createUserWithEmailAndPassword(edtMail.getText().toString(),edtPass.getText().toString())
                                .addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {


                                        if(task.isSuccessful()){

                                            User  user = new User(FirebaseAuth.getInstance().getUid(), String.valueOf(a),1,false,"",0,sexStatus,0,0,0);
                                            db.collection("Users").document(FirebaseAuth.getInstance().getUid())
                                                    .set(user)
                                                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                                                        @Override
                                                        public void onSuccess(Void aVoid) {

                                                            //Diğer sayfaya yönlendirme olacak
                                                            loadingReg.setVisibility(View.GONE);
                                                            getForm.setVisibility(View.VISIBLE);

                                                        }
                                                    }).addOnFailureListener(new OnFailureListener() {
                                                @Override
                                                public void onFailure(@NonNull Exception e) {
                                                    Toast.makeText(RegisterActivity.this, "Bir hata Oluştu. Lütfen Daha Sonra Tekrar Deneyin.", Toast.LENGTH_SHORT).show();
                                                    loadingReg.setVisibility(View.GONE);
                                                    getForm.setVisibility(View.VISIBLE);
                                                }
                                            });


                                        }else{
                                            loadingReg.setVisibility(View.GONE);
                                            getForm.setVisibility(View.VISIBLE);
                                            Toast.makeText(RegisterActivity.this, "Bir Hata Oluştu. Lütfen Daha Sonra Tekrar Deneyin.", Toast.LENGTH_SHORT).show();
                                        }

                                    }
                                });


                    }else{
                        loadingReg.setVisibility(View.GONE);
                        getForm.setVisibility(View.VISIBLE);
                        Toast.makeText(RegisterActivity.this, "Şifrenizin Tekrarı Doğru Değil!", Toast.LENGTH_SHORT).show();

                    }

                }
                else{
                    Toast.makeText(RegisterActivity.this, "Boş Alan Bırakmayınız.", Toast.LENGTH_SHORT).show();
                }

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
        genderStep.setBackgroundResource(R.drawable.shape_steper);
        registerStep.setBackgroundResource(R.drawable.shape_steper1);

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

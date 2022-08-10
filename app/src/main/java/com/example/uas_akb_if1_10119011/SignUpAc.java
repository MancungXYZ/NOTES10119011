package com.example.uas_akb_if1_10119011;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
//Identitas
//Nama  : Reihan Wiyanda
//Kelas : IF-1
//Nim   : 10119011
public class SignUpAc extends AppCompatActivity {

    FirebaseAuth firebaseAuth;
    Button daftar;
    EditText email, password;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        //Menginisiasi Variable
        email = findViewById(R.id.emailSign);
        password = findViewById(R.id.passwordSign);
        daftar = findViewById(R.id.btn_sign_up);
        progressBar = findViewById(R.id.progressSign);
        firebaseAuth = FirebaseAuth.getInstance();

        daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mail = email.getText().toString();
                String pass = password.getText().toString();

                if (TextUtils.isEmpty(mail)) {
                    email.setError("Email tidak boleh kosong");
                    return;
                }

                if (TextUtils.isEmpty(pass)) {
                    password.setError("Password tidak boleh kosong");
                    return;
                }

                if (pass.length() < 4) {
                    password.setError("Password tidak boleh kurang dari 4 karakter");
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);

                //Mulai memasukan data ke dalam firebase
                firebaseAuth.createUserWithEmailAndPassword(mail, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(SignUpAc.this, "Akun berhasil dibuat", Toast.LENGTH_SHORT).show();
                            email.getText().clear();
                            password.getText().clear();

                        } else {
                            Toast.makeText(SignUpAc.this, "Ooops, terjadi kesalahan", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                progressBar.setVisibility(View.INVISIBLE);
            }
        });

    }

    public void masuk (View view) {
        startActivity(new Intent(getApplicationContext(), LoginAct.class));
    }

}
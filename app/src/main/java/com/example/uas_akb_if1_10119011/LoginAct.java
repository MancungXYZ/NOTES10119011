package com.example.uas_akb_if1_10119011;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginAct extends AppCompatActivity {
    FirebaseAuth firebaseAuth;
    EditText email, password;
    Button masuk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        masuk = (Button) findViewById(R.id.btn_login);

        firebaseAuth = FirebaseAuth.getInstance();

        masuk.setOnClickListener(new View.OnClickListener() {
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

                firebaseAuth.signInWithEmailAndPassword(mail, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            startActivity(new Intent(getApplicationContext(), NavigationActivity.class));
                        } else {
                            Toast.makeText(LoginAct.this, "Username atau Password salah", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }


    public void pendaftaran(View view) {
        startActivity(new Intent(getApplicationContext(), SignUpAc.class));
    }

}
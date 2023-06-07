package com.example.okeyplay.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.okeyplay.MainActivity;
import com.example.okeyplay.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    private EditText Email;
    private EditText Password;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportActionBar().hide();

        mAuth = FirebaseAuth.getInstance();

        mAuthListener = new FirebaseAuth.AuthStateListener(){
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth){
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null)
                {
                    //user signed in
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                }
                else
                {
                    //user signed out
                }
            }
        };

        Email = (EditText) findViewById(R.id.inputEmail);
        Password = (EditText) findViewById(R.id.inputPassword);

        findViewById(R.id.buttonEnter).setOnClickListener(this);
        findViewById(R.id.buttonReg).setOnClickListener(this);

        FirebaseUser user = mAuth.getCurrentUser();
        if (user != null){
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.buttonEnter)
        {
            if (Email.getText().toString().isEmpty() || Password.getText().toString().isEmpty())
            {
                Toast.makeText(LoginActivity.this, "Введите почту и пароль!", Toast.LENGTH_SHORT).show();
            }
            else
            {
                if (Email.getText().toString().contains("@")){
                    signing(Email.getText().toString(), Password.getText().toString());
                }
                else
                {
                    Toast.makeText(LoginActivity.this, "Неверный формат почты!", Toast.LENGTH_SHORT).show();
                }
            }
        }
        else if (view.getId() == R.id.buttonReg)
        {
            if (Email.getText().toString().isEmpty() || Password.getText().toString().isEmpty())
            {
                Toast.makeText(LoginActivity.this, "Введите почту и пароль!", Toast.LENGTH_SHORT).show();
            }
            else
            {
                if (Email.getText().toString().contains("@")){
                    registration(Email.getText().toString(), Password.getText().toString());
                }
                else
                {
                    Toast.makeText(LoginActivity.this, "Неверный формат почты!", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    public void signing(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(LoginActivity.this, "Вы успешно авторизировались!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(LoginActivity.this, "\t\t\t\t\t\t\t\tОшибка!\nНеверная почта или пароль.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void registration(String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(LoginActivity.this, "Вы успешно зарегистрировались!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(LoginActivity.this, "\t\t\t\t\t\t\t\t\t\t\t\tОшибка!\nПароль должен быть длинее 6-ти символов.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
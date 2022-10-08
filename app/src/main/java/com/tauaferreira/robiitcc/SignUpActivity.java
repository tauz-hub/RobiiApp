package com.tauaferreira.robiitcc;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignUpActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        setupHyperlinkHaveAccount();

        getSupportActionBar().hide();


        Button mbutton = findViewById(R.id.button_create);

        mbutton.setOnClickListener(view -> {
            EditText mUsername = findViewById(R.id.editText_signup_username);
            EditText mEmail = findViewById(R.id.editText_signup_email_address);
            EditText mPassword = findViewById(R.id.editText_signup_password);


            Usuario user = new Usuario(mUsername.getText().toString(),mEmail.getText().toString(),mPassword.getText().toString());
            boolean resp = UsuarioDAO.registrarUsuario(user);
            if(resp) {
                startActivity(new Intent(getBaseContext(), LoginActivity.class));
                finish();
            } else {
                Toast.makeText(getBaseContext(), "Usuario não registrado! Tente novamente alterando os campos", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void setupHyperlinkHaveAccount() {
        TextView linkTextView = findViewById(R.id.textView_signup_havaaccount);
        linkTextView.setMovementMethod(LinkMovementMethod.getInstance());
        linkTextView.setOnClickListener(
                v -> {
                    startActivity(new Intent(getBaseContext(), LoginActivity.class));
                    finish();
                });
    }
}

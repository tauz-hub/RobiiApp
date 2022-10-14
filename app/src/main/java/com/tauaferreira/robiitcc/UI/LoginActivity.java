package com.tauaferreira.robiitcc.UI;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.tauaferreira.robiitcc.R;
import com.tauaferreira.robiitcc.DAO.UsuarioDAO;

public class LoginActivity extends AppCompatActivity {
    public static final String NOME_PREFERENCE = "INFORMACOES_LOGIN_AUTOMATICO";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setupLoginForgotPassword();
        setupLoginSignUp();

        //Login Automático
        SharedPreferences prefs = getSharedPreferences(NOME_PREFERENCE, MODE_PRIVATE);
        String login = prefs.getString("usernameSave", null);
        String senha = prefs.getString("passwordSave", null);
        if (login != null) {
            boolean res = UsuarioDAO.verificarUsuario(login, senha);
            if (res) {
                startActivity(new Intent(getBaseContext(), ConnectBluetoothActivity.class));
                finish();
            }

        }

        Button buttonLogin = findViewById(R.id.button_login);

        buttonLogin.setOnClickListener(view -> {
            EditText mUsername = findViewById(R.id.editText_login_username);
            EditText mPassword = findViewById(R.id.editText_login_password);
            boolean res = UsuarioDAO.verificarUsuario(mUsername.getText().toString(), mPassword.getText().toString());

            if (res) {

                SharedPreferences.Editor editor = getSharedPreferences(NOME_PREFERENCE, MODE_PRIVATE).edit();

                editor.putString("usernameSave", mUsername.getText().toString());
                editor.putString("passwordSave", mPassword.getText().toString());
                editor.apply();
                startActivity(new Intent(getBaseContext(), ConnectBluetoothActivity.class));
                finish();
            } else {
                Toast.makeText(getBaseContext(), "Usuario não autenticado", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void setupLoginForgotPassword() {
        TextView linkTextView = findViewById(R.id.textView_login_forgotpassword);
        linkTextView.setMovementMethod(LinkMovementMethod.getInstance());
        linkTextView.setOnClickListener(
                v -> {
//                    startActivity(new Intent(getBaseContext(), MainActivity.class));
//                    finish();
                });
    }

    private void setupLoginSignUp() {
        TextView linkTextView = findViewById(R.id.textView_hyperlink_signup);
        linkTextView.setMovementMethod(LinkMovementMethod.getInstance());
        linkTextView.setOnClickListener(
                v -> {
                    startActivity(new Intent(getBaseContext(), SignUpActivity.class));
                    finish();
                });
    }
}

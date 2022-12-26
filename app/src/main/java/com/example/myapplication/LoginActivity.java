package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText usuario, password;
    Button btlogin;

    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usuario = (EditText) findViewById(R.id.usuarioregistrado_text);
        password = (EditText) findViewById(R.id.passwordregistrada_text);
        btlogin = (Button) findViewById(R.id.enter_bt);
        DB = new DBHelper(this);

        btlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user =usuario.getText().toString();
                String pass= password.getText().toString();

                if(user.equals("")||pass.equals(""))
                    Toast.makeText(LoginActivity.this, "Usuario registrado correctamente", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkuserpass =DB.checkdata(user, pass);
                    if(checkuserpass==true){
                        Toast.makeText(LoginActivity.this, "Introducido correctamente", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(LoginActivity.this, "Credenciales no validos", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }

    public void launchMenuActivity(View view) {
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }


}
package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistroActivity extends AppCompatActivity {
    EditText email, usuario, password, repassword;
    Button registrarse, estarregistrado;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        email = (EditText) findViewById(R.id.email_text);
        usuario = (EditText) findViewById(R.id.usuario_text);
        password = (EditText) findViewById(R.id.password_text);
        repassword = (EditText) findViewById(R.id.repassword_text);
        registrarse = (Button) findViewById(R.id.registrarse_bt);
        estarregistrado = (Button) findViewById(R.id.existeusuario);
        DB = new DBHelper(this);

        registrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user= usuario.getText().toString();
                String emails= email.getText().toString();
                String pass= password.getText().toString();
                String repass= repassword.getText().toString();

                if(user.equals("")||emails.equals("")||pass.equals("")||repass.equals(""))
                    Toast.makeText(RegistroActivity.this, "Porfavor rellene todas las casillas", Toast.LENGTH_SHORT).show();
                else{
                    if(pass.equals(repass)){
                        Boolean checkuser = DB.checkusuario(user);
                        if(checkuser==false){
                            Boolean insert =DB.insertData(user, emails, pass);
                            if(insert==true){
                                Toast.makeText(RegistroActivity.this, "Usuario registrado correctamente", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(RegistroActivity.this, "Error, usuario no registrado", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(RegistroActivity.this, "El usuario ya existe", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(RegistroActivity.this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        estarregistrado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent intent= new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(intent);
            }
        });

    }

    public void Login(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}
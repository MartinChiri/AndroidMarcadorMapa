package com.martinchiri.saritacoloniaavisos;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    TextInputEditText tiUser, tiClave;
    Button btIngresar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        tiUser=findViewById(R.id.tiUser);
        tiClave=findViewById(R.id.tiClave);
        btIngresar=findViewById(R.id.btIngresar);
        btIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user=tiUser.getText().toString();
                String clave=tiClave.getText().toString();
                if(user.equals("user")&&clave.equals("121212")){
                    startActivity(new Intent(getApplicationContext(),OfertasActivity.class)); 
                }
                else{
                    Toast.makeText(LoginActivity.this, "User o clave incorrecto", Toast.LENGTH_SHORT).show();
                }
                    
            }
        });
    }
}

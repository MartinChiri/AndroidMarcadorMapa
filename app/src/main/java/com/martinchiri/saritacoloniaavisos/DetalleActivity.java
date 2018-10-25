package com.martinchiri.saritacoloniaavisos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetalleActivity extends AppCompatActivity {
    TextView tvDetalleTitulo,tvDetalle,tvDireccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);
        tvDetalleTitulo=findViewById(R.id.tvDetalleTitulo);
        tvDetalle=findViewById(R.id.tvDetalle);
        tvDireccion=findViewById(R.id.tvDireccion);

        Intent transporte=getIntent();
        final String titulo=transporte.getStringExtra(OfertasActivity.IDTITULO);
        String detalle=transporte.getStringExtra(OfertasActivity.IDDETALLE);
        String direccion=transporte.getStringExtra(OfertasActivity.IDDIRECCION);

        tvDetalleTitulo.setText(titulo);
        tvDetalle.setText(detalle);
        tvDireccion.setText(direccion);

    }
}

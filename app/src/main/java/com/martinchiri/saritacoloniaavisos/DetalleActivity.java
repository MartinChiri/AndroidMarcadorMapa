package com.martinchiri.saritacoloniaavisos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetalleActivity extends AppCompatActivity {
    TextView tvDetalleTitulo,tvDetalle,tvDireccion;
    Button btMapa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);
        tvDetalleTitulo=findViewById(R.id.tvDetalleTitulo);
        tvDetalle=findViewById(R.id.tvDetalle);
        tvDireccion=findViewById(R.id.tvDireccion);
        btMapa=findViewById(R.id.btMapa);

        Intent transporte=getIntent();
        final String titulo=transporte.getStringExtra(OfertasActivity.IDTITULO);
        String detalle=transporte.getStringExtra(OfertasActivity.IDDETALLE);
        String direccion=transporte.getStringExtra(OfertasActivity.IDDIRECCION);
        final double latitud=transporte.getDoubleExtra(OfertasActivity.IDLATITUD,12.0431800);
        final double longitud=transporte.getDoubleExtra(OfertasActivity.IDLONGITUD,-77.0282400);

        tvDetalleTitulo.setText(titulo);
        tvDetalle.setText(detalle);
        tvDireccion.setText(direccion);

        btMapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //intent con latitud longitud y titulo para el marcador en maps
                Intent transporte=new Intent(getApplicationContext(),MapsActivity.class);
                transporte.putExtra(OfertasActivity.IDLATITUD,latitud);
                transporte.putExtra(OfertasActivity.IDLONGITUD,longitud);
                transporte.putExtra(OfertasActivity.IDTITULO,titulo);

                startActivity(transporte);
            }
        });

    }
}

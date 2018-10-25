package com.martinchiri.saritacoloniaavisos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class OfertasActivity extends AppCompatActivity {
    RecyclerView rvLista;
    AdaptadorAviso adaptadorAviso;
    ArrayList<Aviso> elementos;
    //identificadores para intent( hacia detalle)
    public static final String IDTITULO = "idTitulo";
    public static final String IDDETALLE = "idDetalle";
    public static final String IDDIRECCION = "idDireccion";
    public static final String IDLATITUD = "idLatitud";
    public static final String IDLONGITUD = "idLongitud";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ofertas);
        rvLista = findViewById(R.id.rvLista);
        //carga los elementos con sus respectivos listeners
        cargarElementos();
    }

    private void cargarElementos() {
        elementos = new ArrayList<>();
        elementos.add(new Aviso("ALQUILER DE TAXI", "PUERTA LIBRE, VIVIR POR LOS LIMITES DE CERCADO DE LIMA.\nLLAMAR AL NÚMERO #968552611", "BREÑA", -12.05691, -77.05366));
        elementos.add(new Aviso("!SE COMPRA!", "ROPA Y ZAPATOS DE 2DA DE DAMAS,CABALLEROS Y NIÑOS ROPA DE CAMA Y CORTINAS. TAMBIÉN SE COMPRA TODO TIPO DE MUEBLES DE SALA, DORMITORIO, COMEDOR, COCINA, ARTEFACTOS, PAPELES, LIBROS , JUGUETES, ETC\nSUGEY\nTLF: 766-6400", "LINCE", -12.08133, -77.03077));
        elementos.add(new Aviso("MANTENIMIENTO DE ARAÑAS Y PULIDO DE BRONCE", "DECORACIONES DAYAN\nTLF : 4337139 - 997752426\nSR. JORGE RIOS", "SAN BORJA", -12.107939, -76.99907));
        elementos.add(new Aviso("SE VENDE DEPARTAMENTO", "SALA AMPLIA 3 DORMITORIOS, COCINA Y 2 BAÑOS\nLLAMAR A FIJO DE 4PM A 7PM\nTELF: 5643854", "SAN LUIS", -12.072949, -76.99755));
        elementos.add(new Aviso("SE ALQUILA HABITACIONES EN SAN MIGUEL", "ALT. CDRA 29 DE LA AV. LA PAZ\nPARA PERSONAS SOLAS O ESTUDIANTES\nS/ 250.00 MENSUALES\nTELF : 262-6149 NEX : (94)622*1653", "SAN MIGUEL", -12.09006, -77.08665));
        adaptadorAviso = new AdaptadorAviso(elementos, new AdaptadorAviso.OnItemClickListener() {
            @Override
            public void onItemClick(Aviso aviso, int position) {
                Intent transporte = new Intent(getApplicationContext(), DetalleActivity.class);
                transporte.putExtra(IDTITULO, aviso.getTitulo());
                transporte.putExtra(IDDETALLE, aviso.getDetalle());
                transporte.putExtra(IDDIRECCION, aviso.getDireccion());
                transporte.putExtra(IDLATITUD, aviso.getLatitud());
                transporte.putExtra(IDLONGITUD, aviso.getLongitud());
                startActivity(transporte);
            }
        });
        rvLista.setAdapter(adaptadorAviso);
        rvLista.setLayoutManager(new LinearLayoutManager(OfertasActivity.this));

    }
}

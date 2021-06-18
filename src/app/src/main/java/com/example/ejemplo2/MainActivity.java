package com.example.ejemplo2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.content.Intent;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity<paquete> extends AppCompatActivity {



        ArrayList<String> DatosLista;
        ArrayList<String> DatosLista2;
        ArrayAdapter<String> Adaptador;
        ArrayAdapter<String> Adaptador2;
        String textoSeleccionado;
        String textoSeleccionado2;
        EditText aula;
        Button botonContinuar;
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference mirootReference;
       EditText mitexto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mirootReference = FirebaseDatabase.getInstance().getReference();

        botonContinuar = findViewById(R.id.boton1);
        aula = findViewById(R.id.aula);
mitexto=findViewById(R.id.mitexto);
        DatosLista=new ArrayList<>();
        DatosLista.add("1 Yatay");
        DatosLista.add("2 Rio");
        DatosLista.add("4 Yatay Nuevo");

        Adaptador=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, DatosLista);
        Adaptador.setDropDownViewResource((android.R.layout.simple_dropdown_item_1line));

        Spinner spnOpciones = (Spinner) findViewById(R.id.spinner1);
        spnOpciones.setAdapter(Adaptador);

        int Posicion;
        Posicion=spnOpciones.getSelectedItemPosition();


        textoSeleccionado=spnOpciones.getItemAtPosition(Posicion).toString();

        DatosLista2=new ArrayList<>();
        DatosLista2.add("PB");
        DatosLista2.add("1");
        DatosLista2.add("2");
        DatosLista2.add("3");
        DatosLista2.add("4");

        Adaptador2=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, DatosLista2);
        Adaptador2.setDropDownViewResource((android.R.layout.simple_dropdown_item_1line));

        Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
        spinner2.setAdapter(Adaptador2);

        int posicion2;
        posicion2=spinner2.getSelectedItemPosition();


        textoSeleccionado2=spinner2.getItemAtPosition(posicion2).toString();

        botonContinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String edificio;
                String aulaIngresada;
                String piso;
                String descripcion;
                aulaIngresada=aula.getText().toString();
                edificio=textoSeleccionado;
                piso=textoSeleccionado2;
               descripcion=mitexto.getText().toString();
                Map<String, Object> registroUbicacion = new HashMap<>();
                registroUbicacion.put("edificio", edificio);
                registroUbicacion.put("piso", piso);
                registroUbicacion.put("aula", aulaIngresada);
                registroUbicacion.put("descripcion", descripcion);
                mirootReference.child("Ubicacion").push().setValue(registroUbicacion);

                Context context = getApplicationContext();
                CharSequence text = "Tu reclamo se ha enviado correctamente";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();

                Intent myIntent = new Intent(v.getContext(), misreclamos.class);
                startActivity(myIntent);
            }
        });


    }

    public void guardarUbicacion(View v){
        String edificio;
        String aulaIngresada;
        String piso;
        String descripcion;
        aulaIngresada=aula.getText().toString();
        edificio=textoSeleccionado;
        piso=textoSeleccionado2;
descripcion=mitexto.getText().toString();
        Ubicacion ub = new Ubicacion();
        ub.setEdificio(edificio);
        ub.setPiso(piso);
        ub.setAula(aulaIngresada);
        ub.setDescripcion(descripcion);
    }


}

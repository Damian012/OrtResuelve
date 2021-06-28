package com.ort.ort__resuelve;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.content.Intent;
import android.widget.TextView;

import java.util.Collections;

import com.google.errorprone.annotations.Var;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static java.util.Objects.requireNonNull;

public class misreclamos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_misreclamos);

      // TextView reclamos=findViewById(R.id.reclamos);

        //FirebaseAuth mAuth;
       // mAuth = FirebaseAuth.getInstance();
        mostrar();
    }

void mostrar(){
        ValueEventListener userListener= new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
       for(DataSnapshot dataSnapshot : snapshot.getChildren()){
           Ubicacion miubicacion= dataSnapshot.getValue(Ubicacion.class);
           ArrayList<Ubicacion> nuestrasubicaciones= new ArrayList<>();
           nuestrasubicaciones.add(miubicacion);
           Log.d("Aula", miubicacion.getAula());
           Log.d("Descripcion", miubicacion.getDescripcion());
           Log.d("Piso", miubicacion.getPiso());
           Log.d("Edificio", miubicacion.getEdificio());
       }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        };
    DatabaseReference mibdd=FirebaseDatabase.getInstance().getReference();
    mibdd.addValueEventListener(userListener);
}



}
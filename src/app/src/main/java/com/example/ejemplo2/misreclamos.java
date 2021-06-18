package com.example.ejemplo2;

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
        setContentView(R.layout.activity_reclamos);
        // ArrayList<Ubicacion> nuestrasubicaciones;
        // Agregue un text view
       TextView reclamos=findViewById(R.id.reclamos);
        DatabaseReference mibdd=FirebaseDatabase.getInstance().getReference();

        mibdd.child("Ubicacion");
        mibdd.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
             Ubicacion miubicacion= snapshot.getValue(Ubicacion.class);
             String piso=miubicacion.getPiso();

             Log.e("piso:", ""+piso);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }



}
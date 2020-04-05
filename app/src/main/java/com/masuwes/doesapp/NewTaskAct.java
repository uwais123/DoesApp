package com.masuwes.doesapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Random;

public class NewTaskAct extends AppCompatActivity {

    TextView titlepage, addtitle, addDesc, adddate;
    EditText titleDoes, descDoes, dateDoes;
    Button btnSave, btnCancel;
    DatabaseReference reference;
    Integer doesNum = new Random().nextInt();
    String keydoes = Integer.toString(doesNum);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task);

        titlepage = findViewById(R.id.titlePage);

        titleDoes = findViewById(R.id.titleDoes);
        addtitle = findViewById(R.id.addtitle);

        descDoes = findViewById(R.id.descDoes);
        addDesc = findViewById(R.id.addDesc);

        dateDoes = findViewById(R.id.dateDoes);
        adddate = findViewById(R.id.adddate);
        btnSave = findViewById(R.id.btnSaveTask);
        btnCancel = findViewById(R.id.btnCancel);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reference = FirebaseDatabase.getInstance().getReference().child("DoesApp").child("Does" + doesNum);
                reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        dataSnapshot.getRef().child("titledoes").setValue(titleDoes.getText().toString());
                        dataSnapshot.getRef().child("descdoes").setValue(descDoes.getText().toString());
                        dataSnapshot.getRef().child("datedoes").setValue(dateDoes.getText().toString());
                        dataSnapshot.getRef().child("keydoes").setValue(keydoes);

                        Intent a = new Intent(NewTaskAct.this, MainActivity.class);
                        startActivity(a);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });

        // import font
        Typeface MLight = Typeface.createFromAsset(getAssets(), "fonts/mm.ttf");
        Typeface MMedium = Typeface.createFromAsset(getAssets(), "fonts/ml.ttf");

        titlepage.setTypeface(MMedium);

        addtitle.setTypeface(MLight);
        titleDoes.setTypeface(MMedium);

        addDesc.setTypeface(MLight);
        descDoes.setTypeface(MMedium);

        adddate.setTypeface(MLight);
        dateDoes.setTypeface(MMedium);

        btnSave.setTypeface(MMedium);
        btnCancel.setTypeface(MLight);

    }
}





























//end

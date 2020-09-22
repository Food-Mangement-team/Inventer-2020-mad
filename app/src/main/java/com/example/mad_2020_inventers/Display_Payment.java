package com.example.mad_2020_inventers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Display_Payment extends AppCompatActivity {
    TextView date, amount, cardtype, cid;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display__payment);


        amount = findViewById(R.id.textView31);
        date = findViewById(R.id.textView37);
        cardtype = findViewById(R.id.textView38);
        cid = findViewById(R.id.textView12);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference readref = database.getReference("Payment").child("pay1");
        readref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.hasChildren()) {

                    date.setText(snapshot.child("date").getValue().toString());
                    cardtype.setText(snapshot.child("cardtype").getValue().toString());
                    cid.setText(snapshot.child("cid").getValue().toString());
                    amount.setText(snapshot.child("amount").getValue().toString());


                }
                else{
                    Toast.makeText(getApplicationContext(),"no source to show",Toast.LENGTH_SHORT).show();
                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    }



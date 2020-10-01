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
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Display_Payment extends AppCompatActivity {
    TextView date, amount, cardtype;

DatabaseReference readref;
    Query q1;
    String cid;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display__payment);

Intent intent= getIntent();
  cid = intent.getStringExtra(Payment.EXTRA_MESSAGE);

        amount = findViewById(R.id.textView31);
        date = findViewById(R.id.textView37);
        cardtype = findViewById(R.id.textView38);


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        q1 = database.getReference("Payment").child(cid);
        q1.addValueEventListener(valueEventListener);




    }
    ValueEventListener valueEventListener = new ValueEventListener(){
        public void onDataChange(@NonNull DataSnapshot snapshot) {
            if (snapshot.hasChildren()) {

                date.setText(String.valueOf(snapshot.child("date2").getValue().toString()));
                cardtype.setText(snapshot.child("cardtype").getValue().toString());

                amount.setText(snapshot.child("amount").getValue().toString());


            }
            else{
                Toast.makeText(getApplicationContext(),"no source to show",Toast.LENGTH_SHORT).show();
            }


        }

        @Override
        public void onCancelled(@NonNull DatabaseError error) {

        }
    };
public void delete(View v){
    DatabaseReference reff;
    reff = FirebaseDatabase.getInstance().getReference("Payment").child(cid);
    reff.removeValue();
    Intent intent2 =  new Intent(this, Display_Payment.class);
    startActivity(intent2);
}

    }



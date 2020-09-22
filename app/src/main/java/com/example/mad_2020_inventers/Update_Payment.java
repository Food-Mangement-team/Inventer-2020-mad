package com.example.mad_2020_inventers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Update_Payment extends AppCompatActivity {

    EditText id, amount, date;
    FirebaseDatabase database = FirebaseDatabase.getInstance();

    DatabaseReference myRef3;
    Payment_data pay2;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update__payment);


        /*id = findViewById(R.id.editTextTextPersonName3);
        amount = findViewById(R.id.editTextNumber3);
        date = findViewById(R.id.editTextDate2);

         /intent = getIntent();
        intent.getStringExtra("id");
        intent.getStringExtra("amount");
        intent.getStringExtra("date");

        id.setText(intent.getStringExtra("id"));
        amount.setText(intent.getStringExtra("amount"));
        date.setText(intent.getStringExtra("date"));*/
    }


}
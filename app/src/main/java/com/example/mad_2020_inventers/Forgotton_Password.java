package com.example.mad_2020_inventers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Forgotton_Password extends AppCompatActivity {
    EditText uname;
    TextView forgot;
    String password1;
    Query q2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotton__password);
        uname = findViewById(R.id.editTextTextPersonName);
forgot = findViewById(R.id.textView40);

    }
    public void forgot(View v){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        q2 = database.getReference("Member").child(uname.getText().toString());
        q2.addValueEventListener(valueEventListener);


    }
    ValueEventListener valueEventListener = new ValueEventListener(){
        public void onDataChange(@NonNull DataSnapshot snapshot) {
            if (snapshot.hasChildren()) {

              password1= snapshot.child("password").getValue().toString();
                forgot.setText("your Password is="+ password1);


            }
            else{
                Toast.makeText(getApplicationContext(),"no source to show",Toast.LENGTH_SHORT).show();
            }


        }

        @Override
        public void onCancelled(@NonNull DatabaseError error) {

        }
    };

}
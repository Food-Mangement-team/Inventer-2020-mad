package com.example.mad_2020_inventers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ServerValue;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class Payment extends AppCompatActivity {
    EditText name, amount, cid, Cardtype,cid2;
    DatePicker simpleDatePicker;

    DatabaseReference myRef;
    Payment_data pay;
    public static final String EXTRA_MESSAGE = "com.example.mad_2020_inventers.MESSAGE";
    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        simpleDatePicker = (DatePicker) findViewById(R.id.simpleDatePicker);

       name = findViewById(R.id.editTextTextPersonName5);
        amount = findViewById(R.id.editTextNumber);

        cid = findViewById(R.id.editTextNumber2);
        Cardtype = findViewById(R.id.editTextTextPersonName2);
        cid2=findViewById(R.id.editTextNumber5);
        pay = new Payment_data();


    }
    public void datasave(View v){
        int day1 = simpleDatePicker.getDayOfMonth();
        int month1 = simpleDatePicker.getMonth();
        int year1 =   simpleDatePicker.getYear();


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        myRef = database.getReference("Payment");
        try {
            if (TextUtils.isEmpty(name.getText().toString()))
                Toast.makeText(getApplicationContext(), "pleae enter id", Toast.LENGTH_SHORT).show();
            else if (TextUtils.isEmpty(amount.getText().toString()))
                Toast.makeText(getApplicationContext(), "pleae enter amount", Toast.LENGTH_SHORT).show();
            else if (TextUtils.isEmpty(String.valueOf(day1+"."+month1+"."+year1))) {
                Toast.makeText(getApplicationContext(), "pleae enter date", Toast.LENGTH_SHORT).show();
            } else if (TextUtils.isEmpty(cid.getText().toString()))
                Toast.makeText(getApplicationContext(), "pleae enter cid", Toast.LENGTH_SHORT).show();
            else if (TextUtils.isEmpty(Cardtype.getText().toString()))
                Toast.makeText(getApplicationContext(), "pleae enter cardtype", Toast.LENGTH_SHORT).show();
            else {
                pay.setName(name.getText().toString().trim());
                pay.setAmount(Float.parseFloat(amount.getText().toString().trim()));

                pay.setCid(Integer.parseInt(cid.getText().toString().trim()));
                pay.setCardtype(Cardtype.getText().toString().trim());
                pay.setDate2(String.valueOf(day1+"."+month1+"."+year1).trim());





                myRef.child(cid.getText().toString()).setValue(pay);
                Toast.makeText(getApplicationContext(), "succesfully data saved", Toast.LENGTH_SHORT).show();
            }
        } catch (NumberFormatException e) {
            Toast.makeText(getApplicationContext(), "invalid number", Toast.LENGTH_SHORT).show();

        }

    }


    public void Display(View a) {

   Intent intent = new Intent(this,Display_Payment.class);
   String masseage= cid2.getText().toString();
   intent.putExtra(EXTRA_MESSAGE, masseage);
   startActivity(intent);

    }
        public void update(View v2){
            final int day = simpleDatePicker.getDayOfMonth();
            final int month = simpleDatePicker.getMonth();
            final int year =   simpleDatePicker.getYear();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
DatabaseReference myRef3 = FirebaseDatabase.getInstance().getReference().child("Payment");

        myRef3.addValueEventListener(new ValueEventListener() {

            public void onDataChange(@NonNull DataSnapshot snapshot) {

                pay.setName(name.getText().toString().trim());
                pay.setAmount(Float.parseFloat(amount.getText().toString().trim()));
                pay.setDate2(String.valueOf(day+"."+month+"."+year).trim());
                pay.setCid(Integer.parseInt(cid.getText().toString().trim()));
                pay.setCardtype(Cardtype.getText().toString().trim());


                myRef=FirebaseDatabase.getInstance().getReference().child("Payment").child(cid.getText().toString());
                myRef.setValue(pay);
                Toast.makeText(getApplicationContext(), "updated successfully", Toast.LENGTH_SHORT).show();
            }

            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }


}
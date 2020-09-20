package com.example.mad_2020_inventers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Payment extends AppCompatActivity {
    EditText id, amount, date, cid, Cardtype;
    DatabaseReference myRef;
    Payment_data pay;
    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        id = findViewById(R.id.editTextNumber4);
        amount = findViewById(R.id.editTextNumber);
        date = findViewById(R.id.editTextDate);
        cid = findViewById(R.id.editTextNumber2);
        Cardtype = findViewById(R.id.editTextTextPersonName2);
        pay = new Payment_data();

    }
    public void datasave(View v){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        myRef = database.getReference("Payment");
        try {
            if (TextUtils.isEmpty(id.getText().toString()))
                Toast.makeText(getApplicationContext(), "pleae enter id", Toast.LENGTH_SHORT).show();
            else if (TextUtils.isEmpty(amount.getText().toString()))
                Toast.makeText(getApplicationContext(), "pleae enter amount", Toast.LENGTH_SHORT).show();
            else if (TextUtils.isEmpty(date.getText().toString())) {
                Toast.makeText(getApplicationContext(), "pleae enter date", Toast.LENGTH_SHORT).show();
            } else if (TextUtils.isEmpty(cid.getText().toString()))
                Toast.makeText(getApplicationContext(), "pleae enter cid", Toast.LENGTH_SHORT).show();
            else if (TextUtils.isEmpty(Cardtype.getText().toString()))
                Toast.makeText(getApplicationContext(), "pleae enter cardtype", Toast.LENGTH_SHORT).show();
            else {
                pay.setId(Integer.parseInt(id.getText().toString().trim()));
                pay.setAmount(Float.parseFloat(amount.getText().toString().trim()));
                pay.setDate(date.getText().toString().trim());
                pay.setCid(Integer.parseInt(cid.getText().toString().trim()));
                pay.setCardtype(Cardtype.getText().toString().trim());


                myRef.push().setValue(pay);
                Toast.makeText(getApplicationContext(), "succesfully data saved", Toast.LENGTH_SHORT).show();
            }
        } catch (NumberFormatException e) {
            Toast.makeText(getApplicationContext(), "invalid number", Toast.LENGTH_SHORT).show();

        }
    }
}
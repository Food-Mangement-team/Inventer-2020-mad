package com.example.mad_2020_inventers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Payment extends AppCompatActivity {
    EditText id, amount, date, cid, Cardtype;
    DatabaseReference myRef;
    Payment_data pay;
    Payment_data pay1;

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
        pay1 = new Payment_data();

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



                myRef.child("pay1").setValue(pay);
                Toast.makeText(getApplicationContext(), "succesfully data saved", Toast.LENGTH_SHORT).show();
            }
        } catch (NumberFormatException e) {
            Toast.makeText(getApplicationContext(), "invalid number", Toast.LENGTH_SHORT).show();

        }
    }


    public void Display(View a) {

   Intent intent = new Intent(this,Display_Payment.class);
   startActivity(intent);

    }
        public void update(View v2){

        FirebaseDatabase database = FirebaseDatabase.getInstance();
DatabaseReference myRef3 = FirebaseDatabase.getInstance().getReference().child("Payment");

        myRef3.addValueEventListener(new ValueEventListener() {

            public void onDataChange(@NonNull DataSnapshot snapshot) {

                pay.setId(Integer.parseInt(id.getText().toString().trim()));
                pay.setAmount(Float.parseFloat(amount.getText().toString().trim()));
                pay.setDate(date.getText().toString().trim());
                pay.setCid(Integer.parseInt(cid.getText().toString().trim()));
                pay.setCardtype(Cardtype.getText().toString().trim());


                myRef=FirebaseDatabase.getInstance().getReference().child("Payment").child("pay1");
                myRef.setValue(pay);
                Toast.makeText(getApplicationContext(), "updated successfully", Toast.LENGTH_SHORT).show();
            }

            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    /* Intent intent = new Intent(this, Update_Payment.class);
         intent.putExtra("id",id.getText().toString());
         intent.putExtra("amount",amount.getText().toString());
         intent.putExtra("date",date.getText().toString());

         startActivity(intent);*/
    public void delete(View delete) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference deleteref = database.getReference("Payment");
        deleteref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.hasChild("pay1")) {

                    myRef=FirebaseDatabase.getInstance().getReference().child("Payment").child("pay1");
                    myRef.removeValue();
                    Toast.makeText(getApplicationContext(), "deleted successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "no source to show", Toast.LENGTH_SHORT).show();
                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}
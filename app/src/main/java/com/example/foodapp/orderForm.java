package com.example.foodapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class orderForm extends AppCompatActivity {

    EditText txtorderName,txtQuantity,txtPaymentMethod,name;
    DatabaseReference dbRef;
    Button confirm,UPDATE,SHOWTHEORDER;
    public static final String EXTRA_MESSAGE = "com.example.foodapp.MESSAGE";

    private OrderItemListClass ord;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_form);

        txtorderName = (EditText) findViewById(R.id.itemName);
        txtQuantity = (EditText) findViewById(R.id.Quantity);
        txtPaymentMethod = (EditText) findViewById(R.id.method);
        confirm = (Button) findViewById(R.id.button3);
        UPDATE = (Button) findViewById(R.id.button9);

        SHOWTHEORDER = (Button) findViewById(R.id.button5);
        name =( EditText)(findViewById(R.id.editTextTextPersonName2));


        ord = new OrderItemListClass();
        dbRef = FirebaseDatabase.getInstance().getReference().child("OrderItemListClass");
        confirm.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {

                try {
                    if (TextUtils.isEmpty(txtorderName.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please enter item name", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(txtQuantity.getText().toString()))
                        Toast.makeText(getApplicationContext(), "please enter a quantity", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(txtPaymentMethod.getText().toString()))
                        Toast.makeText(getApplicationContext(), "please enter a payment method", Toast.LENGTH_SHORT).show();
                    else {
                        ord.setItemName(txtorderName.getText().toString().trim());
                        ord.setQuantity(Integer.parseInt(txtQuantity.getText().toString().trim()));
                        ord.setPaymentMethod(txtPaymentMethod.getText().toString().trim());

                        dbRef.child(txtorderName.getText().toString()).setValue(ord);

                        Toast.makeText(getApplicationContext(), "data entered successfully", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

                    Intent i = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(i);
                }


        });
        UPDATE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef3 = FirebaseDatabase.getInstance().getReference().child("OrderItemListClass");

                myRef3.addValueEventListener(new ValueEventListener() {

                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        ord.setItemName(txtorderName.getText().toString().trim());
                        ord.setQuantity(Integer.parseInt(txtQuantity.getText().toString().trim()));
                        ord.setPaymentMethod(txtPaymentMethod.getText().toString().trim());


                        dbRef=FirebaseDatabase.getInstance().getReference().child("OrderItemListClass").child(txtorderName.getText().toString());
                        dbRef.setValue(ord);
                        Toast.makeText(getApplicationContext(), "updated successfully", Toast.LENGTH_SHORT).show();
                    }

                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });



            }
        });



        SHOWTHEORDER.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(orderForm.this,orderList.class);
                String masg = name.getText().toString();
                intent.putExtra(EXTRA_MESSAGE,masg);
                startActivity(intent);
            }
        });



    }


}

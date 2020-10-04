package com.example.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UpdateOrder extends AppCompatActivity {

    EditText txtName,txtQuantity,txtPaymentMethod;
    DatabaseReference dbRef;
    Button update;
    private OrderItemListClass ord;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_order);
        ord = new OrderItemListClass();



        txtName = (EditText) findViewById(R.id.editTextTextPersonName4);
        txtQuantity = (EditText) findViewById(R.id.Quantity);
        txtPaymentMethod = (EditText) findViewById(R.id.method);
        update = (Button) findViewById(R.id.button8);
        ord = new OrderItemListClass();
        dbRef = FirebaseDatabase.getInstance().getReference().child("OrderItemListClass");


    }



  public void onDataChange(DataSnapshot dataSnapshot){
        if (dataSnapshot.hasChild("ord")){
            try{
                ord.setItemName(txtName.getText().toString().trim());
                ord.setQuantity(Integer.parseInt(txtQuantity.getText().toString().trim()));
                ord.setPaymentMethod(txtPaymentMethod.getText().toString().trim());
                dbRef = FirebaseDatabase.getInstance().getReference().child("OrderItemListClass");

                dbRef.setValue(ord);
                Toast.makeText(getApplicationContext(), "data updated successfully", Toast.LENGTH_SHORT).show();

            } catch (Exception e) {
                e.printStackTrace();
            }

            Intent i = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(i);
        }


};

}

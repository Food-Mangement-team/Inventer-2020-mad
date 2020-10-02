package com.example.mad_2020_inventers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

public class orderList extends AppCompatActivity {


    TextView txtName1, txtQuantity1, txtPaymentMethod1;

    String name;
    private OrderItemListClass ord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_list);
        Intent intent= getIntent();
        name = intent.getStringExtra(orderForm.EXTRA_MESSAGE);
        txtName1 = findViewById(R.id.textView27);
        txtQuantity1 = findViewById(R.id.textView28);
        txtPaymentMethod1 = findViewById(R.id.textView29);



        FirebaseDatabase database = FirebaseDatabase.getInstance();
        Query q1 = database.getReference("OrderItemListClass").child(name);
        q1.addValueEventListener(valueEventListener);
    }



    //DatabaseReference readRef = FirebaseDatabase.getInstance().getReference().child("OrderItemListClass"");
    // readRef.addListenerForSingleValueEvent(new ValueEventListener() {
    //
    ValueEventListener valueEventListener = new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot snapshot) {
            if(snapshot.hasChildren()) {
                txtName1.setText(snapshot.child("itemName").getValue().toString());
                txtQuantity1.setText(snapshot.child("quantity").getValue().toString());
                txtPaymentMethod1.setText(snapshot.child("paymentMethod").getValue().toString());
            }else{
                Toast.makeText(getApplicationContext(),"No source to display",Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        public void onCancelled(@NonNull DatabaseError error) {

        }
    };

    public void delete(View view1){
        DatabaseReference refdel;
        refdel = FirebaseDatabase.getInstance().getReference("OrderItemListClass").child(name);
        refdel.removeValue();
        Toast.makeText(getApplicationContext(),"Deleted successfully",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,orderForm.class);
        startActivity(intent);

    }

}



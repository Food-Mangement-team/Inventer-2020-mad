package com.example.mad_2020_inventers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Pizza extends AppCompatActivity {
    Button ADD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza);
        ADD = (Button) findViewById(R.id.button18);
        ADD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),orderForm.class);
                startActivity(i);
                Toast.makeText(getApplicationContext(),"success",Toast.LENGTH_SHORT).show();
            }
        });
    }
}

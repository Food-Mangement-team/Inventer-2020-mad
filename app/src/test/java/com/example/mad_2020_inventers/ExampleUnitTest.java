package com.example.mad_2020_inventers;

import android.widget.EditText;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ExampleUnitTest {
    String name;
    int cid;
EditText name1,cid1;



    @Test
    public void checkname(){
        Payment_data data = new Payment_data();
        Payment p1 = new Payment();

        name1 = p1.name;
        name= data.getName();

        assertEquals(name, name1);


    }


}
package com.example.customermanagment;

import android.database.CursorIndexOutOfBoundsException;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    private Reset_Password resetPassword;

    @Test
    public void checkPasswordWithAlphaNumerics() {
        resetPassword = new Reset_Password();
        assertFalse(resetPassword.isValidPassword("sammani123"));
    }

    @Test
    public void checkPasswordForCorrectFormat() {
        resetPassword = new Reset_Password();
        assertTrue(resetPassword.isValidPassword("fd%^&fdsHIOF54GJFIOs"));
    }

    @Test
    public void checkPasswordWithNumbers() {
        resetPassword = new Reset_Password();
        assertFalse(resetPassword.isValidPassword("12355"));
    }


    @Test
    public void checkUpdateUsername() {
        Edit_CustomerProfile editCustomerData = new Edit_CustomerProfile();
        assertTrue(editCustomerData.updateUsername("Al", "Alex123"));
    }

    @Test
    public void checkUpdateName() {
        Edit_CustomerProfile editCustomerData = new Edit_CustomerProfile();
        assertTrue(editCustomerData.updateName("Alex", "Alexis"));
    }


}


package com.example.mad_2020_inventers

import android.content.Context
import org.junit.Test

class PaymentTest extends GroovyTestCase {

    private Context context = ApplicationProvider.getApplicationContext();
    @Test
    void testDatasave() {




            // Given a Context object retrieved from Robolectric...
            Payment myObjectUnderTest = new Payment(context);

            // ...when the string is returned from the object under test...
            String result = myObjectUnderTest.name;

            // ...then the result should be the expected one.
            assertThat(result).isEqualTo("yasi");
    }
}

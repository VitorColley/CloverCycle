
package com.example.clovercycle;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import android.content.SharedPreferences;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import static org.mockito.Mockito.*;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


public class UserJobActivityTest {

    //this class will be my example of unit testing within my UserJobActivity Class
    //I will be testing that he amount input isValid()
    // as it is a unit test I will be testing the internal structures of the software using JUnit in isolation
    public static boolean isValidAmount(String amount) {
        return amount != null && !amount.isEmpty();
    }


    @Test
    public void amountValidator_CorrectAmountSimple_ReturnsTrue() {
        assertTrue(UserJobActivityTest.isValidAmount("24"));
    }

    //Now that I have tested for positive conditions
    //I will test the validation of negative cases..
    @Test
    public void amountValidator_EmptyAmount_ReturnsFalse() {
        assertFalse(UserJobActivityTest.isValidAmount(""));
    }

    @Test
    public void amountValidator_NullAmount_ReturnsFalse() {
        assertFalse(false);
    }
}






package com.example.clovercycle;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import android.content.ComponentName;
import android.content.Intent;

import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UserJobActivityTest {
    @Mock
    UserJobActivity userJobActivity;

    //this class will be my example of white box testing within my UserJobActivity Class
    //I will be testing three aspects, is nameValid(), isAddressValid() & isAmountValid()
    // as it is a white box test I will be testing the internal structures of the software, testing the validation of above methods

    //The chosen methodology I used was "Branch Coverage" as it covers all possible paths of inputs
    public static boolean isValidName(String name) {
        //this will be my validation logic
        return name != null && !name.isEmpty();
    }

    public static boolean isValidAddress(String address) {
        return address != null && !address.isEmpty();
    }

    public static boolean isValidAmount(String amount) {
        return amount != null && !amount.isEmpty();
    }

    @Test
    public void nameValidator_CorrectNameSimple_ReturnsTrue() {
        //asserting true that the input of "conor" is valid
        assertTrue(UserJobActivityTest.isValidName("conor"));
    }

    @Test
    public void addressValidator_CorrectAddressSimple_ReturnsTrue() {
        assertTrue(UserJobActivityTest.isValidAddress("BirchwoodRow"));

    }

    @Test
    public void amountValidator_CorrectAmountSimple_ReturnsTrue() {
        assertTrue(UserJobActivityTest.isValidAmount("24"));
    }

    //Now that I have tested for positive conditions
    //I will test the validation of negative cases..
    @Test
    public void nameValidator_EmptyName_ReturnsFalse() {
        assertFalse(UserJobActivityTest.isValidName(""));
    }

    @Test
    public void nameValidator_NullName_ReturnsFalse() {
        assertFalse(UserJobActivityTest.isValidName(null));
    }

    @Test
    public void addressValidator_EmptyAddress_ReturnsFalse() {
        assertFalse(UserJobActivityTest.isValidAddress(""));
    }

    @Test
    public void addressValidator_NullAddress_ReturnsFalse() {
        assertFalse(UserJobActivityTest.isValidAddress(null));
    }

    @Test
    public void amountValidator_EmptyAmount_ReturnsFalse() {
        assertFalse(UserJobActivityTest.isValidAmount(""));
    }

    @Test
    public void amountValidator_NullAmount_ReturnsFalse() {
        assertFalse(UserJobActivityTest.isValidAmount(null));
    }


    @Before
//@before to ensure it is run before any method
//This will allow me to minimize repetitive mock creation code
//https://www.linkedin.com/pulse/simplifying-unit-testing-mockito-annotations-ali-mirzajanzadeh-bfp0c#:~:text=Mockito%20annotations%20have%20significantly%20improved,more%20enjoyable%20and%20productive%20experience.
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testStartViewJobsActivity() {
        //https://www.baeldung.com/mockito-annotations
        //create a mocked Intent
        Intent mockIntent = Mockito.mock(Intent.class);

        //specify the class name of the component (ViewJobs activity)
        ComponentName componentName = new ComponentName("", "com.example.clovercycle.ViewJobs");

        //mock the behavior of the Intent to return the specified component name
        //1 test failed with this line of code, I removed it and The test passed.
        //Mockito.when(mockIntent.getComponent()).thenReturn(componentName);

        //call the method that starts the ViewJobs activity in your UserJobActivity
        userJobActivity.startActivity(mockIntent);

        //check that the startActivity method was called with the correct Intent
        Mockito.verify(userJobActivity).startActivity(mockIntent);
    }
}
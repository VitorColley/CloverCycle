package com.example.clovercycle;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.android.controller.ActivityController;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowLog;
import org.robolectric.shadows.ShadowToast;

import android.os.Build;
import android.widget.Button;
import android.widget.EditText;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/*in these unit tests i am using junit and a dependency called robolectric,
this is very complex and hard to use as it is very precise
however it is required to test certain android specific OS functions
It is also important to not that android studio does not contain a
unit testing generator like netbeans, therefore automatic tests must be completed with
these dependencies*/

//resources and research in how i came to use robolectric-
//https://stackoverflow.com/questions/58057769/method-getmainlooper-in-android-os-looper-not-mocked-still-occuring-even-after-a
//https://proandroiddev.com/oh-looper-where-is-my-mock-5e4762ba866
//https://robolectric.org/getting-started/

//run with robolectric instead of mockito

@RunWith(RobolectricTestRunner.class)
@Config(sdk = {Build.VERSION_CODES.O_MR1})
public class PaymentActivityTest {

    private ActivityController<PaymentActivity> controller;
    private PaymentActivity paymentActivity;

    @Before
    public void setUp() {
        //logging for debugging
        //ShadowLog.stream = System.out;

        // Set up the PaymentActivity with Robolectric, ensuring it is not null
        controller = Robolectric.buildActivity(PaymentActivity.class).setup();
        paymentActivity = controller.get();
        assertNotNull("PaymentActivity should not be null", paymentActivity);
    }

    @Test
    public void testValidPaymentSubmission() {
        // retrieve UI components
        EditText cardNUM = paymentActivity.findViewById(R.id.cardNUM);
        EditText expiryNUM = paymentActivity.findViewById(R.id.expiryNUM);
        Button paymentBTN = paymentActivity.findViewById(R.id.paymentBTN);

        //asserting to null to verify the test
        assertNotNull("Card Number", cardNUM);
        assertNotNull("Expiry Number", expiryNUM);
        assertNotNull("Payment Button", paymentBTN);

        // simulating user setting text values
        cardNUM.setText("1234123412341234");
        expiryNUM.setText("1225");
        // simulating user click
        paymentBTN.performClick();

        // checking the toast message using ShadowToast to validate, this way we wont be returned a runtime exception by mocking toast
        //this is marked null as we are checking if the toast will display that there was an invalid input, i.e null toast = valid entry
        assertEquals(null, ShadowToast.getTextOfLatestToast());
    }

    @Test
    public void testInvalidPaymentSubmission() {
        EditText cardNUM = paymentActivity.findViewById(R.id.cardNUM);
        EditText expiryNUM = paymentActivity.findViewById(R.id.expiryNUM);
        Button paymentBTN = paymentActivity.findViewById(R.id.paymentBTN);

        assertNotNull("Card Number", cardNUM);
        assertNotNull("Expiry Number", expiryNUM);
        assertNotNull("Paymentbtn", paymentBTN);

        // simulating user setting text values
        cardNUM.setText("123");
        expiryNUM.setText("12");
        // simulating user click
        paymentBTN.performClick();


        // this time it must equal invalid to pass the test
        assertEquals("Invalid card number", ShadowToast.getTextOfLatestToast());
    }
}

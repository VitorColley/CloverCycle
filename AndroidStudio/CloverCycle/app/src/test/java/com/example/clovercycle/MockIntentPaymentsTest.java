package com.example.clovercycle;

import android.content.Intent;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
/*Mockito is a framework that allows us to run unit tests in android studio
as android studio requires you to imitate the unique functionalities
 it offers in java design */
//resource for running local tests in android studio
//https://developer.android.com/training/testing/local-tests
@RunWith(MockitoJUnitRunner.class)
public class MockIntentPaymentsTest {

    @Mock
    PaymentActivity paymentActivity;
    @Mock
    PaymentHistoryActivity paymentHistoryActivity;
    @Mock
    UserJobActivity userJobActivity;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    //declare test
    @Test
    public void testNavToPayment() {
        //here we "emulate" the ui function (button) with the android
        // intent feature that redirects to an activity
        //this intent brings the user to the payment activity
        Intent mockPaymentIntents = Mockito.mock(Intent.class);
        paymentActivity.startActivity(mockPaymentIntents);
        Mockito.verify(paymentActivity).startActivity(mockPaymentIntents);
    }
    @Test
    public void testNavToHistory() {
        //this intent brings the user to the payment history activity
        Intent mockHistoryIntent = Mockito.mock(Intent.class);
        paymentHistoryActivity.startActivity(mockHistoryIntent);
        Mockito.verify(paymentHistoryActivity).startActivity(mockHistoryIntent);
    }
    @Test
    public void testNavBackToJobs() {
        /* this intent brings the user back to the jobs from
         both the payment and payment history activities */
        Intent mockLogoutIntent = Mockito.mock(Intent.class);
        userJobActivity.startActivity(mockLogoutIntent);
        Mockito.verify(userJobActivity).startActivity(mockLogoutIntent);
    }
}

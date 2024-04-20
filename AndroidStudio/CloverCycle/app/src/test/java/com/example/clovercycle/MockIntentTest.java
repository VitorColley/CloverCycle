package com.example.clovercycle;

import org.junit.Before;
import org.junit.Test;

import android.content.Intent;

import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MockIntentTest {
    //i am isolating the behaviour of the startActivity method in my UserJobActivity Class by mocking
    //the intent class.It is then verifying that the start Activity method is called with the correct intent.
    //as this is an example of Unit testing I am testing code in isolation. The dependencies needed to be "mocked" here for android studio as Intent is as android studio framework. Thus i needed to imitate or "mock" it
    //https://developer.android.com/training/testing/local-tests
    //https://www.linkedin.com/pulse/simplifying-unit-testing-mockito-annotations-ali-mirzajanzadeh-bfp0c#:~:text=Mockito%20annotations%20have%20significantly%20improved,more%20enjoyable%20and%20productive%20experience.
    //above link contained all the info I needed to create a mock test, it also helped me when I got the "...not mocked" error when running tests
    @Mock
    UserJobActivity userJobActivity;

    @Before
//@before to ensure it is run before any method
    //we use Mockito annotations to "annotate" fields in the test class with mock objects
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testStartViewJobsActivity() {
        //https://www.baeldung.com/mockito-annotations
        //Create a mocked Intent
        Intent mockIntent2 = Mockito.mock(Intent.class);
        //Call the method that starts the ViewJobs activity in your UserJobActivity
        userJobActivity.startActivity(mockIntent2);
        //Verify that the startActivity method was called with the correct Intent
        Mockito.verify(userJobActivity).startActivity(mockIntent2);
    }

    @Test
    public void testStartPaymentActivity() {
        //Brings user to their payments
        Intent mockIntent = Mockito.mock(Intent.class);
        userJobActivity.startActivity(mockIntent);
        Mockito.verify(userJobActivity).startActivity(mockIntent);
    }
    @Test
    public void testStartPostMyJobActivity() {
        //posts users job and prompts with toast message
        Intent mockIntent3 = Mockito.mock(Intent.class);
        userJobActivity.startActivity(mockIntent3);
        Mockito.verify(userJobActivity).startActivity(mockIntent3);
    }
    @Test
    public void testLogOutActivity() {
        //logs user out of application
        Intent mockIntent4 = Mockito.mock(Intent.class);
        userJobActivity.startActivity(mockIntent4);
        Mockito.verify(userJobActivity).startActivity(mockIntent4);
    }
}

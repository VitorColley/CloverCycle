package com.example.clovercycle;

import static org.bouncycastle.math.ec.rfc8032.Ed25519.verify;
import static org.mockito.Mockito.when;

import android.content.Intent;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class IntentTest {
    @Mock
    MainActivity mainActivity;
    DatabaseSqlite dbHelper;
    @Before
    public void setUp() {

        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void testActivityHandler() {
        Intent mockIntent = Mockito.mock(Intent.class);
        mainActivity.startActivity(mockIntent);
        Mockito.verify(mainActivity).startActivity(mockIntent);
    }
}


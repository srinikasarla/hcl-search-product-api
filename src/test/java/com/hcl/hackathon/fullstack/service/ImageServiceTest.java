package com.hcl.hackathon.fullstack.service;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ImageServiceTest {

    ImageService subject;

    @Before
    public void setUp() {
        subject = new ImageService();
    }

    @Test
    public void populateImageBytes_returnsFileValueAsBase64String() {
        String result = subject.populateImageBytes("test-file.txt");

        assertEquals("VGhpcyBmaWxlIGlzIGludGVuZGVkIHRvIHRlc3QgSW1hZ2VTZXJ2aWNlCg==", result);
    }

    @Test
    public void populateImageBytes_throwsException_whenIOExceptionOccur() {
        assertNull(subject.populateImageBytes("nonexistingfile"));
    }
}

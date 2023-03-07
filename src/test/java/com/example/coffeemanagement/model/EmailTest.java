package com.example.coffeemanagement.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailTest {

    @Test   //오류가 발생해야 정상
    public void testInvalidEmail() {
        assertThrows(IllegalAccessException.class, () -> {
            var email = new Email("acccc");
        });
    }

    @Test
    public void testValidEmail() {
        var email = new Email("hello@gmail.com");
        assertTrue(email.getAddress().equals("hello@gmail.com"));
    }

    @Test
    public void testEqEmail() {
        var email1 = new Email("helloworld@gmail.com");
        var email12 = new Email("helloworld@gmail.com");
        assertTrue(email1.equals(email12));
    }

}
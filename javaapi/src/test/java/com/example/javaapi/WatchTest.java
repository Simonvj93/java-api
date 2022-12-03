package com.example.javaapi;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class WatchTest {
    // test Watch.java

    @Test
    public void testCreationOfWatch() {
        Watch watch = new Watch();
        watch.setId(5);
        watch.setName("Fitbit");
        watch.setPrice(1000);
        assertEquals(5, watch.getId());
        assertEquals("Fitbit", watch.getName());
        assertEquals(1000, watch.getPrice());
    }
}

package tasks.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class SoupServingsTest {

    public static final SoupServings INST = new SoupServings();

    @Test
    public void soupServings() {
        assertEquals(0.625, INST.soupServings(50), 0.00001);
    }
}
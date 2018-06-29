package tasks.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class LargestSumOfAveragesTest {

    @Test
    public void largestSumOfAverages() {
        assertEquals(167436.08333333334, LargestSumOfAverages.largestSumOfAverages(new int[] {4663,3020,7789,1627,9668,1356,4207,1133,8765,4649,205,6455,8864,3554,3916,5925,3995,4540,3487,5444,8259,8802,6777,7306,989,4958,2921,8155,4922,2469,6923,776,9777,1796,708,786,3158,7369,8715,2136,2510,3739,6411,7996,6211,8282,4805,236,1489,7698}, 27), 1e-9);
    }

}
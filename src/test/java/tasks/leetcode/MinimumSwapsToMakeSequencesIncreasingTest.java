package tasks.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class MinimumSwapsToMakeSequencesIncreasingTest {

    public static final MinimumSwapsToMakeSequencesIncreasing INST = new MinimumSwapsToMakeSequencesIncreasing();

    @Test
    public void minSwapTest1() {
        assertEquals(1, INST.minSwap(new int[]{1,3,5,4}, new int[]{1,2,3,7}));
    }

    @Test
    public void minSwapTest2() {
        assertEquals(1, INST.minSwap(new int[]{0,4,4,5,9}, new int[]{0,1,6,8,10}));
    }

    @Test
    public void minSwapTest3() {
        assertEquals(1, INST.minSwap(new int[]{3,3,8,9,10}, new int[]{1,7,4,6,8}));
    }

    @Test
    public void minSwapTest4() {
        assertEquals(1, INST.minSwap(new int[]{0,3,5,8,9}, new int[]{2,1,4,6,9}));
    }

    @Test
    public void minSwapTest5() {
        assertEquals(1, INST.minSwap(new int[]{3,3,8,9,10}, new int[]{1,7,4,6,8}));
    }

    @Test
    public void minSwapTest6() {
        int a[] = new int[]{4,10,13,14,17,19,21,24,26,27,28,29,34,37,38,42,44,46,48,51,52,53,54,57,58,59,64,65,66,67,71,73,75,76,80,81,82,83,86,88,89,90,95,97,98,99,101,105,106,108,109,110,111,112,115,119,121,122,123,124,125,126,127,128,129,130,131,133,136,138,143,145,147,149,150,153,158,160,163,164,165,167,168,169,172,173,174,176,178,179,183,184,186,188,189,192,193,194,198,200};
        int b[] = new int[]{0,1,3,5,6,7,11,13,15,16,17,21,37,39,41,42,43,45,47,50,53,55,56,57,64,66,67,68,69,70,71,72,74,75,76,77,79,80,87,88,89,95,96,97,98,100,101,105,106,107,108,112,113,115,116,118,119,122,124,125,126,127,128,131,135,136,137,138,139,140,144,145,148,150,151,154,159,160,161,162,163,167,168,170,171,174,176,178,179,180,181,185,187,189,190,191,192,198,199,200};
        INST.minSwap(a, b);
    }
}
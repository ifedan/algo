package tasks.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class ChalkboardXORGameTest {

    public static final ChalkboardXORGame CHALKBOARD_XOR_GAME_TEST = new ChalkboardXORGame();

    @Test
    public void xorGame() {
        //assertEquals(false, CHALKBOARD_XOR_GAME_TEST.xorGame(new int[]{1, 1, 2}));
        //assertEquals(true, CHALKBOARD_XOR_GAME_TEST.xorGame(new int[]{0, 1}));
        assertEquals(true, CHALKBOARD_XOR_GAME_TEST.xorGame(new int[]{1,2,3}));
    }
}
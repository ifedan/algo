package tasks.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class AddTwoNumbersTest {

    @Test
    public void sum() {
        assertEquals(new AddTwoNumbers.ListNode(3), AddTwoNumbers.sum(new AddTwoNumbers.ListNode(1), new AddTwoNumbers.ListNode(2)));
    }

}
package tasks.leetcode;

import java.util.LinkedList;

public class CountAndSay {

    private static class Count {
        char c;
        int count = 1;
        Count(char ch) {this.c = ch;}
    }

    public static String countAndSay(int n) {
        int c = 1;
        String val = "1";
        LinkedList<Count> queue = new LinkedList<Count>();

        while (c < n) {
            for (int i = 0; i < val.length(); i ++) {
                if (queue.isEmpty()) {
                    queue.add(new Count(val.charAt(i)));
                } else {
                    Count count = queue.getLast();
                    if (count.c == val.charAt(i)) {
                        count.count++;
                    } else {
                        queue.add(new Count(val.charAt(i)));
                    }
                }
            }
            val = "";
            while (!queue.isEmpty()) {
                Count count = queue.poll();
                val = val + count.count;
                val = val + (char)count.c;
            }
            c++;
        }
        return val;
    }

}

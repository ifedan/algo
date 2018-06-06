package tasks.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SplitArrayIntoFibonacciSequence {
    public static List<Integer> splitIntoFibonacci(String S) {
        List<Integer> result = new ArrayList<>();
        splitIntoFibonacci(S, 0, result);
        return result;
    }

    public static boolean splitIntoFibonacci(String str, int start, List<Integer> result) {
        if (start >= str.length()) return result.size() > 2;
        for (int size = 1; size <= str.length() - start; size++) {
            if (size > 1 && str.charAt(start) == '0') return false;
            long l = Long.parseLong(str.substring(start, start + size));
            if (l > Integer.MAX_VALUE) return false;
            int num = (int)l;
            //int rest = Integer.parseInt(str.substring(start + size));
            //if (num > rest) return false;
            if (result.size() < 2) {
                result.add(num);
            } else {
                int n1 = result.get(result.size()-1);
                int n2 = result.get(result.size()-2);
                if (n1 + n2 == num) {
                    result.add(num);
                } else if (n1 + n2 > num) {
                    continue;
                } else {
                    return false;
                }
            }
            if (splitIntoFibonacci(str, start + size, result)) {
                return true;
            } else {
                result.remove(result.size() - 1);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        splitIntoFibonacci("1011");
    }
}

package tasks.leetcode;

public class CountNumbersWithUniqueDigits {
    
    //f(4) = a(4,10)-a(3,9)+a(3,10)-a(2,9)+a(2,10)-a(1,9)+a(1,10)-a(0,9)+a(0,10) 
    public int countNumbersWithUniqueDigits(int n) {
        if (n > 10) return 0;
        if (n == 0) return 1;
        int prev = 9;
        int res = prev;
        for (int i = 1; i < n; i++) {
            int newprev = prev * (10 - i);
            res += newprev;
            prev = newprev;
        }
        return res + 1;
    }
    
    
}

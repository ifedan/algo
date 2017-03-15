public class IntegerReplacement {
    public int integerReplacement(int n) {
        int count = 0;
        while (n != 1) {
            if (n == 2) return count + 1;
            if (n == 3) return count + 2;
            if ((n&(n-1)) == 0) return count + (31 - Integer.numberOfLeadingZeros(n));
            
            if (n%2 == 0) n = n/2;
            else {
                if (((n-1)/2)%2 == 0) {
                    n = n-1;
                } else {
                    n = n+1;
                }
            }
            count++;
        }
        return count;
    }
}

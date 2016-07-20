package tasks.array;

public class MaxProductSubarray {

    public static int solve(int[] a) {
        int minHere = a[0];
        int maxHere = a[0];
        int maxProduct = a[0];

        for (int i = 1; i < a.length; i++) {
            int temp = maxHere;
            maxHere = Math.max(a[i], Math.max(a[i]*minHere, a[i]*maxHere));
            minHere = Math.min(a[i], Math.min(a[i]*minHere, a[i]*temp));
            maxProduct = Math.max(maxProduct, maxHere);
        }

        return maxProduct;
    }

}

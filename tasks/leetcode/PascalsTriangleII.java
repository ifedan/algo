package tasks.leetcode;

public class PascalsTriangleII {


    public static int[] generate(int rowIndex) {
        int t[] = new int[rowIndex+1];
        t[0] = 1;
        for(int i=1; i<rowIndex+1; i++)
            for(int j=i; j>=1; j--)
                t[j] += t[j-1];
        return t;
    }

    public static void main(String[] args) {
        generate(6);
    }
}

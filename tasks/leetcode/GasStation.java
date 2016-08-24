package tasks.leetcode;

public class GasStation {

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int start = gas.length;
        int end = 0;
        int sum = 0;
        do {
            if (sum > 0) {
                sum += (gas[end] - cost[end]);
                end++;
            } else {
                start--;
                sum += (gas[start] - cost[start]);
            }
        } while (start > end);
        return sum >= 0 ? start : -1;
    }

    public static void main(String[] args) {
        canCompleteCircuit(new int[]{2,3,1}, new int[]{3,1,2});
    }

}

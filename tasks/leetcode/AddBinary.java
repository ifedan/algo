package tasks.leetcode;

public class AddBinary {


    public static String addBinary(String a, String b) {
        int i = 0;
        boolean extra = false;
        StringBuilder result = new StringBuilder();

        while (a.length() - i > 0 || b.length() - i > 0) {
            int x = 0;
            if (a.length() - i > 0) {
                x = Character.getNumericValue(a.charAt(a.length() - i - 1));
            }
            int y = 0;
            if (b.length() - i > 0) {
                y = Character.getNumericValue(b.charAt(b.length() - i - 1));
            }

            int sum = x + y;
            if (extra) {
                sum += 1;
                extra = false;
            }

            if (sum >= 2) {
                sum -= 2;
                extra = true;
            }

            result.insert(0, sum);
            i++;
        }

        if (extra) {
            result.insert(0, 1);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        addBinary("11", "1");
    }

}

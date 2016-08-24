package tasks.leetcode;

import java.util.List;

public class Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 1) return triangle.get(0).get(0);

        for (int i = triangle.size()-2; i >= 0; i--) {
            List<Integer> row = triangle.get(i);
            for(int j = 0; j < row.size(); j++) {
                row.set(j, row.get(j) + Math.min(triangle.get(i+1).get(j), triangle.get(i+1).get(j+1)));
            }
        }
        return triangle.get(0).get(0);
    }

}

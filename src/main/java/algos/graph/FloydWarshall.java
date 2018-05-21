package algos.graph;

/**
 * O(V^3)
 */
public class FloydWarshall {

    public int[][] gteShortestPath(int[][] adjMatrix) {
        int vCount = adjMatrix.length;
        int[][] dest = new int[vCount][vCount];
        for (int i = 0; i < vCount; i++) {
            for (int j = 0; j < vCount; j++) {
                dest[i][j] = adjMatrix[i][j];
            }
        }

        for (int i = 0; i < vCount; i++) {
            for (int j = 0; j < vCount; j++) {
                for (int k = 0; k < vCount; k++) {
                    if (dest[i][j] > dest[i][k] + dest[k][j]) {
                        dest[i][j] = dest[i][k] + dest[k][j];
                    }
                }
            }
        }

        /**
         * has negative cycle if last cell is negative
         */

        return dest;
    }

}
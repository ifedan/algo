package algos.graph;

/**
 * Complexity O(V^2)
 *
 * Can be updated to (ElogV) - by using PriorityQueue and Adjacency list
 *
 * The code is for undirected graph, same dijekstra function can be used for directed graphs also
 *
 * Dijkstra’s algorithm doesn’t work for graphs with negative weight edges.
 * For graphs with negative weight edges, Bellman–Ford algorithm can be used
 */
public class Dijkstra {

    public static int[] getShortestPath(int[][] adjMatrix, int start) {
        int vCount = adjMatrix.length;
        int[] dest = new int[vCount];
        boolean[] visited = new boolean[vCount];
        for (int i = 0; i < vCount; i++) {
            dest[i] = Integer.MAX_VALUE;
        }
        dest[start] = 0;

        for (int v = 0; v < vCount-1; v++) {
            int i = getClosestUnvisitedVertex(dest, visited);
            /**
             * If you need to find the closest path to specific vertex, stop here when i == vertex
             */
            visited[i] = true;

            for (int j = 0; j < vCount; j++) {
                if (!visited[j] && adjMatrix[i][j] != 0 && dest[i] != Integer.MAX_VALUE &&
                        dest[j] > dest[i] + adjMatrix[i][j]) {
                    dest[j] = dest[i] + adjMatrix[i][j];
                }
            }
        }

        /**
         * Next loop will define if there is a negative path
         */

        return dest;
    }

    private static int getClosestUnvisitedVertex(int[] dest, boolean[] visited) {
        int vertex = -1;
        int minDest = Integer.MAX_VALUE;
        for (int i = 0; i < dest.length; i++) {
            if (!visited[i] && dest[i] < minDest) {
                minDest = dest[i];
                vertex = i;
            }
        }
        return vertex;
    }
}

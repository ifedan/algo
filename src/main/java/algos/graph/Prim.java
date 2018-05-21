package algos.graph;

/**
 * Complexity O(V^2)
 * Can be updated to (ElogV) - by using PriorityQueue and Adjacency list
 *
 * Given a connected and undirected graph,
 * a spanning tree of that graph is a subgraph that is a tree and connects all the vertices together.
 * A single graph can have many different spanning trees.
 * A minimum spanning tree (MST) or minimum weight spanning tree for a weighted,
 * connected and undirected graph is a spanning tree with weight less than or equal to the weight of every other spanning tree.
 * The weight of a spanning tree is the sum of weights given to each edge of the spanning tree.
 *
 * A minimum spanning tree has (V – 1) edges where V is the number of vertices in the given graph.
 */
public class Prim {

    public int[] getMST(int[][] adjMatrix) {
        int vCount = adjMatrix.length;
        int[] dest = new int[vCount];
        int[] parent = new int[vCount];
        boolean[] visited = new boolean[vCount];
        for (int i = 0; i < dest.length; i++) {
            dest[i] = Integer.MAX_VALUE;
        }
        dest[0] = 0;
        parent[0] = -1;

        for (int v = 0; v < vCount-1; v++) {
            int i = getClosestUnvisitedVertes(dest, visited);
            visited[i] = true;

            for (int j = 0; j < vCount; j++) {
                if (!visited[j] && adjMatrix[i][j] != 0 && dest[j] > adjMatrix[i][j]) {
                    dest[j] = adjMatrix[i][j];
                    parent[j] = i;
                }
            }
        }

        return parent;
    }

    private static int getClosestUnvisitedVertes(int[] dest, boolean[] visited) {
        int vertex = -1;
        int minDest = Integer.MAX_VALUE;
        for (int i = 0; i < dest.length; i++) {
            if (dest[i] < minDest) {
                minDest = dest[i];
                vertex = i;
            }
        }
        return vertex;
    }

}

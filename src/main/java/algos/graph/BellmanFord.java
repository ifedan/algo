package algos.graph;

/**
 * O(VE) - more than Dijkstra
 *
 * Bellman-Ford works for Graphs with negative weight edges, Dijkstra doesn't.
 *
 * Bellman-Ford works better (better than Dijksra’s) for distributed systems
 */
public class BellmanFord {

    private class Edge {
        int start;
        int end;
        int weight;
    }

    public int[] getShortestPath(Edge[] edges, int vCount) {
        int[] dest = new int[vCount];
        for (int i = 0; i < vCount; i++) {
            dest[i] = Integer.MAX_VALUE;
        }
        dest[0] = 0;

        for (int v = 0; v < vCount-1; v++) {
            for (Edge edge : edges) {
                if (dest[edge.start] != Integer.MAX_VALUE &&
                        dest[edge.end] > dest[edge.start] + edge.weight) {
                    dest[edge.end] = dest[edge.start] + edge.weight;
                }
            }
        }

        //If next loop will change dest - there is negative cycle

        return dest;
    }

}

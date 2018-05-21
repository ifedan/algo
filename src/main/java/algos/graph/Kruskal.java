package algos.graph;

import datastructures.UnionFind;

import java.util.Arrays;
import java.util.Comparator;

/**
 * complexity is O(ElogE) or O(ElogV)
 *
 * A minimum spanning tree has (V – 1) edges where V is the number of vertices in the given graph.
 *
 */
public class Kruskal {

    private class Edge{
        int start;
        int end;
        int weight;
    }

    private class EdgeComparator implements Comparator<Edge> {
        @Override
        public int compare(Edge o1, Edge o2) {
            return o1.weight - o2.weight;
        }
    }

    public Edge[] getMST(Edge[] edges, int vCount) {
        Arrays.sort(edges, new EdgeComparator());

        Edge[] result = new Edge[vCount-1];
        UnionFind uf = new UnionFind(vCount);

        int e = 0;
        int i = 0;
        while (e < result.length && i < edges.length) {
            if (!uf.connected(edges[i].start, edges[i].end)) {
                uf.union(edges[i].start, edges[i].end);
                result[e++] = edges[i];
            }
            i++;
        }

        return result;
    }
}
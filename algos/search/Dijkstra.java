package algos.search;

public class Dijkstra {

    public int[] minDistances(int graph[][], int start) {

        int dist[] = new int[graph.length];
        for (int i = 0; i < dist.length; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[start] = 0;

        boolean visited[] = new boolean[graph.length];

        for (int v = 0; v < graph.length - 1; v++) {

            int i = closestUnvisitedNode(dist, visited);
            visited[i] = true;

            for (int j = 0; j < graph.length; j++) {
                if (!visited[j] && graph[i][j] != 0 && dist[i] != Integer.MAX_VALUE &&
                        dist[i] + graph[i][j] < dist[j]) {
                    dist[j] = dist[i] + graph[i][j];
                }
            }

        }

        return dist;
    }

    private int closestUnvisitedNode(int[] dist, boolean[] visited) {
        int min = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < dist.length; i++) {
            if (!visited[i] && dist[i] < min) {
                min = dist[i];
                index = i;
            }
        }
        return index;
    }
}

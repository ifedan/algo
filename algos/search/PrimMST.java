package algos.search;

public class PrimMST {

    int minKey(int key[], Boolean mstSet[])
    {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int i = 0; i < key.length; i++)
            if (!mstSet[i] && key[i] < min)
            {
                min = key[i];
                minIndex = i;
            }

        return minIndex;
    }

    // Function to construct and print MST for a graph represented
    //  using adjacency matrix representation
    void primMST(int graph[][])
    {
        int vCount = graph.length;
        // Array to store constructed MST
        int parent[] = new int[vCount];

        // Key values used to pick minimum weight edge in cut
        int key[] = new int [vCount];

        // To represent set of vertices not yet included in MST
        Boolean mstSet[] = new Boolean[vCount];

        // Initialize all keys as INFINITE
        for (int i = 0; i < vCount; i++)
        {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }

        // Always include first 1st vertex in MST.
        key[0] = 0;     // Make key 0 so that this vertex is
        // picked as first vertex
        parent[0] = -1; // First node is always root of MST

        // The MST will have V vertices
        for (int count = 0; count < vCount-1; count++)
        {
            // Pick thd minimum key vertex from the set of vertices
            // not yet included in MST
            int u = minKey(key, mstSet);

            // Add the picked vertex to the MST Set
            mstSet[u] = true;

            // Update key value and parent index of the adjacent
            // vertices of the picked vertex. Consider only those
            // vertices which are not yet included in MST
            for (int v = 0; v < vCount; v++)

                // graph[u][v] is non zero only for adjacent vertices of m
                // mstSet[v] is false for vertices not yet included in MST
                // Update the key only if graph[u][v] is smaller than key[v]
                if (graph[u][v]!=0 && !mstSet[v] &&
                        graph[u][v] <  key[v])
                {
                    parent[v]  = u;
                    key[v] = graph[u][v];
                }
        }

        System.out.println();
    }

    public static void main(String[] args) {
        PrimMST t = new PrimMST();
        int graph[][] = new int[][] {{0, 2, 0, 6, 0},
                {2, 0, 3, 8, 5},
                {0, 3, 0, 0, 7},
                {6, 8, 0, 0, 9},
                {0, 5, 7, 9, 0},
        };

        // Print the solution
        t.primMST(graph);
    }


}

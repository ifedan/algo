package tasks.leetcode;

import java.util.*;

public class CloneGraph {

    public static class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;
        UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
    }

    public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        Map<Integer, UndirectedGraphNode> copy  = new HashMap<>();
        cloneGraph(node, copy);
        return copy.get(node.label);
    }

    public static void cloneGraph(UndirectedGraphNode node, Map<Integer, UndirectedGraphNode> copy) {
        if (node == null) return;
        UndirectedGraphNode copyNode = new UndirectedGraphNode(node.label);
        copy.put(node.label, copyNode);

        for (UndirectedGraphNode child : node.neighbors) {
            if (!copy.containsKey(child.label)) {
                cloneGraph(child, copy);
            }
            copyNode.neighbors.add(copy.get(child.label));
        }

    }


}

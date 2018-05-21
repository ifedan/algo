package tasks.leetcode;

public class BricksFallingWhenHit {

    public int[] hitBricks(int[][] grid, int[][] hits) {
        return calc(grid, hits);
    }

    static class UnionFind {
        int tree[];
        int size[];
        UnionFind(int num) {
            tree = new int[num];
            size = new int[num];
            for (int i = 0; i < num; i++) {
                tree[i] = i;
                size[i] = 1;
            }
        }
        int getParent(int node) {
            while (tree[node] != node) {
                node = tree[node];
            }
            return node;
        }
        boolean connected(int a, int b) {
            return (a == b) || getParent(a) == getParent(b);
        }
        int union(int a, int b) {
            if (a == b) return getParent(a);
            int parentA = getParent(a);
            int parentB = getParent(b);
            if (parentA == parentB) return parentA;
            if (size[parentA] > size[parentB]) {
                tree[parentB] = parentA;
                size[parentA] += size[parentB];
                return parentA;
            } else {
                tree[parentA] = parentB;
                size[parentB] += size[parentA];
                return parentB;
            }
        }
        int size(int a) {
            return size[getParent(a)];
        }
    }

    public static int[] calc(int[][] grid, int[][] hits) {
        int hitId = -1;
        for (int i = hits.length - 1; i>=0; i--) {
            if (grid[hits[i][0]][hits[i][1]] == 1) {
                grid[hits[i][0]][hits[i][1]] = hitId--;
            }
        }

        int brickId = 1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] > 0) grid[i][j] = brickId++;
            }
        }

        int top = 0;
        UnionFind uf = new UnionFind(brickId + hits.length);

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] < 0) {
                    grid[i][j] = brickId - grid[i][j] - 1;
                    continue;
                }
                if (grid[i][j] == 0) continue;
                if (j < grid[i].length - 1 && grid[i][j+1] > 0) {
                    uf.union(grid[i][j], grid[i][j+1]);
                }
                if (i < grid.length - 1 && grid[i+1][j] > 0) {
                    uf.union(grid[i][j], grid[i+1][j]);
                }
            }
        }

        for (int i = 0; i < grid[0].length; i++) {
            uf.union(top, grid[0][i]);
        }

        int[] result = new int[hits.length];
        for (int i = hits.length-1; i>=0; i--) {
            result[i] = hit(hits[i][0], hits[i][1], grid, uf, top);
        }

        return result;
    }

    private static int hit(int i, int j, int grid[][], UnionFind uf, int top) {
        if (grid[i][j] == 0) return 0;
        int bricksToFall = 0;
        boolean becomeConnected = uf.connected(top, grid[i][j]);
        int[] move = new int[]{0,-1,0,1,-1,0,1,0};
        for (int x = 0; x < move.length; x+=2) {
            int a = move[x];
            int b = move[x+1];
            if (i+a<0 || i+a>=grid.length || j+b<0 || j+b>=grid[i+a].length || grid[i+a][j+b] == 0 || grid[i][j] < grid[i+a][j+b]) continue;
            boolean alreadyConnected = uf.connected(top, grid[i+a][j+b]);
            becomeConnected |= alreadyConnected;
            if (!alreadyConnected) {
                bricksToFall += uf.size(grid[i+a][j+b]);
            }
            uf.union(grid[i][j], grid[i+a][j+b]);
        }
        if (becomeConnected) return bricksToFall;
        else return 0;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{0,1,1,1,1,1},{1,1,1,1,1,1},{0,0,1,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0}};
        int[][] hits = new int[][]{{1,3},{3,5},{0,3},{3,3},{1,1},{4,2},{1,0},{3,0},{4,5},{2,1},{4,4},{4,0},{2,4},{2,5},{3,4},{0,5},{0,4},{3,2},{1,5},{4,1},{2,2},{0,2}};
        calc(grid, hits);
    }

}

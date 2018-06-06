package tasks.leetcode;

public class SimilarStringGroups {
    public static int numSimilarGroups(String[] A) {
        UF uf = new UF(A.length);
        for (int i = 0; i < A.length - 1; i++) {
            for (int j = i; j < A.length; j++) {
                if (areSimilar(A[i], A[j])) {
                    uf.union(i, j);
                }
            }
        }
        return uf.count;
    }

    private static boolean areSimilar(String a, String b) {
        if (a.equals(b)) return true;
        char c1 = 0;
        char c2 = 0;
        int count = 0;
        boolean similar = false;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                if (count == 0) {
                    c1 = a.charAt(i);
                    c2 = b.charAt(i);
                    count++;
                }
                else if (count == 1) {
                    similar = (c1 == b.charAt(i) && c2 == a.charAt(i));
                    if (!similar) return false;
                    count++;
                }
                else if (count == 2) {
                    similar = false;
                    break;
                }
            }
        }
        return similar;
    }

    static class UF {
        int[] arr;
        int[] weight;
        int count;

        UF(int size) {
            this.arr = new int[size];
            this.weight = new int[size];
            count = size;
            for (int i = 0; i < size; i++) {
                arr[i] = i;
                weight[i] = 1;
            }
        }

        int parent(int node) {
            while(arr[node] != node) {
                node = arr[node];
            }
            return node;
        }

        void union(int a, int b) {
            if (a == b) return;
            int parentA = parent(a);
            int parentB = parent(b);
            if (parentA == parentB) return;

            if (weight[parentA] > weight[parentB]) {
                arr[parentB] = parentA;
                weight[parentA] += weight[parentB];
            } else {
                arr[parentA] = parentB;
                weight[parentB] += weight[parentA];
            }
            count--;
        }
    }

    public static void main(String[] args) {
        String a[] = new String[]{"tars","rats","arts","star"};
        int res = numSimilarGroups(a);
        System.out.println("-->" + res);
    }
}

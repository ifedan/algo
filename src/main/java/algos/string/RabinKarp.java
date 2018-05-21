package algos.string;

public class RabinKarp {

    public static void main(String[] args) {
        System.out.println(indexOf("xvbnabck", "abc"));
    }

    public static int indexOf(String s, String p) {
        int pHash = hash(p);
        int hash = hash(s, 0, p.length());

        int k = 0;
        while (k <= s.length() - p.length() - 1) {
            if (hash == pHash) {
                if (equals(s, k, p)) {
                    return k;
                }
            }
            hash = rehash(s.charAt(k), s.charAt(k+p.length()), hash, p.length()-1);
            k++;
        }
        return -1;
    }

    private static boolean equals(String s, int start, String p) {
        for (int i = 0; i < p.length(); i++) {
            if (s.charAt(start+i) != p.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    private static int hash(String str) {
        return hash(str, 0, str.length());
    }

    private static int hash(String str, int start, int end) {
        int hash = 0;
        for (int i = start; i < end; i++) {
            hash += str.charAt(i) * (1<<i);
        }
        return hash;
    }

    private static int rehash(char prev, char next, int prevHash, int size) {
        return ((prevHash - prev) / 2) + (next * (1<<size));
    }



}

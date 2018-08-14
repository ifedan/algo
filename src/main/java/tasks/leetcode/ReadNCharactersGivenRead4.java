package tasks.leetcode;

public class ReadNCharactersGivenRead4 {

    char[] cache = new char[4];
    int cacheIndex = 0;
    int cacheSize = 0;

    public int read(char[] buf, int n) {
        int k = 0;
        while (k < n) {
            if (cacheSize > 0 && cacheIndex < cacheSize) {
                buf[k++] = cache[cacheIndex++];
            }
            if (cacheIndex == cacheSize) {
                cacheSize = read4(cache);
                cacheIndex = 0;
            }
            if (cacheSize == 0) break;
        }
        return k;
    }

    int read4(char[] buf) {
        return -1;
    }
}

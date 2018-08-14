package tasks.leetcode;

public class ReadNCharactersGivenRead4II {

    char[] cache = new char[4];
    int cachePos;
    int wasRead;

    private int read(char[] buf, int n) {
        int pos = 0;
        while (pos < n) {
            if (cachePos == 0) { //empty
                wasRead = read4(cache);
            }
            if (wasRead == 0) return pos;
            while (cachePos < wasRead && pos < n) {
                buf[pos++] = cache[cachePos++];
            }
            if (cachePos >= wasRead) {
                cachePos = 0;
            }
        }
        return pos;
    }

    private int read4(char[] buf) {
        return 0;
    }
}

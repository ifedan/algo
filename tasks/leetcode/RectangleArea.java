package tasks.leetcode;

public class RectangleArea {

    public static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area = (C-A)*(D-B) + (H-F)*(G-E);
        int xL = Math.max(A, E);
        int xR = Math.min(C, G);
        if (xR <= xL)
            return area;
        else {
            int yT = Math.max(B, F);
            int yB = Math.min(D, H);
            if (yB <= yT)
                return area;
            else
                return area - (xR-xL)*(yB-yT);
        }
    }

}

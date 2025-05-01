package algorithms.medium.other;

/**
 * <a href="https://leetcode.com/problems/rectangle-area">...</a>
 * This solution beats 67.59% other Java submissions' memory complexity
 * This solution beats 100% other Java submissions' runtime
 */
public class RectangleArea {

    public static int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int rec1 = (ax2 - ax1) * (ay2 - ay1);
        int rec2 = (bx2 - bx1) * (by2 - by1);

        // we will not have common element with those conditions
        if (ax2 <= bx1 || ay2 <= by1 || bx2 <= ax1 || by2 <= ay1) {
            return rec1 + rec2;
        }

        int cx1 = Math.max(ax1, bx1);
        int cy1 = Math.max(ay1, by1);
        int cx2 = Math.min(ax2, bx2);
        int cy2 = Math.min(ay2, by2);
        int common = (cx2 - cx1) * (cy2 - cy1);

        return rec1 + rec2 - common;
    }
}

package algorithms.medium.array;

/**
 * <a href="https://leetcode.com/problems/container-with-most-water">...</a>
 * This solution beats 68.95% other Java submissions' runtime
 * This solution beats 55.63% other Java submissions' memory complexity
 */
public class ContainerWithMostWater {

    public static int maxArea(int[] height) {
        int pointer1 = 0;
        int pointer2 = height.length - 1;
        int waterArea = 0;
        while (pointer1 < pointer2) {
            int currentArea = (pointer2 - pointer1) * Math.min(height[pointer1], height[pointer2]);
            waterArea = Math.max(waterArea, currentArea);
            if (height[pointer1] < height[pointer2]) {
                pointer1++;
            } else {
                pointer2--;
            }
        }
        return waterArea;
    }
}

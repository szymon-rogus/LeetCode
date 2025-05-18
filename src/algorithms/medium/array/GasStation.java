package algorithms.medium.array;

/**
 * <a href="https://leetcode.com/problems/gas-station">...</a>
 * This solution beats 11.37% other Java submissions' runtime
 * This solution beats 44.08% other Java submissions' memory complexity
 */
public class GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int count = 0;
        while (count < gas.length) {
            int startingPoint = count;
            int currentPoint = count;
            int gasLeft = 0;
            int steps = 0;
            while (true) {
                if (currentPoint == startingPoint && steps > 0) {
                    return startingPoint;
                }
                if (gasLeft + gas[currentPoint] < cost[currentPoint]) {
                    count += Math.max(steps, 1);
                    break;
                } else {
                    gasLeft += gas[currentPoint];
                    gasLeft -= cost[currentPoint];
                    currentPoint = (currentPoint + 1) % gas.length;
                    steps++;
                }
            }
        }
        return -1;
    }
}

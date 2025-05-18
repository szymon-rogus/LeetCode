package algorithms.easy.list;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/pascals-triangle">...</a>
 * This solution beats 85.17% other Java submissions' runtime
 * This solution beats 8.14% other Java submissions' memory complexity
 */
public class PascalTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> solution = new ArrayList<>();
        solution.add(new ArrayList<>(List.of(1)));

        for (int i = 1; i < numRows; i++) {
            List<Integer> newRow = generate(solution.getLast());
            solution.add(newRow);
        }

        return solution;
    }

    private List<Integer> generate(List<Integer> row) {
        List<Integer> list = new ArrayList<>();
        list.add(1);

        for (int i = 0; i < row.size() - 1; i++) {
            list.add(row.get(i) + row.get(i + 1));
        }
        list.add(1);

        return list;
    }
}

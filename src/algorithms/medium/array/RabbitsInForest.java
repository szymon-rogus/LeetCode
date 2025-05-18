package algorithms.medium.array;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/rabbits-in-forest">...</a>
 * This solution beats 31.03% other Java submissions' runtime
 * This solution beats 71.40% other Java submissions' memory complexity
 */
public class RabbitsInForest {

    public int numRabbits(int[] answers) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int rabbitCount = 0;

        /// The goal is to store the data in Map where:
        /// key = rabbits in the same color
        /// value = how many answers of this amount was given
        /// so for pair 3 : 2, exactly 2 rabbits said "There are 2 rabbits in the same color as me in the forest"
        /// 2 answers given were put as value to map, key is 2 + 1 rabbits of one color
        /// (each rabbit said there are 2 more rabbits in the same color, so we have to increment this by the one who is giving the answer)
        /// For pair 11 : 4, 4 rabbits said "There are 10 rabbits in the same color as me in the forest".
        /// We have 11 rabbits in the same color (again - increment by the one who is giving the answer), and 4 answers
        for (int answer : answers) {
            int sameColor = answer + 1;
            if (map.containsKey(sameColor)) {
                int count = map.get(sameColor);
                map.put(sameColor, ++count);
            } else {
                map.put(sameColor, 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            /// if the number of answers (value) has not exceeded the number of rabbits in the same color (key)
            /// we can assume greedy that the key number represents the whole color - so we add to our solution
            if (entry.getKey() >= entry.getValue()) {
                rabbitCount += entry.getKey();
            } else {

                /// if the number of answers exceeds the number of rabbits int the same color,
                /// it means some of the rabbits while answering were referring to different colors.
                /// In that case we have to find how many buckets can we create by diving the answers
                /// by number of rabbits in the same color.
                /// Buckets no. will tell us how many different colors are there in those answers.
                /// So we have to multiply the numbers of rabbits in the same color by number of colors.
                int buckets = entry.getValue() % entry.getKey() == 0
                        ? entry.getValue() / entry.getKey()
                        : entry.getValue() / entry.getKey() + 1;

                rabbitCount += buckets * entry.getKey();
            }
        }
        return rabbitCount;
    }
}

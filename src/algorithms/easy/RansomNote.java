package algorithms.easy;

import java.util.HashMap;

/**
 * <a href="https://leetcode.com/problems/ransom-note">...</a>
 * This solution beats 93.25% other Java submissions' memory complexity
 * This solution beats 65.48% other Java submissions' runtime
 */
public class RansomNote {

    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> notes = new HashMap<>();

        ///  In notes, we store all needed elements
        for (char c : ransomNote.toCharArray()) {
            if (notes.containsKey(c)) {
                int size = notes.get(c);
                notes.put(c, ++size);
            } else {
                notes.put(c, 1);
            }
        }

        /// we want to clear out notes by matching elements from original magazine,
        /// if we do so - it means ransom note can be created
        for (char c : magazine.toCharArray()) {
            if (notes.isEmpty()) return true;
            if (notes.containsKey(c)) {
                int size = notes.remove(c);
                if (size > 1) {
                    notes.put(c, --size);
                }
            }
        }
        return notes.isEmpty();
    }
}

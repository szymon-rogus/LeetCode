package algorithms.hard;

import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/text-justification">...</a>
 * This solution beats 5.61% other Java submissions' memory complexity
 * This solution beats 5.54% other Java submissions' runtime
 */
public class TextJustification {

    // My lord...
    public static List<String> fullJustify(String[] words, int maxWidth) {

        List<String> list = new LinkedList<>();
        List<String> line = new LinkedList<>();
        String currentString = "";
        for (String word : words) {
            if (currentString.isEmpty()) {
                currentString += word;
                line.add(word);
            } else {
                if (currentString.length() + 1 + word.length() <= maxWidth) {
                    currentString = currentString + " " + word;
                    line.add(word);
                } else {
                    currentString = adjust(line, maxWidth);
                    line.clear();
                    list.add(currentString);
                    currentString = word;
                    line.add(word);
                }
            }
        }

        if (!line.isEmpty()) {
            currentString = adjust2(line, maxWidth);
            line.clear();
            list.add(currentString);
        }

        return list;
    }

    private static String adjust(List<String> list, int maxWidth) {
        int blocks = list.size() == 1 ? 1 : list.size() - 1;

        for (String string : list) {
            maxWidth -= string.length();
        }

        List<String> whiteBlocks = new LinkedList<>();
        int repeat = maxWidth / blocks;
        for (int i = 0; i < blocks; i++) {
            whiteBlocks.add(" ".repeat(repeat));
            maxWidth -= repeat;
        }

        for (int i = 0; i < whiteBlocks.size(); i++) {
            if (maxWidth > 0) {
                String block = whiteBlocks.get(i);
                block = block + " ";
                whiteBlocks.set(i, block);
                maxWidth--;
            } else {
                break;
            }
        }

        String string = "";
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1 && list.size() != 1) {
                string = string + list.get(i);
            } else {
                string = string + list.get(i) + whiteBlocks.get(i);
            }
        }
        return string;

    }

    private static String adjust2(List<String> list, int maxWidth) {
        int blocks = list.size() == 1 ? 1 : list.size();

        for (String string : list) {
            maxWidth -= string.length();
        }

        List<String> whiteBlocks = new LinkedList<>();
        for (int i = 0; i < blocks; i++) {
            if (i == blocks - 1) {
                whiteBlocks.add(" ".repeat(maxWidth));
                maxWidth = 0;
            } else {
                whiteBlocks.add(" ");
                maxWidth--;
            }
        }

        String string = "";
        for (int i = 0; i < list.size(); i++) {
            string = string + list.get(i) + whiteBlocks.get(i);
        }
        return string;
    }
}

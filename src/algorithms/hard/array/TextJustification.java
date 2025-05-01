package algorithms.hard.array;

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
        StringBuilder currentString = new StringBuilder();
        for (String word : words) {
            if (currentString.isEmpty()) {
                currentString.append(word);
                line.add(word);
            } else {
                if (currentString.length() + 1 + word.length() <= maxWidth) {
                    currentString.append(" ").append(word);
                    line.add(word);
                } else {
                    currentString = new StringBuilder(adjust(line, maxWidth));
                    line.clear();
                    list.add(currentString.toString());
                    currentString = new StringBuilder(word);
                    line.add(word);
                }
            }
        }

        if (!line.isEmpty()) {
            currentString = new StringBuilder(adjust2(line, maxWidth));
            line.clear();
            list.add(currentString.toString());
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

        StringBuilder string = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1 && list.size() != 1) {
                string.append(list.get(i));
            } else {
                string.append(list.get(i)).append(whiteBlocks.get(i));
            }
        }
        return string.toString();

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

        StringBuilder string = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            string.append(list.get(i)).append(whiteBlocks.get(i));
        }
        return string.toString();
    }
}

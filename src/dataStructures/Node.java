package dataStructures;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class Node {

    public int value;
    public List<Node> neighbors;

    public Node() {
        value = 0;
        neighbors = new ArrayList<>();
    }

    public Node(int val) {
        this.value = val;
        neighbors = new ArrayList<>();
    }
}

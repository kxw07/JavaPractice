package data_structure.binary_sort_tree;

import lombok.Data;

@Data
public class Node {
    private int data;
    private Node leftNode;
    private Node rightNode;
    private Node parentNode;

    public Node(int data) {
        this.data = data;
    }
}

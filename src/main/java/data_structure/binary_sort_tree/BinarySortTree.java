package data_structure.binary_sort_tree;

import lombok.Data;

@Data
public class BinarySortTree {
    private Node root;

    public BinarySortTree() {
    }

    public Node search(int target) {
        return search(root, target);
    }

    private Node search(Node node, int target) {
        if (node == null || node.getData() == target) {
            return node;
        }

        if (target < node.getData()) {
            return search(node.getLeftNode(), target);
        } else {
            return search(node.getRightNode(), target);
        }
    }

    public Node insert(int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }

        return insert(null, root, data);
    }

    private Node insert(Node parent, Node node, int data) {
        if (node == null) {
            Node insertNode = new Node(data);
            insertNode.setParentNode(parent);

            if (data < parent.getData()) {
                parent.setLeftNode(insertNode);
            } else {
                parent.setRightNode(insertNode);
            }

            return insertNode;
        } else {
            if (data == node.getData()) {
                return node;
            } else if (data < node.getData()) {
                return insert(node, node.getLeftNode(), data);
            } else {
                return insert(node, node.getRightNode(), data);
            }
        }
    }

    public void remove(int target) throws Exception {
        if (root == null) {
            throw new Exception("Tree is empty");
        }

        remove(null, root, target);
    }

    private void remove(Node parent, Node node, int target) throws Exception {
        if (node == null) {
            throw new Exception("Node not found");
        }

        if (target == node.getData()) {
            if (node.getLeftNode() == null && node.getRightNode() == null) {
                if (node.getData() < parent.getData()) {
                    parent.setLeftNode(null);
                } else {
                    parent.setRightNode(null);
                }

            } else if (node.getLeftNode() != null && node.getRightNode() != null) {
                Node minNode = searchMinNode(node.getRightNode());

                minNode.setRightNode(node.getRightNode());
                node.getRightNode().setParentNode(minNode);

                minNode.setLeftNode(node.getLeftNode());
                node.getLeftNode().setParentNode(minNode);

                Node minNodeParent = minNode.getParentNode();
                if (minNode.getData() < minNodeParent.getData()) {
                    minNodeParent.setLeftNode(null);
                } else {
                    minNodeParent.setRightNode(null);
                }

                minNode.setParentNode(parent);
                if (minNode.getData() < parent.getData()) {
                    parent.setLeftNode(minNode);
                } else {
                    parent.setRightNode(minNode);
                }

            } else if (node.getLeftNode() == null && node.getRightNode() != null){
                node.getRightNode().setParentNode(parent);

                if (node.getRightNode().getData() < parent.getData()) {
                    parent.setLeftNode(node.getRightNode());
                } else {
                    parent.setRightNode(node.getRightNode());
                }

            }  else {
                node.getLeftNode().setParentNode(parent);

                if (node.getLeftNode().getData() < parent.getData()) {
                    parent.setLeftNode(node.getLeftNode());
                } else {
                    parent.setRightNode(node.getLeftNode());
                }

            }
        } else if (target < node.getData()) {
            remove(node, node.getLeftNode(), target);
        } else {
            remove(node, node.getRightNode(), target);
        }
    }

    private Node searchMinNode(Node node) {
        if (node.getLeftNode() == null) {
            return node;
        } else {
            return searchMinNode(node.getLeftNode());
        }
    }

    private Node searchMaxNode(Node node) {
        if (node.getRightNode() == null) {
            return node;
        } else {
            return searchMinNode(node.getRightNode());
        }
    }
}

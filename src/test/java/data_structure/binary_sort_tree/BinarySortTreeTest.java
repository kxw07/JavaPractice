package data_structure.binary_sort_tree;

import data_structure.binary_sort_tree.BinarySortTree;
import data_structure.binary_sort_tree.Node;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;

public class BinarySortTreeTest {
    @Test
    public void insertLeft() {
        BinarySortTree binarySortTree = new BinarySortTree();
        binarySortTree.insert(8);
        binarySortTree.insert(2);
        Node node = binarySortTree.insert(1);
        Assert.assertEquals(2, node.getParentNode().getData());
    }

    @Test
    public void insertRight() {
        BinarySortTree binarySortTree = new BinarySortTree();
        binarySortTree.insert(8);
        binarySortTree.insert(12);
        Node node = binarySortTree.insert(9);
        Assert.assertEquals(12, node.getParentNode().getData());
    }

    @Test
    public void insertTwoSide() {
        BinarySortTree binarySortTree = new BinarySortTree();
        binarySortTree.insert(8);
        binarySortTree.insert(4);
        binarySortTree.insert(3);
        binarySortTree.insert(1);
        binarySortTree.insert(17);
        binarySortTree.insert(16);
        binarySortTree.insert(20);
        Node node1 = binarySortTree.insert(6);
        Node node2 = binarySortTree.insert(12);
        Assert.assertEquals(4, node1.getParentNode().getData());
        Assert.assertEquals(16, node2.getParentNode().getData());
    }

    @Test
    public void searchLeft() {
        BinarySortTree binarySortTree = new BinarySortTree();
        binarySortTree.insert(8);
        binarySortTree.insert(2);
        binarySortTree.insert(1);
        Assert.assertNull(binarySortTree.search(3));
        Assert.assertEquals(8, binarySortTree.search(2).getParentNode().getData());
    }

    @Test
    public void searchRight() {
        BinarySortTree binarySortTree = new BinarySortTree();
        binarySortTree.insert(8);
        binarySortTree.insert(12);
        binarySortTree.insert(9);
        Assert.assertNull(binarySortTree.search(10));
        Assert.assertEquals(8, binarySortTree.search(12).getParentNode().getData());
    }

    @Test
    public void removeNodeHasRightAndLeftChild() throws Exception {
        BinarySortTree binarySortTree = new BinarySortTree();
        binarySortTree.insert(8);
        binarySortTree.insert(4);
        binarySortTree.insert(3);
        binarySortTree.insert(1);
        binarySortTree.insert(6);
        binarySortTree.insert(17);
        binarySortTree.insert(16);
        binarySortTree.insert(20);
        binarySortTree.insert(12);

        binarySortTree.remove(17);
        Assert.assertEquals(8, binarySortTree.search(20).getParentNode().getData());
        Assert.assertEquals(16, binarySortTree.search(20).getLeftNode().getData());
        Assert.assertNull(binarySortTree.search(20).getRightNode());
    }

    @Test
    public void removeNodeOnlyHasRightChild() throws Exception {
        BinarySortTree binarySortTree = new BinarySortTree();
        binarySortTree.insert(8);
        binarySortTree.insert(4);
        binarySortTree.insert(3);
        binarySortTree.insert(1);
        binarySortTree.insert(6);
        binarySortTree.insert(17);
        binarySortTree.insert(20);
        binarySortTree.insert(19);

        binarySortTree.remove(17);
        Assert.assertEquals(8, binarySortTree.search(20).getParentNode().getData());
    }

    @Test
    public void removeNodeOnlyHasLeftChild() throws Exception {
        BinarySortTree binarySortTree = new BinarySortTree();
        binarySortTree.insert(8);
        binarySortTree.insert(4);
        binarySortTree.insert(3);
        binarySortTree.insert(1);
        binarySortTree.insert(6);
        binarySortTree.insert(17);
        binarySortTree.insert(13);
        binarySortTree.insert(16);

        binarySortTree.remove(17);
        Assert.assertEquals(8, binarySortTree.search(13).getParentNode().getData());
    }

    @Test
    public void removeNodeNoChild() throws Exception {
        BinarySortTree binarySortTree = new BinarySortTree();
        binarySortTree.insert(8);
        binarySortTree.insert(4);
        binarySortTree.insert(3);
        binarySortTree.insert(1);
        binarySortTree.insert(6);
        binarySortTree.insert(17);
        binarySortTree.insert(16);
        binarySortTree.insert(20);
        binarySortTree.insert(12);

        binarySortTree.remove(20);
        Assert.assertNull(binarySortTree.search(17).getRightNode());
    }

    @Test
    public void removeWhenTreeIsEmpty() {
        BinarySortTree binarySortTree = new BinarySortTree();
        Assertions.assertThatThrownBy(() -> {
            binarySortTree.remove(1);
        }).hasMessage("Tree is empty");
    }

    @Test
    public void removeWhenNodeNotFound() {
        BinarySortTree binarySortTree = new BinarySortTree();
        binarySortTree.insert(99999);
        Assertions.assertThatThrownBy(() -> {
            binarySortTree.remove(1);
        }).hasMessage("Node not found");
    }
}

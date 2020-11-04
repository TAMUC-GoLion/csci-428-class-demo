package edu.tamuc.csci.common;

import java.util.List;

/**
 * Demo: Tree node
 */

public class TreeNode<E> {
    private E val;
//    List<TreeNode> children;
    private TreeNode lChild, rChild;

    public TreeNode(E val) {
        this.val = val;
    }

    public E getVal() {
        return val;
    }

    public void setVal(E val) {
        this.val = val;
    }

    public TreeNode getlChild() {
        return lChild;
    }

    public void setlChild(TreeNode lChild) {
        this.lChild = lChild;
    }

    public TreeNode getrChild() {
        return rChild;
    }

    public void setrChild(TreeNode rChild) {
        this.rChild = rChild;
    }
}

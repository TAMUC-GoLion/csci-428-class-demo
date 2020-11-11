package edu.tamuc.csci.common.TreeLike;

import java.util.*;

/**
 * Demo: Binary Search Tree
 */

public class BST<E extends Comparable<E>> {
    private Node<E> root;
    private int size;

    public BST() {
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    //Goal(1) insert & contains
    //commonly use ==> Search if value in tree, return the node or parent (if insert later)
    private Node<E> search(E val) {
        if (root == null || val == null) return null;

        Node<E> cur = root, predecessor = null;
        while (cur != null) {
            if (val.compareTo(cur.val) == 0) return cur; //if has value, return the node

            predecessor = cur;
            if (val.compareTo(cur.val) < 0) cur = cur.lChild;
            else cur = cur.rChild;
        }

        return predecessor; //o.w. return the predecessor
    }

    //(1.1) contains
    public boolean contains(E val) {
        Node<E> tmp = search(val);
        return tmp == null ? val == null : val.equals(tmp.val);
    }

    //(1.2) insert, returns if the insertion was successful
    public boolean insert(E val) {
        if (val == null) return false;

        if (size == 0) {
            root = new Node<>(val);
            size++;
            return true;
        }

        Node<E> tmp = search(val);
        if (val.equals(tmp.val)) return false; //already contains the value, don't insert

        if (val.compareTo(tmp.val) < 0) tmp.lChild = new Node<>(val);
        else tmp.rChild = new Node<>(val);

        size++;
        return true;
    }

    //Goal (2) Traversal
    //(2.1) levelOrder for serialization purpose (drawing)
    private String levelOrder() {
        if (root == null) return "";

        List<Node<E>> que = new ArrayList<>();
        que.add(root);
        int index = 0;
        while (index < que.size()) {
            Node<E> cur = que.get(index++);

            if (cur == null) continue;

            que.add(cur.lChild);
            que.add(cur.rChild);
        }

        StringBuilder sb = new StringBuilder();
        while (que.get(que.size() - 1) == null) que.remove(que.size() - 1);
        for (Node<E> node : que) {
            if (node == null) sb.append("#,");
            else sb.append(node.val + ",");
        }

        return sb.toString();
    }

    //(2.2) Preorder, Inorder, PostOrder
    public List<E> preorder() {
        List<E> ret = new ArrayList<>();
        preorder(root, ret);
        return ret;
    }

    private void preorder(Node<E> node, List<E> res) {
        if (node == null) return;

        res.add(node.val);
        preorder(node.lChild, res);
        preorder(node.rChild, res);
    }

    public List<E> inorder() {
        List<E> ret = new ArrayList<>();
        //inorder(root, ret);
        inorderIter(root, ret);
        return ret;
    }

    //Recursive inorder
    private void inorder(Node<E> node, List<E> res) {
        if (node == null) return;

        inorder(node.lChild, res);
        res.add(node.val);
        inorder(node.rChild, res);
    }

    //Iterative inorder
    private void inorderIter(Node<E> node, List<E> res) {
        Stack<Node<E>> stack = new Stack<>();
        Node<E> iter = node;

        while (iter != null || !stack.isEmpty()) {
            while (iter != null) {
                stack.push(iter);
                iter = iter.lChild;
            }

            Node<E> cur = stack.pop();
            res.add(cur.val);

            iter = cur.rChild;
        }
    }

    //Goal (3) Search
    //(3.1) min, removeMin
    public E min() {
        if (size == 0) throw new IllegalArgumentException("BST is empty");
        return min(root).val;
    }

    /**
     * Find the minimum node root at {@code node}
     *
     * @param node
     * @return
     */
    public Node<E> min(Node<E> node) {
        Node<E> cur = node;
        while (cur.lChild != null) cur = cur.lChild;
        return cur;
    }

    /**
     * Delete the minimum node in the BST, returns its value
     *
     * @return
     */
    public E deleteMin() {
        Node<E> min = min(root);
        root = deleteMin(root);
        return min.val;
    }

    /**
     * Delete the minimum node in sub-tree rooted at {@code node}, returns the new root after deletion
     *
     * @param node
     * @return
     */
    private Node<E> deleteMin(Node<E> node) {
        Node<E> cur = node;

        if (cur.lChild != null) cur.lChild = deleteMin(cur.lChild);
        else {
            Node<E> right = cur.rChild;

            cur.rChild = null; //help GC
            size--;

            cur = right;
        }

        return cur;
    }

    //(3.2) max, removeMax

    //Goal (4) Remove
    // 从二分搜索树中删除元素为e的节点
    public void remove(E e) {
        root = remove(root, e);
    }

    /**
     * Recursively delete value {@code e} in a (sub)-tree root at {@code node}
     * returns the new root
     */
    private Node<E> remove(Node<E> node, E target) {

        if (node == null)
            return null;

        if (target.compareTo(node.val) < 0) {
            node.lChild = remove(node.lChild, target);
            return node;
        } else if (target.compareTo(node.val) > 0) {
            node.rChild = remove(node.rChild, target);
            return node;
        } else {   // node.val == target

            // case 1: deleted node has no left child
            if (node.lChild == null) {
                Node rightNode = node.rChild;
                node.rChild = null;
                size--;
                return rightNode;
            }

            // delete node has no right child
            if (node.rChild == null) {
                Node leftNode = node.lChild;
                node.lChild = null;
                size--;
                return leftNode;
            }


            // Target has both left and right children
            // Find the node to replace its place by the successor in inorder traversal
            Node successor = min(node.rChild);
            successor.rChild = deleteMin(node.rChild);
            successor.lChild = node.lChild;

            node.lChild = null;//help GC
            node.rChild = null;

            return successor;
        }
    }

    private class Node<E> {
        E val;
        Node<E> lChild, rChild;

        Node(E val) {
            this.val = val;
        }
    }

    @Override
    public String toString() {
        String s = levelOrder();
        return "{" + s.substring(0, s.length() - 1) + "}";
    }
}

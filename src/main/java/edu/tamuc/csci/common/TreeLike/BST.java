package edu.tamuc.csci.common.TreeLike;

import java.util.*;

/**
 * Demo: Binary Search Tree
 */

public class BST<K extends Comparable<K>, V> {
    private Node root;
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
    private Node search(K key) {
        if (root == null || key == null) return null;

        Node cur = root, predecessor = null;
        while (cur != null) {
            if (key.compareTo(cur.key) == 0) return cur; //if has value, return the node

            predecessor = cur;
            if (key.compareTo(cur.key) < 0) cur = cur.lChild;
            else cur = cur.rChild;
        }

        return predecessor; //o.w. return the predecessor
    }

    //BST Map get
    public Node getNode(K key) {
        Node ret = search(key);
        return ret.key.equals(key) ? ret : null;
    }

    public V valueOf(Node node) {
        return node != null ? node.val : null;
    }

    public void set(K key, V val) {
        Node node = search(key);
        if(node != null) node.val = val;
    }

    //(1.1) contains
    public boolean contains(K key) {
        Node tmp = search(key);
        return tmp == null ? key == null : key.equals(tmp.key);
    }

    //(1.2) insert, returns if the insertion was successful
    public boolean insert(K key, V val) {
        if (key == null) return false;

        if (size == 0) {
            root = new Node(key, val);
            size++;
            return true;
        }

        Node tmp = search(key);
        if (key.equals(tmp.key)) return false; //already contains the value, don't insert

        if (key.compareTo(tmp.key) < 0) tmp.lChild = new Node(key, val);
        else tmp.rChild = new Node(key, val);

        size++;
        return true;
    }

    //Goal (2) Traversal
    //(2.1) levelOrder for serialization
    private String levelOrder() {
        if (root == null) return "";

        List<Node> que = new ArrayList<>();
        que.add(root);
        int index = 0;
        while (index < que.size()) {
            Node cur = que.get(index++);

            if (cur == null) continue;

            que.add(cur.lChild);
            que.add(cur.rChild);
        }

        StringBuilder sb = new StringBuilder();
        while (que.get(que.size() - 1) == null) que.remove(que.size() - 1);
        for (Node node : que) {
            if (node == null) sb.append("#,");
            else sb.append(node.key + ",");
        }

        return sb.toString();
    }

    //(2.2) Preorder, Inorder, PostOrder
    @Deprecated
    public List<K> preorderRec() { //recursively preorder
        List<K> ret = new ArrayList<>();
        preorderRec(root, ret);
        return ret;
    }

    public List<K> preorder() {
        List<K> ret = new ArrayList<>();
        preorder(root, ret);
        return ret;
    }

    @Deprecated
    private void preorderRec(Node node, List<K> res) {
        if (node == null) return;

        res.add(node.key);
        preorderRec(node.lChild, res);
        preorderRec(node.rChild, res);
    }

    private void preorder(Node node, List<K> res) {
        if (node == null) return;

        Node iter;
        Stack<Node> stack = new Stack<>();
        stack.push(node);

        while (!stack.isEmpty()) {
            iter = stack.pop();
            res.add(iter.key);

            if (iter.rChild != null) stack.push(iter.rChild);
            if (iter.lChild != null) stack.push(iter.lChild); //last in first out
        }
    }

    public List<K> inorder() {
        List<K> ret = new ArrayList<>();
        // inorderRec(root, ret); //recursively
        inorder(root, ret); //iteratively
        return ret;
    }

    //Recursive inorder
    @Deprecated
    private void inorderRec(Node node, List<K> res) {
        if (node == null) return; //exit point

        inorderRec(node.lChild, res);
        res.add(node.key); //visit the node
        inorderRec(node.rChild, res);
    }

    //Iterative inorder
    private void inorder(Node node, List<K> res) {
        Stack<Node> stack = new Stack<>();
        Node iter = node;

        while (iter != null || !stack.isEmpty()) {
            while (iter != null) {
                stack.push(iter);
                iter = iter.lChild;
            }

            Node cur = stack.pop();
            res.add(cur.key);

            iter = cur.rChild;
        }
    }

    //todo: Impl postorder recursively
    public List<K> postOrder() {
        List<K> ret = new ArrayList<>();
        postOrder(root, ret);
        return ret;
    }

    @Deprecated
    public List<K> postOrderRec() {
        List<K> ret = new ArrayList<>();
        postOrderRec(root, ret);
        return ret;
    }

    @Deprecated
    private void postOrderRec(Node node, List<K> res) {
        if (node == null) return;

        postOrderRec(node.lChild, res);
        postOrderRec(node.rChild, res);
        res.add(node.key);
    }

    private void postOrder(Node node, List<K> res) {
        if (node == null) return;
        Node cur = node;
        Node pre = null;
        Stack<Node> stack = new Stack<>();

        while (cur != null || !stack.isEmpty()) {

            while (cur != null) {
                stack.push(cur);
                cur = cur.lChild;
            }

            if (!stack.isEmpty()) {
                cur = stack.peek();

                boolean isBacked = cur.rChild == pre;
                pre = cur;
                if (cur.rChild == null || isBacked) {
                    res.add(stack.pop().key);
                    cur = null;
                } else cur = cur.rChild;
            }
        }
    }

    //Goal (3) Search
    //(3.1) min, removeMin
    public K min() {
        if (size == 0) throw new IllegalArgumentException("BST is empty");
        return min(root).key;
    }

    /**
     * Find the minimum node root at {@code node}
     *
     * @param node
     * @return
     */
    public Node min(Node node) {
        Node cur = node;
        while (cur.lChild != null) cur = cur.lChild;
        return cur;
    }

    // Delete the minimum node in the BST, returns its value
    public K deleteMin() {
        Node min = min(root);
        root = deleteMin(root);
        return min.key;
    }

    /**
     * Delete the minimum node in sub-tree rooted at {@code node}, returns the new root after deletion
     *
     * @param node
     * @return
     */
    private Node deleteMin(Node node) {
        Node cur = node;

        if (cur.lChild != null) cur.lChild = deleteMin(cur.lChild);
        else {
            Node right = cur.rChild;

            cur.rChild = null; //help GC
            size--;

            cur = right;
        }

        return cur;
    }

    //(3.2) todo: max, removeMax

    //Goal (4) Remove
    // Delete value e from entire subtree (if its in the tree)
    public void remove(K key) {
        root = remove(root, key);
    }

    /**
     * Recursively delete value {@code target} in a (sub)-tree root at {@code node}
     * returns the new root
     */
    private Node remove(Node node, K target) {

        if (node == null)
            return null;

        if (target.compareTo(node.key) < 0) {
            node.lChild = remove(node.lChild, target);
            return node;
        } else if (target.compareTo(node.key) > 0) {
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

            // case 2: delete node has no right child
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

    private class Node {
        K key;
        V val;
        Node lChild, rChild;

        Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }

    @Override
    public String toString() {
        String s = levelOrder();
        return "{" + s.substring(0, s.length() - 1) + "}";
    }
}

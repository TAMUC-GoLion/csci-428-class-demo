package edu.tamuc.csci.common.treelike;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class BSTTest {
    BST<Integer, Integer> bst = new BST();

    @Test
    void testInsert() {
        Random rand = new Random(1);
        for(int i = 0; i < 10; i++) {
            int tmp = rand.nextInt(100);
            System.out.println("Inserting: " + tmp);
            bst.insert(tmp, tmp);
        }

        System.out.println(bst);
    }

    @Test
    void testTraversal() {
        Random rand = new Random();
        for(int i = 0; i < 1000000; i++) {
            int tmp = rand.nextInt(Integer.MAX_VALUE);
            // System.out.println("Inserting: " + tmp);
            bst.insert(tmp, tmp);
        }

        //Verify inorder traversal
        List<Integer> tmp = bst.inorder();
        for(int i = 0; i < tmp.size() - 1; i++) {
            assertTrue(tmp.get(i) < tmp.get(i + 1));
        }

        //Verify preorder traversal iteratively
        assertEquals(bst.preorderRec(), bst.preorder());

        //Verify postorder traversal iteratively
        assertEquals(bst.postOrderRec(), bst.postOrder());
    }

    @Test
    void testDeleteMin() {
        Random rand = new Random();
        for(int i = 0; i < 1000000; i++) {
            int tmp = rand.nextInt(Integer.MAX_VALUE);
            bst.insert(tmp, tmp);
        }

        List<Integer> tmp  = bst.inorder();

        int index = 0;
        while(!bst.isEmpty()) {
            assertEquals(bst.deleteMin(), tmp.get(index++));
        }
    }

    @Test
    void testDelete() {

        Random rand = new Random(1);
        List<Integer> pool = new ArrayList<>();

        for(int i = 0; i < 10; i++) {
            int tmp = rand.nextInt(100);
            pool.add(tmp);
            System.out.println("Inserting: " + tmp);
            bst.insert(tmp, tmp);
        }

        //verify the tree
        System.out.println(bst);

        //test randomly delete a value
        bst.remove(pool.get(5)); //only has right child
        System.out.println(bst);

        bst.remove(pool.get(2)); //delete a node has two children
        System.out.println(bst);
    }
}
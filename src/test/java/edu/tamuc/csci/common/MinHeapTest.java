package edu.tamuc.csci.common;

import edu.tamuc.csci.common.treelike.MinHeap;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class MinHeapTest {

    private static final int TOTAL_NUMBER = 1000000;

    @Test
    void test() {
        MinHeap<Integer> heap = new MinHeap<>(3);

        Random random = new Random();
        for(int i = 0; i < TOTAL_NUMBER; i++) {
            heap.offer(random.nextInt(Integer.MAX_VALUE));
        }

        int cur, pre = heap.poll();
        while(!heap.isEmpty()) {
            cur = heap.poll();
            assertTrue(cur >= pre);

            pre = cur;
        }
    }

}
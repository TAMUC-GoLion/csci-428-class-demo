package edu.tamuc.csci.common;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class MinHeapTest {
    private static final int TOTAL_ELEMENTS = 1000000;

    @Test
    void add() {
        MinHeap<Integer> heap = new MinHeap<>();
        Random random = new Random();

        long start = System.currentTimeMillis();
        for(int i = 0; i < TOTAL_ELEMENTS; i++) {
            heap.add(random.nextInt(Integer.MAX_VALUE));
        }

        long elapsed = System.currentTimeMillis() - start;
        System.out.println("Adding " + TOTAL_ELEMENTS + " elements to heap takes " + elapsed + " ms");

        start = System.currentTimeMillis();

        int pre = Integer.MIN_VALUE;
        while(!heap.isEmpty()) {
            int cur = heap.extractMin();
            assertTrue(cur >= pre);
            pre = cur;
        }
        elapsed = System.currentTimeMillis() - start;
        System.out.println("Extracting " + TOTAL_ELEMENTS + " elements from heap takes " + elapsed + " ms");
//        for(int i = 3; i <= 10; i++) heap.add(i);
//        heap.add(1);
//        System.out.println(heap.toString());
//
//        while(!heap.isEmpty()) {
//            System.out.println(heap.extractMin());
//        }
    }
}
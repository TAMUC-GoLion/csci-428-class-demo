package edu.tamuc.csci.algo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {

    @Test
    void test() {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < 100; i++) {
            list.add(i);
        }

        int index = Collections.binarySearch(list, -50);
        assertEquals(index, -1);
        index = Collections.binarySearch(list, 50);
        assertEquals(50, index);
    }
}
package edu.tamuc.csci.common;

import edu.tamuc.csci.common.Basic.Array;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class ArrayTest {

    public static final int MAX = 1000000;

    @BeforeEach
    void setUp() {
        System.out.println("This code will be executed before launching each test case");
    }

    @AfterEach
    void tearDown() {
        System.out.println("This code will be executed after each test case");
    }

    @Test
    @DisplayName("This is a unit test for isEmpty()")
    void testEmpty() {
        System.out.println("This is test 1");
        Array<Integer> arr = new Array<>();
        assertTrue(arr.isEmpty());
    }

    @Test
    @DisplayName("This is test for size()")
    void testSize() {
        System.out.println("This is test 2");

        Array<Character> arr = new Array<>();
        arr.append('A');
        arr.append('b');
        arr.append('c');

        assertEquals(3, arr.size());
    }

    @Test
    @DisplayName("Test bonus")
    void testBonus() {
        Array<Integer> arr = new Array<>();
        //test reverse
//        for(int i = 3; i <= 10; i++) arr.append(i);
//        System.out.println(arr);
//
//        arr.reverse();
//        System.out.println(arr);

        //test sort
        Random random = new Random();

        for(int i = 0; i < MAX; i++) arr.append(random.nextInt(Integer.MAX_VALUE));
        long start = System.currentTimeMillis();
        arr.sort(Integer::compareTo);
        long elapsed = System.currentTimeMillis() - start;
        System.out.println("Sorting " + MAX + " elements use: " + elapsed + "ms");

        for(int i = 0; i < MAX - 1; i++) {
            assertTrue(arr.get(i) <= arr.get(i + 1));
        }
    }
}
package edu.tamuc.csci.common;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayTest {

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
}
package edu.tamuc.csci.common;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

class AStackTest {
    AStack<Integer> stack;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        System.out.println("Before each test");
        stack = new AStack<>();
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        System.out.println("After each test");
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Test (1): test get size of current stack")
    void size() {
        assertEquals(0, stack.size());
        stack.push(1);
        assertEquals(1, stack.size());

        stack.push(2);
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Test (2): isEmpty() test")
    void isEmpty() {
        assertTrue(stack.isEmpty());
        stack.push(3);
        assertFalse(stack.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void push() {
    }

    @org.junit.jupiter.api.Test
    void peek() {
    }

    @org.junit.jupiter.api.Test
    void pop() {
    }

    @org.junit.jupiter.api.Test
    void testToString() {
    }
}
package edu.tamuc.csci.common;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    @Test
    void test() {
        LinkedList<Integer> list = new LinkedList<>();

        for(int i = 3; i <= 10; i++) list.offer(i);
        System.out.println(list);

        list.add(3, 100);
        System.out.println(list);

        while(!list.isEmpty()) {
            list.poll();
            System.out.println(list);
        }
    }

}
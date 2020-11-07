package edu.tamuc.csci.common;

import edu.tamuc.csci.common.Basic.LinkedList;
import org.junit.jupiter.api.Test;

class LinkedListTest {

    @Test
    void test() {
        LinkedList<Integer> list = new LinkedList<>();

        for(int i = 3; i <= 10; i++) list.offer(i);
        System.out.println(list);
        System.out.println(list.get(5));
        System.out.println(list.remove(5));
        System.out.println(list);
        System.out.println(list.remove(list.size() - 1));
        System.out.println(list);
        System.out.println(list.remove(0));
        System.out.println(list);

        list.add(3, 100);
        System.out.println(list);

        while(!list.isEmpty()) {
            list.poll();
            System.out.println(list);
        }
    }

}
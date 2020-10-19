package edu.tamuc.csci.common;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AQueueTest {

    @Test
    void test() {
        AQueue<Integer> que = new AQueue<>(3);

        for(int i = 3; i <= 10; i++) que.offer(i);
        System.out.println(que.toString());

        while (!que.isEmpty()) {
            que.poll();
            System.out.println(que.toString());
        }

    }
}
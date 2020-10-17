package edu.tamuc.csci.common;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BQueueTest {

    @Test
    public void test() {
        BQueue<Integer> que = new BQueue<>(3);
        for (int i = 0; i < 5; i++) {
            que.offer(i);
            System.out.println(que.toString());
        }

        while(!que.isEmpty()) {
            que.poll();
            System.out.println(que.toString());
        }
    }

}
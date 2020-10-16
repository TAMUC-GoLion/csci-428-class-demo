package edu.tamuc.csci.common;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AQueueTest {

    @Test
    public void test() {
        AQueue<Integer> que = new AQueue<>();
        assertTrue(que.isEmpty());

        for(int i = 0; i < 5; i++) {
            que.offer(i);
        }
        assertEquals(0, que.peek());

        while(!que.isEmpty()) {
            System.out.println(que.toString());
            que.poll();
        }

        System.out.println(que.toString());
    }
}
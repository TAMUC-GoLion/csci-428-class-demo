package edu.tamuc.csci.common;

import edu.tamuc.csci.common.QueueAndStack.BQueue;
import org.junit.jupiter.api.Test;

class BQueueTest {

    @Test
    void offer() {
        BQueue<Integer> que = new BQueue<>(3);
        for(int i = 3; i <=10; i++) {
            que.offer(i);
            System.out.println(que.toString());
        }
    }

    @Test
    void poll() {
        BQueue<Integer> que = new BQueue<>(3);
        for(int i = 3; i <=10; i++) {
            que.offer(i);
            System.out.println(que.toString());
        }

        while (!que.isEmpty()) {
            que.poll();
            System.out.println(que.toString());
        }
    }
}
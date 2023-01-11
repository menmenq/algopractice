package multithread;

import java.util.ArrayDeque;
import java.util.Queue;

public class MyBlockingQueue {
    private final Queue<Integer> queue;
    private final int limit;
    MyBlockingQueue(int limit) {
        this.limit = limit;
        this.queue = new ArrayDeque<>(limit);
    }

    synchronized void put(Integer num) throws InterruptedException {
        while (queue.size() == limit) {
            this.wait();
        }
        if (queue.isEmpty()) {
            this.notifyAll();
        }
        queue.add(num);
    }

}

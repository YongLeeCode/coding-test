package stack_queue.create_queue;

import java.util.ArrayList;

public class MyQueue {

    private final int head;
    private int tail;
    private final ArrayList<Integer> queue = new ArrayList<>();

    public MyQueue() {
        this.head = 0;
        this.tail = 0;
    }

    public void add(int value) {
        queue.add(tail, value);
        tail++;
    }

    public int poll() {
        int queuePoll = queue.remove(head);
        tail--;
        return queuePoll;
    }

    public int size() {
        System.out.println(queue);
        return queue.size();
    }
}

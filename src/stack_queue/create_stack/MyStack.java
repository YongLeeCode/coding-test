package stack_queue.create_stack;

import java.util.ArrayList;

public class MyStack {

    private int top;
    private ArrayList<Integer> stackData = new ArrayList<>();

    public MyStack() {
        this.top = -1;
    }

    public void push(int value) {
        top++;
        stackData.add(top, value);
    }

    public int pop() {
        int stackPop = stackData.remove(top);
        top--;
        return stackPop;
    }

    public int size() {
        return top+1;
    }

}

package datastructure.queue;

import java.util.Stack;

public class Queue {

    private final Stack<Integer> oldStack;
    private final Stack<Integer> newStack;

    public Queue() {
        this.oldStack = new Stack<>();
        this.newStack = new Stack<>();
    }

    public void add(int value) {
        oldStack.add(value);
    }

    public int dequeue() {
        int result = Integer.MIN_VALUE;

        if (newStack.isEmpty()) {
            while (!oldStack.isEmpty()) {
                newStack.push(oldStack.pop());
            }
            result = newStack.pop();
        }

        while (!newStack.isEmpty()) {
            oldStack.add(newStack.pop());
        }
        return result;
    }

    @Override
    public String toString() {
        return "Custom Queue";
    }
}

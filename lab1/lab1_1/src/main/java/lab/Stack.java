package lab;

import java.util.LinkedList;

public class Stack {
    private LinkedList<Integer> stack;
    private int top;
    private int size;
    private int maxSize;

    public Stack() {
        this.size = 0;
        stack = new LinkedList<>();
        top = -1;
    }

    public Stack(int maxSize) {
        this.size = 0;
        this.maxSize = maxSize;
        stack = new LinkedList<>();
        top = -1;
    }

    public void push(int item) {
        if (isFull()) {
            throw new StackOverflowError("Stack is full");
        }
        stack.add(item);
        top++;
        size++;
    }

    public int pop() {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("Stack is empty");
        }
        int item = stack.get(top);
        stack.remove(top);
        top--;
        size--;
        return item;
    }

    public int peek() {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("Stack is empty");
        }
        return stack.get(top);
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int getSize() {
        return size;
    }

    public boolean isFull() {
        if (maxSize == 0) {
            return false;
        }
        return size == maxSize;
    }
}
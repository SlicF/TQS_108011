package tqs;

import java.util.Stack;

public class Calculator {
    private Stack<Integer> stack = new Stack<>();

    public Calculator() {
    }

    public void push(int arg2) {
        stack.push(arg2);
    }

    public void push(String string) {
        if (string.equals("+")) {
            int arg2 = stack.pop();
            int arg1 = stack.pop();
            int result = arg1 + arg2;
            stack.push(result);
        } else if (string.equals("-")) {
            int arg2 = stack.pop();
            int arg1 = stack.pop();
            int result = arg1 - arg2;
            stack.push(result);
        } else if (string.equals("*")) {
            int arg2 = stack.pop();
            int arg1 = stack.pop();
            int result = arg1 * arg2;
            stack.push(result);
        } else if (string.equals("/")) {
            int arg2 = stack.pop();
            int arg1 = stack.pop();
            int result = arg1 / arg2;
            stack.push(result);
        } else {
            int value = Integer.parseInt(string);
            stack.push(value);
        }
    }

    public int value() {
        if (stack.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return stack.peek();
    }
}
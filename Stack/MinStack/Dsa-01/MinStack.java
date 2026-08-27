import java.util.*;


class Main {
    public static void main(String[] args) {
        MinStack ms = new MinStack();
        ms.push(5);
        ms.push(3);
        ms.push(7);
        System.out.println(ms.getMin()); // Expected: 3
        ms.pop();
        System.out.println(ms.getMin()); // Expected: 3
    }
}


class MinStack {
    private Stack<Integer> stack;     // normal stack
    private Stack<Integer> minStack;  // stack to track minimums

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        // push x into stack
        stack.push(x);
        // if minStack empty OR x <= minStack.peek(), push x into minStack too
        if(minStack.isEmpty() || x <= minStack.peek()){
            minStack.push(x);
        }
    }

    public void pop() {
        // pop from stack
        int x = stack.pop();
        // if popped value == minStack.peek(), pop from minStack too
        if(x == minStack.peek()){
            minStack.pop();
        }
    }

    public int top() {
        // return stack.peek()
        int x = stack.peek();
        return x; // placeholder
    }

    public int getMin() {
        // return minStack.peek()

        return minStack.peek(); // placeholder
    }
}

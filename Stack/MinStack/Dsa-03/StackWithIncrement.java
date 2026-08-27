import java.util.*;

class Main {
    public static void main(String[] args) {
        StackWithIncrement s = new StackWithIncrement();

        s.push(1);
        s.push(2);
        s.push(3);
        s.printStack(); // [1, 2, 3]

        s.increment(2, 5);
        s.printStack(); // [6, 7, 3]

        s.pop();
        s.printStack(); // [6, 7]
    }
}

class StackWithIncrement {
    private Stack<Integer> stack;

    public StackWithIncrement() {
        stack = new Stack<>();
    }

    public void push(int x) {
        // TODO: push x into stack
        stack.push(x);
    }

    public void pop() {
        // TODO: pop from stack
        if (!stack.isEmpty()) { // safer
            stack.pop();
        }
    }

    public void increment(int k, int val) {
        // TODO: add val to bottom k elements
        for (int i = 0; i < k && i < stack.size(); i++) {
            stack.set(i, val + stack.get(i));
        }
    }

    public void printStack() {
        // TODO: print stack
        System.out.println(stack);
    }
}

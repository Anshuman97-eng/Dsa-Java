import java.util.*;

class Main {
    public static void main(String[] args) {
        MaxStack ms = new MaxStack();

        // Test operations
        ms.push(5);
        ms.push(3);
        ms.push(7);

        System.out.println("Current Max: " + ms.getMax()); // Expected: 7
        System.out.println("Top Element: " + ms.top());    // Expected: 7

        ms.pop(); // removes 7

        System.out.println("Current Max: " + ms.getMax()); // Expected: 5
        System.out.println("Top Element: " + ms.top());    // Expected: 3
    }
}


class MaxStack {
    private Stack<Integer> stack;     // normal stack
    private Stack<Integer> maxStack;  // stack to track maximums

    public MaxStack() {
        stack = new Stack<>();
        maxStack = new Stack<>();
    }

    public void push(int x) {
        // TODO: push x into stack
        stack.push(x);
        // TODO: if maxStack empty OR x >= maxStack.peek(), push x into maxStack too
        if(maxStack.isEmpty() || maxStack.peek() <= x){
            maxStack.push(x);
        }
    }

    public void pop() {
        // TODO: pop from stack
        int x = stack.pop();
        // TODO: if popped value == maxStack.peek(), pop from maxStack too
        if(x == maxStack.peek()){
            maxStack.pop();
        }
    }

    public int top() {
        // TODO: return stack.peek()

        return stack.peek(); // placeholder
    }

    public int getMax() {
        // TODO: return maxStack.peek()
        return maxStack.peek(); // placeholder
    }
}

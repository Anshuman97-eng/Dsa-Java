import java.util.*;


class Main {
    public static void main(String[] args) {
        MyQueue q = new MyQueue();

        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);

        System.out.println("Front: " + q.front()); // Expected: 1
        System.out.println("Dequeue: " + q.dequeue()); // Removes 1
        System.out.println("Dequeue: " + q.dequeue()); // Removes 2

        q.enqueue(4);
        System.out.println("Front: " + q.front()); // Expected: 3
        System.out.println("Dequeue: " + q.dequeue()); // Removes 3
        System.out.println("Dequeue: " + q.dequeue()); // Removes 4
    }
}


class MyQueue {
    private Stack<Integer> inStack;
    private Stack<Integer> outStack;

    public MyQueue() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    // TODO: implement enqueue
    public void enqueue(int x) {
        // your code here
        inStack.add(x);
    }

    // TODO: implement dequeue
    public int dequeue() {
        // your code here
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.add(inStack.pop());
            }
        }

        if (!outStack.isEmpty()) {
            return outStack.pop();
        }

        return -1; // placeholder
    }

    // TODO: implement front
    public int front() {
        // your code here
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.add(inStack.pop());
            }
        }

        if (!outStack.isEmpty()) {
            return outStack.peek();
        }
        return -1; // placeholder
    }

    // TODO: implement isEmpty
    public boolean isEmpty() {
        
        return inStack.isEmpty() && outStack.isEmpty();
        // placeholder
    }
}

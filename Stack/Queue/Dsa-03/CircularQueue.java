

class Main {
    public static void main(String[] args) {
        CircularQueue cq = new CircularQueue(3);

        System.out.println(cq.enqueue(1)); // Expected: true
        System.out.println(cq.enqueue(2)); // Expected: true
        System.out.println(cq.enqueue(3)); // Expected: true
        System.out.println(cq.enqueue(4)); // Expected: false (queue full)

        System.out.println("Front: " + cq.Front()); // Expected: 1
        System.out.println("Rear: " + cq.Rear()); // Expected: 3

        System.out.println(cq.dequeue()); // Expected: true
        System.out.println(cq.enqueue(4)); // Expected: true (wrap around)

        System.out.println("Front: " + cq.Front()); // Expected: 2
        System.out.println("Rear: " + cq.Rear()); // Expected: 4
    }
}


class CircularQueue {
    private int[] arr;
    private int front, rear, size, currSize;

    public CircularQueue(int k) {
        arr = new int[k];
        size = k;
        front = -1;
        rear = -1;
        currSize = 0;
    }

    // TODO: implement enqueue
    public boolean enqueue(int x) {
        if (isFull())
            return false; // queue full

        if (front == -1) {
            front = 0;
        }

        rear = (rear + 1) % size;
        arr[rear] = x;
        currSize++;
        return true;
    }

    // TODO: implement dequeue
    public boolean dequeue() {
        if (isEmpty())
            return false;

        if (front == rear) {
            front = -1;
            rear = -1; // reset
        } else {
            front = (front + 1) % size;
        }
        currSize--; // reduce size
        return true;
    }

    // TODO: implement Front
    public int Front() {
        // your code here
        if (isEmpty()) {
            return -1;
        }

        if (front == -1) {
            return -1;
        }

        int val = arr[front];

        return val; // placeholder
    }

    // TODO: implement Rear
    public int Rear() {
        // your code here
        if (isEmpty()) {
            return -1;
        }

        if (rear == -1) {
            return -1;
        }

        int val = arr[rear];

        return val; // placeholder
    }

    // TODO: check if empty
    public boolean isEmpty() {
        // your code here

        return currSize == 0; // placeholder
    }

    // TODO: check if full
    public boolean isFull() {
        // your code here
        return currSize == size; // placeholder
    }
}

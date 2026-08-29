

class MyCircularDeque {
    private int[] arr;
    private int front, rear, size, capacity;

    public MyCircularDeque(int k) {
        arr = new int[k];
        capacity = k;
        front = 0;
        rear = -1;
        size = 0;
    }

    // Insert at front
    public boolean insertFront(int value) {
        if (isFull()) return false;
        front = (front - 1 + capacity) % capacity;
        arr[front] = value;
        size++;
        return true;
    }

    // Insert at rear
    public boolean insertLast(int value) {
        if (isFull()) return false;
        rear = (rear + 1) % capacity;
        arr[rear] = value;
        size++;
        return true;
    }

    // Delete front
    public boolean deleteFront() {
        if (isEmpty()) return false;
        front = (front + 1) % capacity;
        size--;
        return true;
    }

    // Delete rear
    public boolean deleteLast() {
        if (isEmpty()) return false;
        rear = (rear - 1 + capacity) % capacity;
        size--;
        return true;
    }

    // Get front
    public int getFront() {
        if (isEmpty()) return -1;
        return arr[front];
    }

    // Get rear
    public int getRear() {
        if (isEmpty()) return -1;
        return arr[rear];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    // Main method for testing
    public static void main(String[] args) {
        MyCircularDeque deque = new MyCircularDeque(5);

        System.out.println("InsertFront(10): " + deque.insertFront(10));
        System.out.println("InsertLast(20): " + deque.insertLast(20));
        System.out.println("GetFront(): " + deque.getFront());
        System.out.println("GetRear(): " + deque.getRear());
        System.out.println("DeleteFront(): " + deque.deleteFront());
        System.out.println("DeleteLast(): " + deque.deleteLast());
        System.out.println("IsEmpty(): " + deque.isEmpty());
        System.out.println("IsFull(): " + deque.isFull());
    }
}

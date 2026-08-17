class reverseBetween {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node reverseBetweens(Node head, int left, int right) {

        // Your logic here

        Node dummy = new Node(0);
        dummy.next = head;

        Node before = dummy;

        for (int i = 1; i < left; i++) {
            before = before.next;
        }

        Node prev = null;
        Node curr = before.next;

        for (int i = 0; i <= right - left; i++) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node first = before.next;
        before.next = prev;
        first.next =  curr;

        return head;

    }

    public static void main(String[] args) {

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        int left = 2;
        int right = 4;

        head = reverseBetweens(head, left, right);

        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}
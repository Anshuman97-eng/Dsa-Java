public class removeNthFromEnd {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node removeNthFromEnds(Node head, int n) {

        // Write your logic here

        Node fast = head;
        Node slow = head;
        int k = 1;

        while (k <= n) {
            fast = fast.next;
            k++;
        }

        if (fast == null) {
            return head.next;
        }

        Node prev = null;

        while (fast != null) {
            prev = slow;
            fast = fast.next;
            slow = slow.next;
        }

        prev.next = prev.next.next;
        return head;
    }

    public static void main(String[] args) {

        // Create Linked List
        Node head = new Node(1);

        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        int n = 2;

        // Call function
        head = removeNthFromEnds(head, n);

        // Print Linked List
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}
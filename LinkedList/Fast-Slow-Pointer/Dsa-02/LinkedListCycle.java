public class LinkedListCycle {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static boolean hasCycle(Node head) {

        Node slow = head;
        Node fast = head;

        // Write your logic here

        while( fast != null && fast.next != null ){
            if(fast == slow ){
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }


        return false;
    }

    public static void main(String[] args) {

        Node head = new Node(1);

        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        // Create cycle: 5 -> 4
        head.next.next.next.next.next = head.next.next.next;

        System.out.println(hasCycle(head));
    }
}
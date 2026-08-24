public class RemoveDuplicatesFromSortedList {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node removeDuplicates(Node head) {

        // Write your logic here
        Node slow = head;

        while (slow != null) {
            if (slow.data == slow.next.data) {
                slow.next = slow.next.next;
            } 
            slow = slow.next;
        }

        return head;
    }

    public static void main(String[] args) {

        Node head = new Node(1);

        head.next = new Node(1);
        head.next.next = new Node(2);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(3);

        head = removeDuplicates(head);

        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}
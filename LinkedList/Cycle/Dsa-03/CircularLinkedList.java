class CircularLinkedList {

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        // Make it circular
        head.next.next.next.next = head;

        System.out.println(isCircular(head));
    }

    public static boolean isCircular(ListNode head) {

        // Write your logic here
        ListNode curr = head.next;

        while(curr != null && curr != head){
            curr = curr.next;
        }

        return curr == head;
    }
}

class ListNode {

    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}
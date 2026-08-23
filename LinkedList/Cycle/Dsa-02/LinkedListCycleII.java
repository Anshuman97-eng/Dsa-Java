class LinkedListCycleII {

    public static void main(String[] args) {

        // 1 -> 2 -> 3 -> 4 -> 5
        //           ↑       |
        //           └───────┘

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // Create cycle: 5 -> 3
        head.next.next.next.next.next = head.next.next;

        ListNode result = detectCycle(head);

        if (result != null) {
            System.out.println(result.val);
        }
    }

    public static ListNode detectCycle(ListNode head) {

        // Phase 1: Detect cycle

        ListNode slow = head;
        ListNode fast = head;

        // Phase 2: Find cycle starting node
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;

            if(slow == fast){
                slow = head;
                while(fast != slow){
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }

        return null;
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
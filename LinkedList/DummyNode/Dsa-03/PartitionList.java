// PartitionList.java

public class PartitionList {
    public static ListNode partition(ListNode head, int x) {
        // Hint: use two dummy nodes (beforeDummy, afterDummy)
        // and two pointers (before, after).
        // Traverse until head == null
        // Condition: while (head != null)

        ListNode beforeDummy = new ListNode(0);
        ListNode afterDummy = new ListNode(0);
        ListNode after = afterDummy;
        ListNode before = beforeDummy;

        while(head != null){
            if(head.val < x){
                before.next = head;
                before = before.next;
            }else{
                after.next = head;
                after = after.next;
            }

            head = head.next;
        }

        after.next = null;
        before.next = afterDummy.next;


        return beforeDummy.next;
    }

    // Helper to print list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Build sample list: 1 -> 4 -> 3 -> 2 -> 5 -> 2
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);

        System.out.println("Original List:");
        printList(head);

        // Call your function
        head = partition(head, 3);

        System.out.println("After Partition:");
        printList(head);
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int v) { val = v; }
}


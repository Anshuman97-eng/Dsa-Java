

public class IntersectionWithDifference {

    // Function to find intersection
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 👉 your logic goes here
        if(headA == null || headB == null){
            return null;
        }

        ListNode a = headA;
        ListNode b = headB;

        while(a != b){
            a = (a == null) ? headB : a.next;
            b = (b == null) ? headA : b.next;
        }

        return a;
    }

    // Driver code
    public static void main(String[] args) {
        // Build sample lists with intersection
        ListNode common = new ListNode(8);
        common.next = new ListNode(9);

        ListNode headA = new ListNode(1);
        headA.next = new ListNode(2);
        headA.next.next = new ListNode(3);
        headA.next.next.next = new ListNode(4);
        headA.next.next.next.next = new ListNode(5);
        headA.next.next.next.next.next = common;

        ListNode headB = new ListNode(6);
        headB.next = new ListNode(7);
        headB.next.next = common;

        // Call function
        ListNode intersection = getIntersectionNode(headA, headB);

        if (intersection != null)
            System.out.println("Intersection at node: " + intersection.val);
        else
            System.out.println("No intersection");
    }
}

// Node definition
class ListNode {
    int val;
    ListNode next;
    ListNode(int v) { val = v; }
}
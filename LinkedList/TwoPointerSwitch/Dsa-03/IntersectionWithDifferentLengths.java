

public class IntersectionWithDifferentLengths {

    // Function to find intersection
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        // Step 1: find lengths
        int lenA = getLength(headA);/* your code */;
        int lenB = getLength(headB);/* your code */;

        // Step 2: calculate difference
        int diff = (lenA > lenB) ? lenA - lenB : lenB- lenA ;/* your code */;

        // Step 3: move longer list ahead by diff
        if (lenA > lenB) {
            /* your code */
            while(diff != 0){
                headA = headA.next;
                diff--;
            }
        } else {
            /* your code */
            while(diff != 0){
                headB = headB.next;
                diff--;
            }
        }

        // Step 4: walk both together until intersection
        while (headA != null && headB != null) {
            if (headA == headB) return headA;
            /* your code */
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

    // Helper to count length
    private static int getLength(ListNode node) {
        /* your code */
        ListNode curr = node;
        int length = 0;

        while(curr != null){
            curr = curr.next;
            length++;
        }

        return length;
    }

    // Driver code
    public static void main(String[] args) {
        // Build sample lists with intersection
        /* your code to build lists */

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

        ListNode intersection = getIntersectionNode(headA,headB);
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
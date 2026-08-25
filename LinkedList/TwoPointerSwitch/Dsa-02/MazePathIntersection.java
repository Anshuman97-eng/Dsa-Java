

public class MazePathIntersection {

    // Function to find intersection using two-pointer switching
    public static Node getIntersectionNode(Node headA, Node headB) {
        if(headA == null || headB == null){
            return null;
        }

        Node a = headA;
        Node b = headB;

        while(a != b){
            a = (a == null) ? headB : a.next;
            b = (b == null) ? headA : b.next;
        }

        return a; // intersection node or null
    }

    // Driver code
    public static void main(String[] args) {
        // Build sample paths with intersection
        Node common = new Node("X");
        common.next = new Node("Y");

        Node headA = new Node("A");
        headA.next = new Node("B");
        headA.next.next = new Node("C");
        headA.next.next.next = new Node("D");
        headA.next.next.next.next = new Node("E");
        headA.next.next.next.next.next = common;

        Node headB = new Node("P");
        headB.next = new Node("Q");
        headB.next.next = new Node("R");
        headB.next.next.next = common;

        Node intersection = getIntersectionNode(headA, headB);
        if (intersection != null)
            System.out.println("Intersection at node: " + intersection.val);
        else
            System.out.println("No intersection");
    }
}


// Node definition
class Node {
    String val;
    Node next;
    Node(String v) { val = v; }
}
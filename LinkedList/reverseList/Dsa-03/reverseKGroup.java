public class reverseKGroup {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Find the Kth node from temp
    public static Node findKthNode(Node temp, int k) {

        int count = 1;

        while (temp != null && count < k) {
            temp = temp.next;
            count++;
        }

        return temp;
    }

    // Reverse the linked list
    public static void reverse(Node temp) {

        Node curr = temp;
        Node prev = null;

        while (curr != null) {

            Node next = curr.next;

            curr.next = prev;

            prev = curr;
            curr = next;
        }
    }

    // Reverse linked list in groups of K
    public static Node reverseKGroups(Node head, int k) {

        Node temp = head;

        // Stores the end of the previous reversed group
        Node prevNode = null;

        while (temp != null) {

            // Find Kth node
            Node kth = findKthNode(temp, k);

            // If less than K nodes remain
            if (kth == null) {
                break;
            }

            // Save the beginning of next group
            Node newNode = kth.next;

            // Cut the current group
            kth.next = null;

            // Reverse current group
            reverse(temp);

            // Connect previous group with current group
            if (prevNode == null) {

                // First group
                head = kth;

            } else {

                prevNode.next = kth;
            }

            // temp is now the end of current reversed group
            prevNode = temp;

            // Move to next group
            temp = newNode;
        }

        return head;
    }

    public static void main(String[] args) {

        // Create linked list
        Node head = new Node(1);

        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        int k = 3;

        // Reverse in groups of K
        head = reverseKGroups(head, k);

        // Print result
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}
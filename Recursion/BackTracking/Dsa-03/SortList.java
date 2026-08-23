

class SortList {

    public static void main(String[] args) {

        // 4 -> 2 -> 1 -> 3
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);

        head = sortList(head);

        // Print result
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public static ListNode findMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static ListNode sortList(ListNode head) {

        // Write your code here
        if(head == null || head.next == null){
            return head;
        }

        ListNode mid = findMid(head);

        ListNode left = head;
        ListNode right = mid.next;
        mid.next = null;

        left = sortList(left);
        right = sortList(right);
        return merge(left, right);

    }

    public static ListNode merge(ListNode left, ListNode right) {

        // Write your merge logic here
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while(left != null && right != null){
            if(left.val < right.val){
                temp.next = left;
                temp = left;
                left = left.next;
            }else{
                temp.next = right;
                temp = right;
                right = right.next;
            }
        }

        if(left != null){
            temp.next = left;
        }else{
            temp.next = right;
        }

        return dummy.next;
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
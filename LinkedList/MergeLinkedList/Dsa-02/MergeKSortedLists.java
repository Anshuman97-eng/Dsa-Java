class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        // Write your code here

        ListNode result = null;

        for (ListNode node : lists) {
            result = mergeTwoLists(result, node);
        }

        return result;
    }

    // You will use this method
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Write your merge logic here
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (list1 != null && list2 != null) {

            if (list1.val <= list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }

            curr = curr.next;
        }

        if (list1 != null) {
            curr.next = list1;
        } else {
            curr.next = list2;
        }

        return dummy.next;

    }

    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);

        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(5);

        ListNode l3 = new ListNode(3);
        l3.next = new ListNode(6);

        ListNode[] lists = { l1, l2, l3 };

        MergeKSortedLists obj = new MergeKSortedLists();

        ListNode result = obj.mergeKLists(lists);

        while (result != null) {
            System.out.print(result.val);

            if (result.next != null) {
                System.out.print(" -> ");
            }

            result = result.next;
        }
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
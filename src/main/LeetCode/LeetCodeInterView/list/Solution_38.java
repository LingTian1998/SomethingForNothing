package list;

public class Solution_38 {
//    public ListNode reverseList(ListNode head) {  //70ms
//        if (head == null)
//            return null;
//        if (head.next == null)
//            return head;
//
//        ListNode temp = reverseList(head.next);
//        ListNode newHead = temp;
//        for (;temp.next!=null; temp = temp.next);
//
//        temp.next = head;
//        head.next = null;
//        return newHead;
//    }


    public static ListNode newHead = null;
    public ListNode reverseList(ListNode head) {   // 0ms 100%
        newHead = null;
        solve(head);
        return newHead;
    }
    public ListNode solve(ListNode temp){
        if (temp == null)
            return temp;
        if (temp.next == null){
            newHead = temp;
            return temp;
        }

        ListNode lastNode = solve(temp.next);
        temp.next = null;
        lastNode.next = temp;
        return temp;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
